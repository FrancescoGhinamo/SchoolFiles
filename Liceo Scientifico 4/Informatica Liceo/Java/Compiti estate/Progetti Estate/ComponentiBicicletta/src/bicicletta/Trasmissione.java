package bicicletta;

public class Trasmissione extends Componente {

	private Pedali pedali;
	private Cambio cambio;
	public Trasmissione(String marca, float prezzo, Pedali pedali, Cambio cambio) {
		super(marca, prezzo);
		this.pedali = pedali;
		this.cambio = cambio;
	}
	
	public void avanza() {
		pedali.ruota();
	}
	public Pedali getPedali() {
		return pedali;
	}
	public Cambio getCambio() {
		return cambio;
	}
	
	
	
}
