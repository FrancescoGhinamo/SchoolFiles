package capitolo4.Problema34;

public class TelefonoCellulare extends Telefono {
	
	private static final float CENT_MIN = 0.35f;

	public TelefonoCellulare(int durataTelefonata) {
		super(durataTelefonata);
		// TODO Auto-generated constructor stub
	}

	public float calcolaCostoTelefonata() {
		return (float) (12 + ((float) (super.getDurataSecondi() / 60)) * CENT_MIN);
	}
	
	public static void main(String[] args) {
		Telefono t = new Telefono(3);
		TelefonoCellulare t2 = new TelefonoCellulare(5);
		System.out.println(" Costo chiamata telefono fisso: "+t.calcolaCostoTelefonata());
		System.out.println(" Costo chiamata telefono cellulare: "+t2.calcolaCostoTelefonata());

	}

}
