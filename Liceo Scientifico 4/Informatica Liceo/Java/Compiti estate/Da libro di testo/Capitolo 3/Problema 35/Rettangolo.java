package capitolo3.Problema35;

public class Rettangolo {

	private double altezza;
	private double base;
	
	
	
	public Rettangolo(double altezza, double base) {
		super();
		this.altezza = altezza;
		this.base = base;
	}

	public double calcArea() {
		return base * altezza;
	}
	
	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire l'altezza del rettangolo: ");
		double altezza = t.leggiDouble();
		System.out.print(" Inserire la base del rettangolo: ");
		double base = t.leggiDouble();
		Rettangolo r = new Rettangolo(altezza, base);
		System.out.println(" Area del rettangolo: "+r.calcArea());

	}

}
