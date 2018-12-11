package capitolo4.Problema14;

public class Quadrato {
	
	private double lato;
	
	public Quadrato(double lato) {
		this.lato = lato;
	}
	
	public double calcArea() {
		return lato * lato;
	}
	
	public double calcPerimetro() {
		return lato * 4;
	}

	public static void main(String[] args) {
		Quadrato q = new Quadrato(5);
		System.out.println(" Area del quadrato: "+q.calcArea());
		System.out.println(" Perimetro del quadrato: "+q.calcPerimetro());

	}

}
