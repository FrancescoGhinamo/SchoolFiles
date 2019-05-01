using BotteroCoreImplementationsPortable.Exceptions;
using BotteroCoreImplementationsPortable.Helpers.MathHelpers;
using ControlPortable.Interfaces.ISLine;
using Functions.Sparse;
using System.Collections.Generic;
using System.Linq;
using System;
using DfsTypes.Extension;
using System.IO;

using ControlPortable.PlungerCycle.LineInterpolation;

namespace ControlPortable.PlungerCycle
{
    /// <summary>
    /// Representation of plunger motion information
    /// </summary>
    public class PlungerCycleInfo : IPlungerCycleInfo
    {
        private object _firstStepHeightLock = new object();

        #region IPlungerCycleInfo

        /// <summary>
        /// Cycle's number
        /// </summary>
        public int CicleNumber { get; }

        /// <summary>
        /// Determines whether the cycle is valid
        /// </summary>
        public bool IsValid { get; }

        /// <summary>
        /// Plunger cycle's pressure profile
        /// </summary>
        public IPressureProfile CyclePressureProfile { get; }

        /// <summary>
        /// Plunger motion cycle's times
        /// </summary>
        public IEnumerable<double> CycleMotionTimes
        {
            get
            {
                return _times?.ToList();
            }
        }

        /// <summary>
        /// Plunger motion cycle's heights
        /// </summary>
        public IEnumerable<double> CycleMotionHeights
        {
            get
            {
                return _heights?.ToList();
            }
        }

        /// <summary>
        /// Pressure time
        /// </summary>
        public double DwellTime { get; }

        /// <summary>
        /// Plunger's initial height
        /// </summary>
        public double InitialHeight
        {
            get
            {
                /*
                 * ritorna il valore dell'altezza iniziale del pistone se:
                 * - il vettore delle altezze e' inizializzato
                 * - l'indice e' compreso entro i limiti dell'array _heights indipendentemente dal suo valore che e' calcolato da altri metodi
                 * 
                 * Se le condizioni non sono soddisfatte viene ritornato 0.0
                 */
                return _heights != null && _iFirst >= 0 && _iFirst < _heights.Count ? _heights[_iFirst] : 0.0;
            }
        }

        /// <summary>
        /// Plunger's final height
        /// </summary>
        public double FinalHeight
        {
            get
            {
                //altezza finale del pistone imponendo le stesse condizioni del metodo precedente
                return _heights != null && _iLast >= 0 && _iLast < _heights.Count ? _heights[_iLast] : 0.0;
            }
        }

        /// <summary>
        /// Indice del primo step
        /// </summary>
        private const int _iFirstStep = 1;

        /// <summary>
        /// Plunger's height at the end of the first step
        /// </summary>
        public double FirstStepHeight
        {
            get
            {
                if (_hTable == null)
                {
                    return double.NaN;
                }

                lock (_firstStepHeightLock)
                {
                    return _hTable[CyclePressureProfile.ProfileLevelEndTime[_iFirstStep]];
                }
            }
        }

        
        public string ControlDetails { get; set; }

        /// <summary>
        /// Time information about dwell phase start
        /// </summary>
        public double tDwellStart { get; set; }
        /// <summary>
        /// Time information about dwell phase start
        /// </summary>
        public double tDwellEnd { get; set; }


        /// <summary>
        /// Gain K1 control
        /// </summary>
        public double ControlGainK1 { get; set; }

        /// <summary>
        /// Gain K2 control
        /// </summary>
        public double ControlGainK2 { get; set; }

        /// <summary>
        /// Real duration between the end of first step and beginning of the dwell phase
        /// </summary>
        public double SecondStepRealDuration { get; set; } //SM Durata reale tra fine del primo step ed inzio DwellTime, dove voglio valutare guadagno K2


        /// <summary>
        /// Get absolute start time of pressure profile
        /// </summary>
        /// <returns>Absolute start time of pressure profile (effettivo inizio aumento di pressione)</returns>
        public double GetPressureAbsoluteStartTime()
        {
            var startTime = 0.0;
            if (CyclePressureProfile != null && _times?.Count > _iFirst)
            {
                double pressureStartPhase = CyclePressureProfile.StartPhase + (CyclePressureProfile.StartPhase < _profileStartPhase ? AngleMath.RoundAngle : 0);
                startTime = _timePhaseConverter.ConvertToTime(pressureStartPhase);
            }
            return startTime;
        }

