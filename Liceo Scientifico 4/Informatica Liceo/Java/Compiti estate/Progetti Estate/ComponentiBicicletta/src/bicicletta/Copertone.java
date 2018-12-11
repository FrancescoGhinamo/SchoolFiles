package bicicletta;

public class Copertone extends Componente {
	
	private float diametroIn;
	private float pressMax;
	public Copertone(String marca, float prezzo, float diametroIn, float pressMax) {
		super(marca, prezzo);
		this.diametroIn = diametroIn;
		this.pressMax = pressMax;
	}
	public float getDiametroIn() {
		return diametroIn;
	}
	public float getPressMax() {
		return pressMax;
	}
	
	

}
