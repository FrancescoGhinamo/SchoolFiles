package es10;

public class Moto extends Veicolo {

	private int tempi;

	public Moto(String marca, int anno, int cilindrata, int tempi) {
		super(marca, anno, cilindrata);
		this.tempi = tempi;
	}

	public int getTempi() {
		return tempi;
	}
	
	public String toString() {
		String ris = "\n\t Moto";
		ris += super.toString();
		ris += "\n Tempi: "+tempi;
		return ris;
	}
}