        /// <summary>
        /// Calculus of plunger height in first step
        /// </summary>
        /// <param name="percentFirstHeight">Percentage of plunger elevation on the total plunger possible motion</param>
        /// <returns>Plunger height</returns>
        public double GetRequestedFirstStepHeight(double percentFirstHeight) => (FinalHeight - InitialHeight) * percentFirstHeight / 100.0 + InitialHeight;

        #endregion IPlungerCycleInfo

        
        #region Constructor

        /// <summary>
        /// List of time values for the just ran cycle
        /// </summary>
        private List<double> _times;

        /// <summary>
        /// List of height values for the just ran cycle
        /// </summary>
        private List<double> _heights;

        /// <summary>
        /// LookUpTable got from the region of interest of the measured sample
        /// </summary>
        private LookUpTable _hTable;

        /// <summary>
        /// Phase converter between time and degrees
        /// </summary>
        private AngleMath.TimePhaseConverter _timePhaseConverter;

        /// <summary>
        /// Profile initial phase
        /// </summary>
        private double _profileStartPhase;

        /// <summary>
        /// Valid relative plunger height threshold for the dwell phase
        /// </summary>
        private const double _dhRelativeValidProfileTreshold = 0.1;


        /// <summary>
        /// Dwell time data record for times calculated usig the "old" method
        /// </summary>
        private static Queue<double> dwellTimesOld = new Queue<double>();
        /// <summary>
        /// Dwell time data record for times calculated usig the "new" method
        /// </summary>
        private static Queue<double> dwellTimesNew = new Queue<double>();

        /// <summary>
        /// FileStream to save dwell time data
        /// </summary>
        private static FileStream dwellTimesLogFile = new FileStream("C:\\Bottero\\PMC\\DwellTimeStudy.txt", FileMode.Create);
        private static StreamWriter dwellTimesLog = new StreamWriter(dwellTimesLogFile);

        /// <summary>
        /// Varable to memorize if it is the first time the constructor has run
        /// </summary>
        private static bool firstRun = true;


