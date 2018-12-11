package bicicletta;

public class Catena extends Componente {

	private int nrMaglie;

	public Catena(String marca, float prezzo, int nrMaglie) {
		super(marca, prezzo);
		this.nrMaglie = nrMaglie;
	}

	public int getNrMaglie() {
		return nrMaglie;
	}
	
	
}
