using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ControlPortable.PlungerCycle.LineInterpolation
{

    /// <summary>
    /// Class to do a linear interpolation of data from two data sets
    /// </summary>
    public class LineInterpolator
    {

        


        /// <summary>
        /// Interpolation of a line from a set of points, identifid fith x and y coordiates
        /// </summary>
        /// <param name="xValues">x values set</param>
        /// <param name="yValues">y values set</param>
        /// <param name="iBegin">First index of the sets to be considered</param>
        /// <param name="iEnd">Last index of the sets to be considered</param>
        /// <returns>LinearEquation containing the interpolation</returns>
        public static LinearEquation getInterpolation(List<double> xValues, List<double> yValues, int iBegin, int iEnd)
        {
            //copy of the region of interst of the sets in other arrays
            List<double> intX = getRegionOfInterest(xValues, iBegin, iEnd);
            List<double> intY = getRegionOfInterest(yValues, iBegin, iEnd);

            //gathering of required indormation
            int n = intX.Count();

            //calculus of the approximation of eqution of type y = a + bx


            //double a = (sum(intY) * sum(intX, null, 2) - sum(intX) * sum(intX, intY)) / (n * sum(intX, null, 2) - Math.Pow(sum(intX), 2));

            //double b = (n * sum(intX, intY) - sum(intX) * sum(intY)) / (n * sum(intX, null, 2) - Math.Pow(sum(intX), 2));

            //average values of the sets
            double xM = intX.Average();
            double yM = intY.Average();

            double b = sum(calculateScatters(intX), calculateScatters(intY))/ sum(calculateScatters(intX), null, 2);
            double a = intY.Average() - b * intX.Average();

            return new LinearEquation(a, b);
        }

        /// <summary>
        /// Returns the region of interest of the given set inbetween the given indexes 
        /// </summary>
        /// <param name="set">Set</param>
        /// <param name="iFirst">First index of the region of interest</param>
        /// <param name="iLast">Last index of the region of interest</param>
        /// <returns>Returns the region of interest of the given set inbetween the given indexes </returns>
        private static List<double> getRegionOfInterest(List<double> set, int iFirst, int iLast)
        {
            List<double> finalSet = new List<double>();
            for(int i = iFirst; i <= iLast; i++)
            {
                finalSet.Add(set.ElementAt(i));
            }
            return finalSet;
        }

        /// <summary>
        /// Calculates the sum of the elemnts of an array
        /// </summary>
        /// <param name="set">Set of data</param>
        /// <param name="multiplyBy">Multiply optionally each member of set by the correspondant value of this List (elevate param unused)</param>
        /// <param name="elevate">Elevate eqch member of the set for this number (multiplyBy param unused)</param>
        /// <returns>Sum of the values</returns>
        private static double sum(List<double> set, List<double> multiplyBy = null, int elevate = 1)
        {
            double sum = 0.0;
            if (multiplyBy == null)
            {

                for(int i = 0; i < set.Count(); i++)
                {
                    sum += Math.Pow(set.ElementAt(i), elevate);
                }
            }
            else
            {

                for (int i = 0; i < set.Count(); i++)
                {
                    sum += set.ElementAt(i) * multiplyBy.ElementAt(i);
                }
                
            }
            return sum;
        }

        /// <summary>
        /// Calculates scatters of an array of data
        /// </summary>
        /// <param name="set">Array of numbers</param>
        /// <returns>List containig the scatters</returns>
        private static List<double> calculateScatters(List<double> set)
        {
            double avVal = set.Average();
            List<double> s = new List<double>();
            //for(int i = 0; i < set.Count(); i++)
            //{
            //    s.Add(set.ElementAt(i) - avVal);
            //}
            foreach(double item in set)
                s.Add(item - avVal);

            return s;
        }
    }
}
