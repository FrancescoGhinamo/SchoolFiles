package capitolo4.Problema32;

public class Calcolatrice {
	
	private double num1;
	private double num2;
	
	public Calcolatrice(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	public double somma() {
		return num1 + num2;
	}
	
	public double sottrai() {
		return num1 - num2;
	}
	
	public double moltiplica() {
		return num1 * num2;
	}
	
	public double dividi() {
		return num1 / num2;
	}

	
	public double getNum1() {
		return num1;
	}

	public double getNum2() {
		return num2;
	}

	public static void main(String[] args) {
		Calcolatrice calc = new Calcolatrice(4.5, 7.9);
		System.out.println(" Somma: "+calc.somma());
		System.out.println(" Differenza: "+calc.sottrai());
		System.out.println(" Prodotto: "+calc.moltiplica());
		System.out.println(" Quoziente: "+calc.dividi());

	}

}