        /// <summary>
        /// Creates a new instance of <see cref="PlungerCycleInfo"/>
        /// </summary>
        /// <param name="cicleNumber">cycle number</param>
        /// <param name="pressureProfile">pressure profile</param>
        /// <param name="times">cycle times</param>
        /// <param name="heights">cycle heigts</param>
        /// <param name="validCycle">true if is a valid cycle</param>
        /// <param name="profileStartPhase">profile's starting phase (degree, not negative)</param>
        private PlungerCycleInfo(int cicleNumber,
                                IPressureProfile pressureProfile,
                                IEnumerable<double> times,
                                IEnumerable<double> heights,
                                bool validCycle,
                                double profileStartPhase = double.NaN,
                                double tDwellStartPrev = 0.0,
                                double tDwellEndPrev = 0.0)
        {
            ArgumentError.ThrowIfNull(pressureProfile, nameof(pressureProfile));
            ArgumentError.ThrowIfNull(times, nameof(times));
            ArgumentError.ThrowIfNull(heights, nameof(heights));
            ArgumentError.ThrowIfSetsNotCompatible(times, nameof(times), heights, nameof(heights));

            //impostazione valori ciclo precedente
            tDWellStartPrev = tDwellStartPrev;
            tDWellEndPrev = tDwellEndPrev;

            //numero del ciclo (contatore)
            CicleNumber = cicleNumber;

            //validita' del ciclo
            IsValid = validCycle;

            //profilo pressione del ciclo
            CyclePressureProfile = pressureProfile;

            //lista dei tempi del ciclo
            _times = times.ToList();
            //lista delle altezze del maschio durante il ciclo
            _heights = heights.ToList();
            //istanza del convertitore tempo - gradi sull'avanzamento del ciclo
            _timePhaseConverter = AngleMath.TimePhaseConverter.New(CyclePressureProfile.TCycle);

            //array locali per per il successivo calcolo del dwell time
            var _timesForDwellStart = _times;
            var _heightsForDwellStart = _heights;


            //individuazione della regione di intersse per il profilo di misurazione
            GetProfileRegionOfInterest(profileStartPhase);


            //numero di valori utili riguardanti il ciclo
            var count = _iLast - _iFirst + 1;

            if (_iFirst >= 0 && count >= 0)
            {
                //estrapolazione della zona di interesse (dal punto di salita (dopo attesa) alla diminuzione di pressione)
                var iHTable = Enumerable.Range(_iFirst, count);
                var xSamples = iHTable.Select(i => _times[i] - _times[_iFirst]);
                var ySamples = iHTable.Select(i => _heights[i]);
                _hTable = LookUpTable.New(xSamples, ySamples);

                //variazione relativa dell'altezza del maschio
                var v = (FinalHeight - InitialHeight) / FinalHeight;

                if (FinalHeight == 0 || v < _dhRelativeValidProfileTreshold || _hTable == null)
                {
                    IsValid = false;
                }
            }
            else
            {
                IsValid = false;
            }

            if (IsValid)
            {
                //DwellTime = CalculateDwellTime();

                //calcolo del dwell time con algoritmo "vecchio"
                //DwellTime = CalculateDwellTime(_timesForDwellStart, _heightsForDwellStart);
                //calcolo del dwell time con algoritmo opzionale
                DwellTime = CalculateDwellTimeNew(times, heights);


                //aggiunta dei dwell time calcolati con entrambi gli algoritmi agli oggetti Queue
                dwellTimesOld.Enqueue(DwellTime);
                var dwellTimeBis = CalculateDwellTime(times, heights);
                var dwellTimeBisBis = CalculateDwellTimeNew(times, heights);
                dwellTimesNew.Enqueue(dwellTimeBisBis);

                //calcolo della varianza per entrambi gli oggetti queue
                var oldAlgVar = dwellTimesOld.Variance();





                var newAlgVar = dwellTimesNew.Variance();

                
                if(firstRun)
                {
                    dwellTimesLog.WriteLine("dwell time vecchio\tdwell time nuovo\tdwell time ultimo");
                    
                    firstRun = false;
                }
                
                //stringa da memorizzare sul file
                string strLine = string.Format("{0}\t\t\t{1}\t\t\t{2}", DwellTime.ToString(), dwellTimeBis.ToString(), dwellTimeBisBis.ToString(), oldAlgVar.ToString(), newAlgVar.ToString());
                //salvataggio su file
                dwellTimesLog.WriteLine(strLine);
                dwellTimesLog.Flush();

                //test per visualizzare differenza tra i due algoritmi
                //DwellTime = TestDwellTimeAlgorithms(cicleNumber, _timesForDwellStart, _heightsForDwellStart, times, heights);





                //SM Prendo valore di altezza alla fine del secondo step
                //double secondStepEndTime = pressureProfile.ProfileLevelEndTime[2];// + GetPressureAbsoluteStartTime(); //Fine secondo step di pressione
                //HeightAtEndOfSecondStep = _heightsForDwellStart[_timesForDwellStart.FindIndex(t => t > secondStepEndTime)] / _heightsForDwellStart.Max();

                //SM Calcolo DwellTimeStart con i tempi assoluti (altrimenti poi sul grafico non torna nulla)
                //double hDwellMin = (FinalHeight - InitialHeight) * (1 - _hConstRelativeTolerance) + InitialHeight;
                //var tList = _timesForDwellStart;
                //var hList = _heightsForDwellStart;
                //int iDwellStart = hList.FindIndex(h => h >= hDwellMin);
                //tDwellStart = tList[iDwellStart];


            }
            else
            {
                DwellTime = double.NaN;
            }
        }




        /// <summary>
        /// Creates a new instance of <see cref="PlungerCycleInfo"/> from pluger's motion data
        /// </summary>
        /// <param name="cicleNumber">cicle number</param>
        /// <param name="pressureProfile">pressure profile</param>
        /// <param name="times">cycle times</param>
        /// <param name="heights">cycle heigts</param>
        /// <param name="validCycle">true if is a valid cycle (cycles are valid by default)</param>
        /// <param name="profileStartPhase">profile's starting phase (degree, not negative)</param>
        /// <remarks>If motion data isn't good a null cycle info is returned</remarks>
        public static IPlungerCycleInfo FromPlungerMotionData(int cicleNumber, IPressureProfile pressureProfile, IEnumerable<double> times, IEnumerable<double> heights, bool validCycle = true, double profileStartPhase = double.NaN, double tDwellStartPrev = 0.0, double tDwellEndPrev = 0.0)
        {
            PlungerCycleInfo cycleInfo = null;
            try
            {
                //invocazione del costruttore di PlungerCycleInfo passando come parametri i parametri passati a questo metodo
                cycleInfo = new PlungerCycleInfo(cicleNumber, pressureProfile, times, heights, validCycle, profileStartPhase, tDwellStartPrev, tDwellEndPrev);
            }
            catch
            {
                // If exception is thrown, plunger's motion profile is not valid.
            }
            return cycleInfo;
        }

