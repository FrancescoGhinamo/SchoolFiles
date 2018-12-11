package ereditarieta;

public class Macchinario {
	
	private String marca;
	private boolean alimentazioneElettrica;
	public Macchinario(String marca, boolean alimentazioneElettrica) {
		super();
		this.marca = marca;
		this.alimentazioneElettrica = alimentazioneElettrica;
	}
	public String getMarca() {
		return marca;
	}
	public boolean isAlimentazioneElettrica() {
		return alimentazioneElettrica;
	}
	
	
	

}
