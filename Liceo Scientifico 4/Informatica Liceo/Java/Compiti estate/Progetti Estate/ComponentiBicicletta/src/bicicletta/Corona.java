package bicicletta;

public class Corona extends Componente {
	
	private float diametroCm;

	public Corona(String marca, float prezzo, float diametroCm) {
		super(marca, prezzo);
		this.diametroCm = diametroCm;
	}

	public float getDiametroCm() {
		return diametroCm;
	}
	
	

}
