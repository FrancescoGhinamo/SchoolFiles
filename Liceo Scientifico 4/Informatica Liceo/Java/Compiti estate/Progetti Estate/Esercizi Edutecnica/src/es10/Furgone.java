package es10;

public class Furgone extends Veicolo {

	private float capacita;

	public Furgone(String marca, int anno, int cilindrata, float capacita) {
		super(marca, anno, cilindrata);
		this.capacita = capacita;
	}

	public float getCapacita() {
		return capacita;
	}
	
	public String toString() {
		String ris = "\n\t Furgone";
		ris += super.toString();
		ris += "\n Capacita: "+capacita;
		return ris;
	}
}
