package bicicletta;

public class Cavalletto extends Componente {

	
	private float lunghezza;
	
	public Cavalletto(String marca, float prezzo, float lunghezza) {
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
