package ereditarieta;

public final class RobotChirurgo extends Robot {

	private int nrBracci;

	public RobotChirurgo(String marca, boolean alimentazioneElettrica, String nomeSoftwareControllo, int nrBracci) {
		super(marca, alimentazioneElettrica, nomeSoftwareControllo);
		this.nrBracci = nrBracci;
	}

	public int getNrBracci() {
		return nrBracci;
	}
	
	
}
