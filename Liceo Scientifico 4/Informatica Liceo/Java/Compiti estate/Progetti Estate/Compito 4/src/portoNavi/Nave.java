package portoNavi;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Nave {
	
	private float lunghezza;
	private float larghezza;
	private GregorianCalendar dataArrivo;
	private GregorianCalendar dataPartenza;
	private Time oraArrivo;
	private int orePermanenza;
	private int nrAttracco;
	private String compagnia;
	
	
	
	
	public Nave(float lunghezza, float larghezza, GregorianCalendar dataArrivo, Time oraArrivo,
			int orePermanenza, int nrAttracco, String compagnia) {
		super();
		this.lunghezza = lunghezza;
		this.larghezza = larghezza;
		this.dataArrivo = dataArrivo;
		this.oraArrivo = oraArrivo;
		this.orePermanenza = orePermanenza;
		this.nrAttracco = nrAttracco;
		this.compagnia = compagnia;
		GregorianCalendar partenza = new GregorianCalendar();
		partenza.setTimeInMillis(dataArrivo.getTimeInMillis() + oraArrivo.getTime() + orePermanenza * 3600 * 1000);
		this.dataPartenza = partenza;
	}
	
	public float getLunghezza() {
		return lunghezza;
	}
	public float getLarghezza() {
		return larghezza;
	}
	public GregorianCalendar getDataArrivo() {
		return dataArrivo;
	}
	public Time getOraArrivo() {
		return oraArrivo;
	}
	public int getOrePermanenza() {
		return orePermanenza;
	}
	public int getNrAttracco() {
		return nrAttracco;
	}
	public String getCompagnia() {
		return compagnia;
	}

	public GregorianCalendar getDataPartenza() {
		return dataPartenza;
	}
	
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat();
		String ris = "";
		ris += "\n Lunghezza: "+lunghezza;
		ris += "\n Larghezza: "+larghezza;
		ris += "\n Data di arrivo: "+fmt.format(dataArrivo.getTime());
		ris += "\n Ora di arrivo: "+oraArrivo.toString();
		ris += "\n Data di partenza: "+fmt.format(dataPartenza.getTime());
		ris += "\n Ore di permanenza: "+orePermanenza;
		ris += "\n Numero attracco: "+nrAttracco;
		ris += "\n Compagnia: "+compagnia;
		
		return ris;
	}
	

}
