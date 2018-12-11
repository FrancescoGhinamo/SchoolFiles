package capitolo4.Problema28;

public class ParallelepipedoQuadrato extends Quadrato {

	private double altezza;
	
	public ParallelepipedoQuadrato(double lato, double altezza) {
		super(lato);
		this.altezza = altezza;
	}

	public double calcolaVolume() {
		return calcArea() * altezza;
	}
	
	public static void main(String[] args) {
		ParallelepipedoQuadrato p = new ParallelepipedoQuadrato(5, 10);
		System.out.println("Volume del parallelepipedo: "+p.calcolaVolume());
	}
}
