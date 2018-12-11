package portoNavi;

import java.sql.Time;
import java.util.GregorianCalendar;

public class NavePasseggeri extends Nave {
	
	private int nrPAsseggeri;

	public NavePasseggeri(float lunghezza, float larghezza, GregorianCalendar dataArrivo, Time oraArrivo,
			int orePermanenza, int nrAttracco, String compagnia, int nrPAsseggeri) {
		super(lunghezza, larghezza, dataArrivo, oraArrivo, orePermanenza, nrAttracco, compagnia);
		this.nrPAsseggeri = nrPAsseggeri;
	}

	public int getNrPAsseggeri() {
		return nrPAsseggeri;
	}
	
	public String toString() {
		String ris = "\n\tNAVE PASSEGGERI";
		ris += super.toString();
		ris += "\n Numero passeggeri: "+nrPAsseggeri;
		return ris;
	}

}
