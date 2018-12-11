package capitolo4.Problema23;

public class CD {

	
	private Canzone[] canzoni;
	
	public CD() {
		canzoni = new Canzone[10];
		Tastiera t = new Tastiera();
		System.out.println(" Inizializzare con 10 canzoni:");
		for(int c = 0; c < canzoni.length; c++) {
			System.out.print(" Inserire il titolo della canzone "+(c + 1)+": ");
			String titolo = t.leggiString();
			System.out.print(" Inserire la durata della canzone "+(c + 1)+"[s]: ");
			canzoni[c] = new Canzone(titolo, t.leggiInt());
		}
	}
	
	public void modificaTitoloCanzone(int numero) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il nuovo titolo: ");
		canzoni[numero - 1].setNome(t.leggiString());
	}
	
	public void modificaDurataCanzone(int numero) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la nuova durata: ");
		canzoni[numero - 1].setDurataS(t.leggiInt());
	}
	
	public int trovaDurata(String nome) {
		int _c = 0;
		for(int c = 0; c < canzoni.length; c++) {
			if(canzoni[c].getNome() == nome) {
				_c = c;
			}
		}
		
		return canzoni[_c].getDurataS();
	}
	
	public static void main(String[] args) {
		CD cd = new CD();
		Tastiera t = new Tastiera();
		int scelta = 0;
		do {
			System.out.println(" Sceglire un'opzione:");
			System.out.println(" 1 - modificare il titolo di una canzone");
			System.out.println(" 2 - modificare la durata di una canzone");
			System.out.println(" 3 - trovare la durata di una canzone");
			System.out.print(" Inserire la scelta: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				System.out.print(" Inserire il numero della canzone: ");
				cd.modificaTitoloCanzone(t.leggiInt());
				break;
				
			case 2:
				System.out.print(" Inserire il numero della canzone: ");
				cd.modificaDurataCanzone(t.leggiInt());
				break;
				
			case 3:
				System.out.print(" Inserire il titolo della canzone: ");
				System.out.println(" Durata della canzone: "+cd.trovaDurata(t.leggiString()));
				break;
				
			case 0:
				System.out.println(" Uscita dal programma");
				break;
				
			default:
				System.out.println(" Modalita' non riconosciuta");
			}
			
			
		}
		while(scelta != 0);

	}

}
