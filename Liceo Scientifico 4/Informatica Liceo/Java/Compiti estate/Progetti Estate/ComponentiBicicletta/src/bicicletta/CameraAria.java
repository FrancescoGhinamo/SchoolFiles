package bicicletta;

public class CameraAria extends Componente {
	
	private float diametroIn;
	private TipoValvola valvola;
	public CameraAria(String marca, float prezzo, float diametroIn, TipoValvola valvola) {
		super(marca, prezzo);
		this.diametroIn = diametroIn;
		this.valvola = valvola;
	}
	public float getDiametroIn() {
		return diametroIn;
	}
	public TipoValvola getValvola() {
		return valvola;
	}
	
	

}
