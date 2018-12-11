package capitolo4.Problema34;

public class Telefono {
	
	private static final float CENT_MIN = 15;

	private int durataSecondi;
	
	public Telefono(int durataTelefonata) {
		this.durataSecondi = durataTelefonata;
	}
	
	public float calcolaCostoTelefonata() {
		return (float) (((float) (durataSecondi / 60)) * CENT_MIN);
	}

	public int getDurataSecondi() {
		return durataSecondi;
	}
	
	
	
}
