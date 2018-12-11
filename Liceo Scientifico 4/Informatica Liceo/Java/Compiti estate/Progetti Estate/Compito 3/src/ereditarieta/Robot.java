package ereditarieta;

public class Robot extends Macchinario {
	
	private String nomeSoftwareControllo;

	public Robot(String marca, boolean alimentazioneElettrica, String nomeSoftwareControllo) {
		super(marca, alimentazioneElettrica);
		this.nomeSoftwareControllo = nomeSoftwareControllo;
	}

	public String getNomeSoftwareControllo() {
		return nomeSoftwareControllo;
	}

	

}
