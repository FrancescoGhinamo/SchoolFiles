package capitolo3.Problema9;

public class Divisione {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il primo valore: ");
		double val1 = t.leggiDouble();
		System.out.println(" Inserire il secondo valore: ");
		double val2 = t.leggiDouble();
		System.out.println(" Quoziente: "+val1 / val2);
	}

}
