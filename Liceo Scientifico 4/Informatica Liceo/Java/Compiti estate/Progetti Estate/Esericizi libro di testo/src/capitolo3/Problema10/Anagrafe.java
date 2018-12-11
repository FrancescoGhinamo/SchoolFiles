package capitolo3.Problema10;

public class Anagrafe {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print("Inserire il nome: ");
		String nome = t.leggiString();
		System.out.print("Inserisci il cognome: ");
		String cognome = t.leggiString();
		System.out.println("Nome completo: "+nome+" "+cognome);
	}

}