        /// <summary>
        /// Default contructor for PlungerCycleInfo
        /// </summary>
        private PlungerCycleInfo()
        {
        }

        /// <summary>
        /// Generation and return of an interface generated calling the defualt contructor of PlungerCycleInfo
        /// </summary>
        /// <returns>Interface generated from default contructor</returns>
        public static IPlungerCycleInfo Default() => new PlungerCycleInfo();

        #endregion Constructor

        #region CutProfileAndDwellTime
        /// <summary>
        /// First index of the region of interest in the measured sample
        /// </summary>
        private int _iFirst;

        /// <summary>
        /// Last index of the region of interest
        /// </summary>
        private int _iLast;
       
        /// <summary>
        /// Relative tollerance set on plunger height
        /// </summary>
        private const double _hConstRelativeTolerance = 0.01;


        /// <summary>
        /// Maximum relative tollerance
        /// </summary>
        private const double _hMaxRelativeTolerance = 0.005;

        /// <summary>
        /// Time information about cycle beginning
        /// </summary>
        private double tStart = 0.0;


       
        /// <summary>
        /// Detection of the region of interest in the measured sample
        /// </summary>
        /// <param name="profileStartPhase">beginning phase of measure profile</param>
        private void GetProfileRegionOfInterest(double profileStartPhase)
        {
            double profileStartTime;
            if (true)//double.IsNaN(profileStartPhase)) //SM 06/2018 Per adesso faccio così. E' l'unico modo di valutare correttamente il tempo di pressata, altrimenti veniva tagliato un pezzo (probabilmente perchè il conto in else si basa sul profilo di pressione)
            {
                //massima altezza ragguinta dal pistone
                double hMax = _heights.Max();
                //altezza taglio dopo la pressata
                double hCut = (1 - _hMaxRelativeTolerance) * hMax;
                //ultimo indice relativo a un dato appartenente alla pressata
                _iLast = _heights.FindLastIndex(h => h >= hCut);
                //tempo di fine della pressata
                double tEnd = _times[_iLast];
                //tempo di inizio del ciclo
                tStart = tEnd - CyclePressureProfile.ProfileTotalDuration;
                //primo indice relativo all'inizio del ciclo (in base al tempo)
                _iFirst = _times.FindIndex(t => t >= tStart);

                //decremento di _iFirst fino a all'indice corrispondente alla minima altezza del pistone
                while (_iFirst > 0 && _heights[_iFirst] > _heights[_iFirst - 1])
                {
                    _iFirst--;
                }
                //tempo di inizio del ciclo considerando anche la posizione del maschio
                tStart = _times[_iFirst];
                //tempo di conclusione del ciclo
                tEnd = tStart + CyclePressureProfile.ProfileTotalDuration;
                //SM - Tutto talmente intricato che non si capisce mai niente!!
                //     Qui viene riscritto iLast! Ma in quel punto l'altezza cambia da un elemento all'altro tantissimo, NON CAPISCO
                //_iLast = _times.FindIndex(t => t >= tEnd);
               
                //offset in base all'angolo della fase iniziale
                double phaseOffset = _timePhaseConverter.ConvertToPhase(_times[_iFirst] - _times.First());
                _profileStartPhase = AngleMath.Modulo(AngleMath.Modulo(CyclePressureProfile.StartPhase - phaseOffset) + AngleMath.RoundAngle);
                
                
               //ritardo tra il riferimeto di pressione e l'inizio effettivo del movimento del maschio
                profileStartTime = _times.First() + (GetPressureAbsoluteStartTime() - _times[_iFirst]);
                SetProfileStartTime(profileStartTime);
            }
            else
            {
                _profileStartPhase = profileStartPhase;
                //tempo di inizio della pressata
                double pressureStartTime = GetPressureAbsoluteStartTime();
                //tmepo di fine della pressata
                double pressureEndTime = pressureStartTime + CyclePressureProfile.ProfileTotalDuration;
                //tempo di inizio del profilo di interesse, convertendo in tempo la fase del profilo prima espressa in gradi
                profileStartTime = _timePhaseConverter.ConvertToTime(profileStartPhase);
                SetProfileStartTime(profileStartTime);

                //indici limite della zona di interesse
                _iFirst = _times.FindIndex(t => t >= pressureStartTime);
                _iLast = _times.FindIndex(t => t >= pressureEndTime);
            }
        }

