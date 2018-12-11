package capitolo4.Problema25;

public class Libreria {
	
	private Libro[] elencoLibri;
	
	public Libreria() {
		this.elencoLibri = new Libro[5];
	}
	
	public void caricaLibri() {
		Tastiera t = new Tastiera();
		System.out.println("\n Caricare le informazioni dei libri della libreria:");
		for(int c = 0; c < elencoLibri.length; c++) {
			System.out.print(" Inserie il titolo del libro: ");
			String titolo = t.leggiString();
			System.out.print(" Inserire il numero di pagine del libro: ");
			elencoLibri[c] = new Libro(titolo, t.leggiInt());
			System.out.println("\n");			
		}
	}
	
	
	public void stampaLibriMeno100Pagine() {
		for(int c = 0; c < elencoLibri.length; c++) {
			if(elencoLibri[c].getNrPagine() <= 100) {
				System.out.println(elencoLibri[c].toString());
			}
		}
	}

	public static void main(String[] args) {
		Libreria lib = new Libreria();
		lib.caricaLibri();
		lib.stampaLibriMeno100Pagine();

	}

}
