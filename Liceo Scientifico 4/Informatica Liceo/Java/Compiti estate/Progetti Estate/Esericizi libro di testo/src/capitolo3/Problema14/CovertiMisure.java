package capitolo3.Problema14;

public class CovertiMisure {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print("Inserire la misura di un'auto in mm: ");
		double misura = t.leggiDouble();
		System.out.print(" Misura dell'auto: "+(int)misura / 1000+"m ");
		misura -= ((int)misura / 1000) * 1000;
		System.out.println((int)misura / 10+"cm");

	}

}
