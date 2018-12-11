package scuola;

public class Pagella {
	
	private static final int MAX_MATERIE = 10;
	private Materia[] materie;
	
	public Pagella() {
		this.materie = new Materia[MAX_MATERIE];
		registraMaterie();
	}
	
	private int primoIndiceLibero() {
		int i = 0;
		for(i = 0; (i < materie.length) && (materie[i] == null); i++) {
			
		}
		if(i >= materie.length) {
			i = materie.length - 1;
		}
		
		return i;
	}
	
	
	public Materia creaMateria() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tCreazone di una nuova materia");
		System.out.print(" Inserire il nome della materia: ");
		return new Materia(t.leggiString());
	}
	
	public void aggiungiMateria(Materia m) {
		materie[primoIndiceLibero()] = m;
	}
	
	public void registraMaterie() {
		Tastiera t = new Tastiera();
		do {
			System.out.println("\n Inserire i dati di una matera");
			aggiungiMateria(creaMateria());
			System.out.print(" Continuare con l'inserimento? ");
		}
		while(t.leggiBoolean() == true);
		
		
	}
	
	public float calcolaMedia() {
		int somma = 0, num = 0;
		for(num = 0; num < primoIndiceLibero(); num++) {
			somma += materie[num].calcolaMedia();
		}
		return (float) somma / num;
	}

	public Materia[] getMaterie() {
		return materie;
	}
	
	public String toString() {
		String ris = "\n Pagella";
		ris += "\n Materie:\n";
		for(int i = 0; i < primoIndiceLibero(); i++) {
			ris += materie[i].toString();
		}
		return ris;
	}

}
