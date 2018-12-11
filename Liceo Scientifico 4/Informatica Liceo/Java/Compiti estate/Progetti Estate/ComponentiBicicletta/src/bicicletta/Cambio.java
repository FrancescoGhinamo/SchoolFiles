package bicicletta;

public class Cambio extends Componente {

	private Catena catena;
	private Corona[] corone;
	private int nrRapporti;
	
	
	
	public Cambio(String marca, float prezzo, Catena catena, Corona[] corone, int nrRapporti) {
		super(marca, prezzo);
		this.catena = catena;
		this.corone = corone;
		this.nrRapporti = nrRapporti;
	}

	public void aumenta() {
		
	}
	
	public void diminuisci() {
		
	}

	public Corona[] getCorone() {
		return corone;
	}

	public int getNrRapporti() {
		return nrRapporti;
	}

	public Catena getCatena() {
		return catena;
	}
	
	

}
