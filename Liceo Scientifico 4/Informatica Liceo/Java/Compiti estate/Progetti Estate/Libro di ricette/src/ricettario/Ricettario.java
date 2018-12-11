package ricettario;

import ricettario.input.Tastiera;

public class Ricettario {
	
	private static final int MAX_RICETTE = 100;
	
	private Ricetta[] ricette;
	
	public Ricettario() {
		ricette = new Ricetta[MAX_RICETTE];
	}
	
	private int primoIndiceLibero() {
		int i = 0;
		for(i = 0; (i < ricette.length) && (ricette[i] == null); i++) {
			
		}
		if(i >= ricette.length) {
			i = ricette.length - 1;
		}
		
		return i;
	}
	
	public Ricetta creaRicetta() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tCREAZIONE DI UNA RICETTA");
		System.out.print(" Inserire il titolo: ");
		String titolo = t.leggiString();
		System.out.print(" Inserire gli ingredienti: ");
		String ing = t.leggiString();
		System.out.print(" Inserire il procedimento: ");
		String proc = t.leggiString();
		return new Ricetta(titolo, ing, proc);
	}
	
	public void aggiungiRicetta(Ricetta r) {
		ricette[primoIndiceLibero()] = r;
	}
	
	public Ricetta cercaRicette(String nome) {
		Ricetta _r = null;
		for(int i = 0; i < primoIndiceLibero(); i++) {
			if(ricette[i].getNome() == nome) {
				_r = ricette[i];
			}
		}
		return _r;
	}
	
	
	
	public Ricetta[] getRicette() {
		return ricette;
	}

	public String toString() {
		String ris = "\n\t\tRICETTARIO";
		for(int i = 0; i < primoIndiceLibero(); i++) {
			ris += ricette[i].toString();
		}
		return ris;
	}
	
}