        /// <summary>
        /// Setting on measure profile of start time of region of interest
        /// </summary>
        /// <param name="profileStartTime">Time of region of interest beginning</param>
        private void SetProfileStartTime(double profileStartTime)
        {
            double tOffset = profileStartTime - _times.First();
            _times = _times.Select(t => t + tOffset).ToList();
        }

        /// <summary>
        /// Time value for previous dwell phase beginning
        /// </summary>
        private double tDWellStartPrev = 0.0;

        /// <summary>
        /// Time value for previous dwell phase end
        /// </summary>
        private double tDWellEndPrev = 0.0;


        /// <summary>
        /// Calculus of dwell time
        /// </summary>
        /// <returns>Calculated dwell time</returns>
        private double CalculateDwellTime()
        {
            //tempo di conclusione del ciclo in base ai valori di pressione
            double tDwellEnd = CyclePressureProfile.ProfileTotalDuration;
            //minima altezza della fase di pressata in base alla tolleranza (99% altezza maschio)
            double hDwellMin = (FinalHeight - InitialHeight) * (1 - _hConstRelativeTolerance) + InitialHeight;
            //valori della misurazione da hTable
            var tList = _hTable.XSamples;
            var hList = _hTable.YSamples;
            //ultimo indice riguardante la pressata
            int _iDwellTimeEnd = hList.FindLastIndex(h => h >= hDwellMin);
            //primo indice riguardante la pressata
            int iDwellStart = hList.FindIndex(h => h >= hDwellMin);
            //tempo di inizio della pressata
            double tDwellStart_ = tList[iDwellStart];
            //tempo di conclusione della pressata
            tDwellEnd = tList[_iDwellTimeEnd];
            //calcolo del dwell time per differenza
            double dwellTime = tDwellEnd - tDwellStart_;
            //tDwellStart = _times[iDwellStart];
            //aggiornamento valori del ciclo storico con i dati dell'attuale
            tDWellStartPrev = tDwellStart_;
            tDWellEndPrev = tDwellEnd;
            return dwellTime;
        }

        /// <summary>
        /// Calculus of dwell time
        /// </summary>
        /// <param name="X">Data list on X axis (time values)</param>
        /// <param name="Y">Data list on Y axis (height values)</param>
        /// <returns>Calculated dwell time</returns>
        private double CalculateDwellTime(List<double> X, List<double> Y)
        {
            double hMax = _heights.Max();
            //double tDwellEnd = CyclePressureProfile.ProfileTotalDuration;
            //SM Ho riscontrato che FinalHeight NON è stabile -> Sostituisco con il max
            //double hDwellMin = (FinalHeight - InitialHeight) * (1 - _hConstRelativeTolerance) + InitialHeight;

            //minima altezza del pistone durante la pressata
            double hDwellMin = (hMax - InitialHeight) * (1 - _hConstRelativeTolerance) + InitialHeight;
            var tList = X;
            var hList = Y;
            //indice ultimo dato della pressata in base all'altezza del maschio
            int iDwellTimeEnd = hList.FindLastIndex(h => h >= hDwellMin);
            //indice primo dato della pressata in base all'altezza del maschio
            int iDwellStart = hList.FindIndex(h => h >= hDwellMin);
            //SM Logica per rendere più stabile il fdbk di pressata, se il precedente valore è già in una tolleranza ragionevole prendo quel valore 
            //(vale quando la curva è particolarmente piatta come a Lagnieu e ho diversi punti in prossimità dell'intersezione con la linea di DWellMin)!
            if (tDWellStartPrev > 0.0 && tDWellEndPrev > 0.0)
            {
                //individuazione degli indici limite del range del ciclo
                int iTimeStart = tList.FindIndex(t => t >= tDWellStartPrev);
                int iTimeEnd = tList.FindIndex(t => t >= tDWellEndPrev);
                //SM Controllo se utilizzando lo stesso tempo precedente l'errore rispetto al DWellMin si mantiene accettabile (20% della tolleranza)
                if (hList[iTimeStart] / hDwellMin > (1 - (_hConstRelativeTolerance / 10))
                    && hList[iTimeStart] / hDwellMin < (1 + (_hConstRelativeTolerance / 10)))
                {
                    iDwellStart = iTimeStart;
                }

                if (hList[iTimeEnd] / hDwellMin > (1 - (_hConstRelativeTolerance / 10))
                        && hList[iTimeEnd] / hDwellMin < (1 + (_hConstRelativeTolerance / 10)))
                {
                    iDwellTimeEnd = iTimeEnd;
                }

            }

            //impostazione dei tempi di inizio e fine della pressata
            tDwellStart = tList[iDwellStart];
            tDwellEnd = tList[iDwellTimeEnd];
            double dwellTime = tDwellEnd - tDwellStart;
            //tDwellStart = _times[iDwellStart];
            tDWellStartPrev = tDwellStart;
            tDWellEndPrev = tDwellEnd;

            //tempo effettivo del secondo step
            SecondStepRealDuration = (tDwellStart - tStart) - CyclePressureProfile.ProfileLevelEndTime[1];

            return dwellTime;
        }



