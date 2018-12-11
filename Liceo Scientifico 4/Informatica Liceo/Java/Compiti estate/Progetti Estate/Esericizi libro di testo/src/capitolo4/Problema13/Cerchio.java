package capitolo4.Problema13;

public class Cerchio {
	
	private double diametro;
	
	public Cerchio(double diametro) {
		this.diametro = diametro;
	}
	
	public double calcArea() {
		return Math.pow(diametro / 2, 2) * Math.PI;
	}
	
	public double calcCirconferenza() {
		return diametro * Math.PI;
	}

	public static void main(String[] args) {
		Cerchio c = new Cerchio(10);
		System.out.println(" Area: "+c.calcArea());
		System.out.println(" Perimetro: "+c.calcCirconferenza());
	}

}
