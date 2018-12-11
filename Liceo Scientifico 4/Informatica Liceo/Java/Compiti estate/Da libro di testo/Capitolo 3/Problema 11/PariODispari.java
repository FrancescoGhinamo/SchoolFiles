package capitolo3.Problema11;

public class PariODispari {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire un numero: ");
		int num = t.leggiInt();
		if(num % 2 == 0) {
			System.out.println(" Numero pari");
		}
		else {
			System.out.println(" Numero dispari");
		}

	}

}
