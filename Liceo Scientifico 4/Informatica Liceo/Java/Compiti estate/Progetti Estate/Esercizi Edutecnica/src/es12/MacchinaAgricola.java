package es12;

public class MacchinaAgricola {

	private int numeroOrdine;
	private String marca;
	private float costoRiparazione;
	
	
	
	public MacchinaAgricola(int numeroOrdine, String marca, float costoRiparazione) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.marca = marca;
		this.costoRiparazione = costoRiparazione;
	}
	
	public int getNumeroOrdine() {
		return numeroOrdine;
	}
	public String getMarca() {
		return marca;
	}
	public float getCostoRiparazione() {
		return costoRiparazione;
	}
	
	public String toString() {
		String info = "";
		info += "\n Numero ordine: "+numeroOrdine;
		info += "\n Marca: "+marca;
		info += "\n Costo riparazione: "+costoRiparazione;
		return info;
	}
	
}