        /// <summary>
        /// Index of the measured sample in which is allocated the first datum about dwell phase, used in methods <see cref="CalculateDwellTime(IEnumerable{double}, IEnumerable{double})"/>, <see cref="FindDwellBorders(IEnumerable{double}, double, double)"/> and <see cref="CalculateDwellTimeNew(IEnumerable{double}, IEnumerable{double})"/>
        /// </summary>
        private int iDwellBegins = 0;
        /// <summary>
        /// Index of the measured sample in which is allocated the last datum about dwell phase, used in methods <see cref="CalculateDwellTime(IEnumerable{double}, IEnumerable{double})"/>, <see cref="FindDwellBorders(IEnumerable{double}, double, double)"/> and <see cref="CalculateDwellTimeNew(IEnumerable{double}, IEnumerable{double})"/>
        /// </summary>
        private int iDwellEnds = 1;

        


        /// <summary>
        /// Calculus of dwell time using mean plunger height as threshold
        /// </summary>
        /// <param name="times">Times axis</param>
        /// <param name="heights">Heights axis</param>
        /// <returns>Calculated dwell time</returns>
        private double CalculateDwellTime(IEnumerable<double> times, IEnumerable<double> heights)
        {

            //valori limite del range di pressata usando come soglia il massimo valore dell'altezza del maschio
            List<int> _iDwellBorders = FindDwellBorders(heights, heights.Max());



            //lista in cui saranno contenuti i valori di altezza del maschio relativi alla pressata
            List<double> DwellVals = new List<double>();
            //estrazione della parte del record altezze relative all'intervallo dwell appena trovato
            for(int index = _iDwellBorders[iDwellBegins]; index <= _iDwellBorders[iDwellEnds]; index++)
            {
                DwellVals.Add(heights.ElementAt(index));
            }

            //calcolo altezza media del maschio durante la pressata
            var averageHeightValue = DwellVals.Average();
            //var averageHeightValue = WeightedAverage(DwellVals, 2, 1, 0.5);

            //calcolo dei valori limite del range di pressata utilizzando l'altezza media come soglia
            _iDwellBorders = FindDwellBorders(heights, averageHeightValue);

            //calcolo del dwell time come differenza tra gli istanti corrispondenti a agli indici dei confini della zona del record altezze riguardanti la pressata
            tDwellStart = times.ElementAt(_iDwellBorders[iDwellBegins]);
            tDwellEnd = times.ElementAt(_iDwellBorders[iDwellEnds]); 
            double dwellTime = times.ElementAt(_iDwellBorders[iDwellEnds]) - times.ElementAt(_iDwellBorders[iDwellBegins]);
            tDWellStartPrev = tDwellStart;
            tDWellEndPrev = tDwellEnd;

            return dwellTime;
        }


