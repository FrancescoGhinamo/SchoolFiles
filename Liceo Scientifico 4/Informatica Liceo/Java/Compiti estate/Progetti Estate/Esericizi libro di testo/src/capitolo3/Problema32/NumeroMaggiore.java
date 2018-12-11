package capitolo3.Problema32;

public class NumeroMaggiore {

	
	public static void main(String[] args) {

		int num1 = (int) ((Math.random() * 1000) % 50);
		int num2 = (int) ((Math.random() * 1000) % 50);
		System.out.print(" Numero maggiore: ");
		if(num1 > num2) {
			System.out.println(num1);
			System.out.print(" Numero minore: "+num2);
		}
		else {
			System.out.println(num2);
			System.out.print(" Numero minore: "+num1);
		}

	}

}
