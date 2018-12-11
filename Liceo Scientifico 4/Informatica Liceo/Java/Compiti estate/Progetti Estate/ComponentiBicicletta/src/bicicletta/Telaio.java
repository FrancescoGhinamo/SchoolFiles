package bicicletta;

public class Telaio extends Componente {
	
	private Taglia taglia;
	private boolean perUomo;
	private boolean perMTB;
	public Telaio(String marca, float prezzo, Taglia taglia, boolean perUomo, boolean perMTB) {
		super(marca, prezzo);
		this.taglia = taglia;
		this.perUomo = perUomo;
		this.perMTB = perMTB;
	}
	public Taglia getTaglia() {
		return taglia;
	}
	public boolean isPerUomo() {
		return perUomo;
	}
	public boolean isPerMTB() {
		return perMTB;
	}
	
	

}
