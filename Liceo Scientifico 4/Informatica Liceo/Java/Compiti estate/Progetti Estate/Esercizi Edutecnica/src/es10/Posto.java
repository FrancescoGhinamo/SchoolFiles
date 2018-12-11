package es10;

public class Posto {

	private Veicolo veicolo;
	private int numero;
	
	
	public Posto(Veicolo veicolo, int numero) {
		super();
		this.veicolo = veicolo;
		this.numero = numero;
	}
	public Veicolo getVeicolo() {
		return veicolo;
	}
	public int getNumero() {
		return numero;
	}
	
	public String toString() {
		String ris = "\n  Posto "+numero+"\n Veicolo:\n";
		ris += veicolo.toString();
		return ris;
	}
	
}
