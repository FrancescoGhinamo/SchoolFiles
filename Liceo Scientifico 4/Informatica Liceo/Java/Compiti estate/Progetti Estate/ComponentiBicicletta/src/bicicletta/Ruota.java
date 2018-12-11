package bicicletta;

public class Ruota extends Componente {
	
	private CameraAria cameraAria;
	private Copertone copertone;
	
	private boolean raggi;
	
	public Ruota(String marca, float prezzo, CameraAria cameraAria, Copertone copertone, boolean raggi) {
		super(marca, prezzo);
		this.cameraAria = cameraAria;
		this.copertone = copertone;
		this.raggi = raggi;
	}
	
	public CameraAria getCameraAria() {
		return cameraAria;
	}

	public Copertone getCopertone() {
		return copertone;
	}

	public boolean isRaggi() {
		return raggi;
	}
	
	

}
