package capitolo3.Problema13;

public class Sconti {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il prezzo di un prodotto: ");
		double prezzo = t.leggiDouble();
		System.out.print(" Inserire la percentuale di sconto: ");
		double sconto = t.leggiDouble();
		prezzo -= prezzo * sconto / 100;
		System.out.println("Prezzo finale: "+prezzo);

	}

}