        /// <summary>
        /// Search of dwell phase borders in the measured sample (expressed in indexes of the arrays)
        /// </summary>
        /// <param name="heights">Plunger heights record</param>
        /// <param name="hThreshold">Heights threshold value</param>
        /// <param name="tollerance">Settable tollerance for dwell time calculus</param>
        /// <returns>List containing indexes that identify the borders of the measured sample so that between them are data about dwell phase
        /// [iDwellBegins]: index of the first found value
        /// [iDwellEnds]: index of the last found value</returns>
        private List<int> FindDwellBorders(IEnumerable<double> heights, double hThreshold, double tollerance = _hConstRelativeTolerance)
        {
            //calcolo minima altezza teorica della pressata
            double hDwellMinT = (hThreshold - InitialHeight) * (1 - tollerance) + InitialHeight;
            //ricerca dell'indice in cui e' presente il primo valore riguardante la pressata (basandomi sul record di altezze)
            int _iDwellFirst = heights.ToList().FindIndex(h => h >= hDwellMinT);
            //ricerca dell'indice in cui e' presente l'ultimo valore riguardante la pressata (basandomi sul record di altezze)
            int _iDwellLast = heights.ToList().FindLastIndex(h => h >= hDwellMinT);

            //lista ritornata
            List<int> bord = new List<int>();

            //aggiunta alla lista dei valori limite calcolati
            bord.Add(_iDwellFirst);
            bord.Add(_iDwellLast);

            //update del dell'indice del vettore che sara' ritornato a cui sono allocati gli indici notevoli della pressata
            iDwellBegins = bord.IndexOf(_iDwellFirst);
            iDwellEnds = bord.IndexOf(_iDwellLast);

            return bord;
        }

        /// <summary>
        /// Calculus of weighted average setting for the first parte of the array the first weight, whereas for the second part the second weight
        /// </summary>
        /// <param name="values">Values array on which calculate the average</param>
        /// <param name="weight1">Weight for the first part of the array</param>
        /// <param name="weight2">Weight for the second part of the array</param>
        /// <param name="whereToSplit">Relative size of the first part in which the array will be divided (expressed with a number between 0 and 1)</param>
        /// <returns>Media ponderata</returns>
        private double WeightedAverage(List<double> values, double weight1, double weight2, double whereToSplit)
        {
            //calcolo dell'ultimo indice della prima parte dell'array
            int iFirstPart = (int) (values.Count * whereToSplit);
            //somma degli elementi dell'array, tenendo conto dei pesi assegnati
            double sum = 0.0;
            //denominatore della frazione per il calcolo della media
            double den = 0.0;

            //calcolo della somma della prima parte dell'array
            for(int i = 0; i < iFirstPart; i++)
            {
                sum += values[i] * weight1;
                den += weight1;
            }

            //calcolo della somma della seconda parte dell'array
            for(int i = iFirstPart; i < values.Count; i++)
            {
                sum += values[i] * weight2;
                den += weight2;
            }

            return sum / den;
        }


        /// <summary>
        /// Tests alternately the two methods to calculate dwell time
        /// Cycles identified by even numbers will be parse with the "old" algorithm
        /// Cycles identified by odd numbers will be parse with the "new" algorithm
        /// 
        /// </summary>
        /// <param name="cycleNumber">Number of current cycle</param>
        /// <param name="heights"></param>
        /// <param name="times"></param>
        /// <param name="X"></param>
        /// <param name="Y"></param>
        /// <returns>Dwell time calculated with the chosen algorithm switching on the cycle number</returns>
        public double TestDwellTimeAlgorithms(int cycleNumber, List<double> X, List<double> Y, IEnumerable<double> times, IEnumerable<double> heights)
        {
            double dwellTime = 0.0;
            if(cycleNumber % 2 == 0)
            {
                dwellTime = CalculateDwellTime(X, Y);
            }
            else
            {
                dwellTime = CalculateDwellTime(times, heights);
            }
            Console.WriteLine(CalculateDwellTime(X, Y) + "\t" + CalculateDwellTime(times, heights) + "\t Diff: " + (CalculateDwellTime(times, heights) - CalculateDwellTime(X, Y)));
            return dwellTime;
        }


        #endregion CutProfileAndDwellTime

















        #region NewDwellTimeCalculus

        /// <summary>
        /// Threshold on plunger height
        /// </summary>
        private const double _hRelativeThreshold = 0.005;
        
        /// <summary>
        /// Resolution of the height sensor of the plunger
        /// </summary>
        private const double HeightSensorResolutoinMM = 0.01;

        /// <summary>
        /// Calculates the mean value of a set of data in a specifiend interval
        /// </summary>
        /// <param name="values">Set of data</param>
        /// <param name="iBegin">Index of the region of interest beginning</param>
        /// <param name="iEnd">Index of the region of interest end</param>
        /// <returns>Requested average value</returns>
        private double averageInInterval(IEnumerable<double> values, int iBegin, int iEnd)
        {
            double sum = 0.0;
            for(int i = iBegin; i <= iEnd; i++)
            {
                sum += values.ElementAt(i);
            }
            return sum / ((iEnd - iBegin) + 1);
        }

