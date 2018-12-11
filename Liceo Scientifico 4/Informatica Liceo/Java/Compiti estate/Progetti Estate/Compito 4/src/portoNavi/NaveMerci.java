package portoNavi;

import java.sql.Time;
import java.util.GregorianCalendar;

public class NaveMerci extends Nave {

	public NaveMerci(float lunghezza, float larghezza, GregorianCalendar dataArrivo, Time oraArrivo, int orePermanenza,
			int nrAttracco, String compagnia) {
		super(lunghezza, larghezza, dataArrivo, oraArrivo, orePermanenza, nrAttracco, compagnia);
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		String ris = "\n\tNAVE MERCI";
		ris += super.toString();
		return ris;
	}

}
