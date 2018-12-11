package capitolo4.Problema32;

public class CalcolatricePro extends Calcolatrice {

	public CalcolatricePro(double num1, double num2) {
		super(num1, num2);
		// TODO Auto-generated constructor stub
	}
	
	public double sommaQuadrati() {
		return Math.pow(super.getNum1(), 2) + Math.pow(super.getNum2(), 2);
	}
	
	public double differenzaQuadrati() {
		return super.getNum1() > super.getNum2() ? Math.pow(super.getNum1(), 2) - Math.pow(super.getNum2(), 2) : Math.pow(super.getNum2(), 2) - Math.pow(super.getNum1(), 2);
	}

	public static void main(String[] args) {
		CalcolatricePro cP = new CalcolatricePro(3, 4);
		System.out.println(" Somma quadrati: "+cP.sommaQuadrati());
		System.out.println(" Differenza quadrati: "+cP.differenzaQuadrati());

	}

}
