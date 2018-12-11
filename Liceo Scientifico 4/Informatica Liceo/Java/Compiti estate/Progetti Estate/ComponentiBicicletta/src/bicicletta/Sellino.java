package bicicletta;

public class Sellino extends Componente {
	
	private float lunghezza;

	public Sellino(String marca, float prezzo, float lunghezza) {
		super(marca, prezzo);
		this.lunghezza = lunghezza;
	}

	public void alza() {
	
	}
	
	public void abbassa() {
		
	}
	
	public float getLunghezza() {
		return lunghezza;
	}

	

}