        /// <summary>
        /// Altervative calculus of dwell time
        /// the dwell time is the period of time that elapses between the instant in which the trend line exceeds the threshold of 99%
        /// on the height of the plunger in the hypothetical pressed phase obtained and the instant in which the difference in 
        /// values ​​between the line and the curve of the male exceeds 1% of the total height of the plunger
        /// </summary>
        /// <param name="times">Plunger times record</param>
        /// <param name="heights">Plunger heitghts record</param>
        /// <returns>Dwell time calculated with the new strategy</returns>
        public double CalculateDwellTimeNew(IEnumerable<double> times, IEnumerable<double> heights)
        {
            //conversione record int list
            List<double> lTimes = times.ToList();
            List<double> lHeights = heights.ToList();
            //calcolo temporaneo del dwell time per ottenere gli estremi della zona in cui ci sono dati dela pressata usando come soglia il valore medio
            CalculateDwellTime(times, heights);
            //indici limite fase pressata
            int iBegin = lTimes.IndexOf(tDwellStart);
            int iEnd = lTimes.IndexOf(tDwellEnd);
            //calcolo altezza media nell'intervallo trovato
            double avH = averageInInterval(heights, lTimes.IndexOf(tDwellStart), lTimes.IndexOf(tDwellEnd));

            /*
             * il valore medio dell'altezza nel periodo di dwell time è meno affetto dai valori di altezza errati dovuti a rumori e disturbi, se i valori "esatti" sono in maggioranza
             * adesso si può procedere con la valutazione del dwell time (andando a considerare validi i valori superiore a tale valore medio e)
             * trovando una retta di tendenza dai punti di dwell time calcolati con l'algoritmo dello step 4 e valutando come dwell time
             * i tempi in cui la retta è o al di sopra di un valore misurato dalla macchina o sotto di esso non più dell'1% sull'intervallo tra il valore medio e il valore iniziale
             */

            //calcolo linea di interpolazioni dati dwell phase
            LinearEquation dwellPhaseLine = LineInterpolator.getInterpolation(lTimes, lHeights, iBegin, iEnd);

            //soglia finale sull'altezza per determinare la fase di pressata
            double finalHThreshold = avH - (avH - InitialHeight) * _hRelativeThreshold;
            //nuovo tempo di inizio del dwell time
            //double _tDwellStart = dwellPhaseLine.getInverse(finalHThreshold);
            int _iBegin;
            for(_iBegin = iBegin; (_iBegin < lTimes.Count() - 1) && (dwellPhaseLine.calcFX(lTimes.ElementAt(_iBegin) - lHeights.ElementAt(_iBegin)) > finalHThreshold); _iBegin++)
            {
                //raggiungimento dell'indice cercato
            }
            double _tDwellStart = lTimes.ElementAt(_iBegin);
            /*
             * tempo di fine del dwell time:
             * quando la differenza tral'altezza della retta interpolata e i dati rilevati dalla macchina sull'altezza del maschio
             * differiscono >= 1% sull'altezza totale del maschio, il dwell time è finito
             */
            double absoluteDifference = (lHeights.Max() - InitialHeight) * _hRelativeThreshold;
            /*
             * Calcolo dell'indice a cui è allocato il tempo che ha una differenza dalla lina di tendenza >= alla differenza assoluta sopra calcolata
             */
            int _iEnd;

            for(_iEnd = iEnd; (_iEnd < lTimes.Count() - 1) && ((dwellPhaseLine.calcFX(lTimes.ElementAt(_iEnd)) - lHeights.ElementAt(_iEnd)) < absoluteDifference); _iEnd++)
            {
                //raggiunta dell'indice di fine 
            }

            double _tDwellEnd = times.ElementAt(_iEnd);

            //aggiornamento delle variabili membro
            tDwellStart = _tDwellStart;
            tDwellEnd = _tDwellEnd;

            double DwellTime = tDwellEnd - tDwellStart;

            tDWellStartPrev = tDwellStart;
            tDWellEndPrev = tDwellEnd;

            return DwellTime; 
        }

        #endregion NewDwellTimeCalculus
    }
}