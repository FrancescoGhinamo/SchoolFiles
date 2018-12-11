package capitolo4.Problema15;

public class Triangolo {
	
	private double cateto1;
	private double cateto2;
	
	public Triangolo(double cat1, double cat2) {
		this.cateto1 = cat1;
		this.cateto2 = cat2;
	}
	
	public double calcIpotenusa() {
		return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
	}

	public static void main(String[] args) {
		Triangolo t = new Triangolo(3, 4);
		System.out.println(" Ipotenusa del triangolo: "+t.calcIpotenusa());

	}

}
