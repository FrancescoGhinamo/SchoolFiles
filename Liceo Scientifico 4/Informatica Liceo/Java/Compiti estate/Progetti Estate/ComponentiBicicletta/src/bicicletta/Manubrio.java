package bicicletta;

public class Manubrio extends Componente {
	
	private float lunghezza;
	private boolean perMTB;
	
	
	
	public Manubrio(String marca, float prezzo, float lunghezza, boolean perMTB) {
		super(marca, prezzo);
		this.lunghezza = lunghezza;
		this.perMTB = perMTB;
	}
	
	public void sterza() {
		
	}
	
	public float getLunghezza() {
		return lunghezza;
	}
	public boolean isPerMTB() {
		return perMTB;
	}
	
	

}
