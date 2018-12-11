package es12;

public class Tagliaerba extends MacchinaAgricola {

	private int numeroRuote;

	public Tagliaerba(int numeroOrdine, String marca, float costoRiparazione, int numeroRuote) {
		super(numeroOrdine, marca, costoRiparazione);
		this.numeroRuote = numeroRuote;
	}

	public int getNumeroRuote() {
		return numeroRuote;
	}
	
	public String toString() {
		String info = "";
		info += "\n\tTAGLIAERBA";
		info += "\n Numero ruote: "+numeroRuote;
		info += super.toString();
		return info;
	}
}
