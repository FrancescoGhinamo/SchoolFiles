package bicicletta;

public abstract class Componente {

	private String marca;
	private float prezzo;
	
	
	
	public Componente(String marca, float prezzo) {
		super();
		this.marca = marca;
		this.prezzo = prezzo;
	}

	public String getMarca() {
		return this.marca;
	}
	
	public float getPrezzo() {
		return this.prezzo;
	}
	
}
