package es8;

public class Rombo extends Parallelogramma {

	public Rombo(float diagonaleMaggiore, float diagonaleMinore) {
		super(diagonaleMaggiore, diagonaleMinore, (float) (Math.acos(diagonaleMinore / diagonaleMaggiore ) * 180 / Math.PI));
	}
	
	public float calcolaArea() {
		return diagonaleMaggiore * diagonaleMinore / 2;
	}
	
	public float calcolaPerimetro() {
		return (float) (4 * (Math.sqrt(Math.pow(diagonaleMaggiore / 2, 2) + Math.pow(diagonaleMinore / 2, 2))));
	}
	

}
