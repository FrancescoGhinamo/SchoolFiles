package es12;

public class Motozappa extends MacchinaAgricola {
	
	private int numeroRuote;

	public Motozappa(int numeroOrdine, String marca, float costoRiparazione, int numeroRuote) {
		super(numeroOrdine, marca, costoRiparazione);
		this.numeroRuote = numeroRuote;
	}

	public int getNumeroRuote() {
		return numeroRuote;
	}
	
	public String toString() {
		String info = "";
		info += "\n\tMOTOZZAPPA";
		info += "\n Numero ruote: "+numeroRuote;
		info += super.toString();
		return info;
	}
	

}
