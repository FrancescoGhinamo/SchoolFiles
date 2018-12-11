package es8;

public class Quadrato extends Rombo {

	public Quadrato(float diagonale) {
		super(diagonale, diagonale);
	}
	
	private float calcolaLato() {
		return (float) (diagonaleMaggiore / Math.sqrt(2));
	}
	
	public float calcolaArea() {
		return (float) Math.pow(calcolaLato(), 2);
	}
	
	public float calcolaPerimetro() {
		return calcolaLato() * 4;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parallelogramma p = new Parallelogramma(10, 5, 30);
		Rombo r = new Rombo(5, 3);
		Quadrato q = new Quadrato(9);
		
		System.out.println(" Parallelogramma:");
		System.out.println(" \t- Area: "+p.calcolaArea());
		System.out.println(" \t- Perimetro: "+p.calcolaPerimetro());
		
		System.out.println(" Rombo:");
		System.out.println(" \t- Area: "+r.calcolaArea());
		System.out.println(" \t- Perimetro: "+r.calcolaPerimetro());
		
		System.out.println(" Quadrato:");
		System.out.println(" \t- Area: "+q.calcolaArea());
		System.out.println(" \t- Perimetro: "+q.calcolaPerimetro());
	}
}
