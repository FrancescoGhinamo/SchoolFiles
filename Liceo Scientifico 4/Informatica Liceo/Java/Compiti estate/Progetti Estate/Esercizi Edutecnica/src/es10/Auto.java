package es10;

public class Auto extends Veicolo {

	private int porte;
	private Alimentazione alimentazione;
	public Auto(String marca, int anno, int cilindrata, int porte, Alimentazione alimentazione) {
		super(marca, anno, cilindrata);
		this.porte = porte;
		this.alimentazione = alimentazione;
	}
	public int getPorte() {
		return porte;
	}
	public Alimentazione getAlimentazione() {
		return alimentazione;
	}
	
	public String toString() {
		String ris = "\n\t Auto";
		ris += super.toString();
		ris += "\n Porte: "+porte;
		ris += "\n Alimentazione: "+alimentazione.toString();
		return ris;
	}
}
