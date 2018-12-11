package centralinaAuto;

import java.util.Vector;

import centralinaAuto.input.Tastiera;

public class Centralina {
	
	private Vector<Parametro> parametri;
	
	public Centralina() {
		parametri = new Vector<Parametro>();
	}
	
	public Parametro creaParametro() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tCREAZIONE DI UN PARAMETRO");
		System.out.print(" Inserire il codice numerico: ");
		int cod = t.leggiInt();
		System.out.print(" Inserire una descrizione: ");
		String desc = t.leggiString();
		System.out.print(" Inserire il valore numerico: ");
		int val = t.leggiInt();
		System.out.println(" Tipologie di parametro:");
		System.out.println(" 1 - motore");
		System.out.println(" 2 - freni");
		System.out.println(" 3 - cambio");
		System.out.println(" 4 - sistema multimadiale");
		System.out.print(" Inserire la tipologia: ");
		Categoria cat =  null;
		switch(t.leggiInt()) {
		case 1:
			cat = Categoria.MOTORE;
			break;
			
		case 2:
			cat = Categoria.FRENI;
			break;
			
		case 3:
			cat = Categoria.CAMBIO;
			break;
			
		case 4:
			cat = Categoria.SISTEMA_MULTIMEDIALE;
			break;
			
		default:
			System.out.println(" Categoria non specificata");
		}
		
		return new Parametro(cod, desc, val, cat);
		
	}
	
	public void aggiungiParametro(Parametro p) {
		parametri.add(p);
	}
	
	public void visualizzaParametri() {
		System.out.println("\n\tPARAMETRI REGISTRATI:");
		for(int i = 0; i < parametri.size(); i++) {
			System.out.println(parametri.elementAt(i).toString());
		}
	}

	
	public boolean esisteParametro(int codice) {
		boolean esiste = false;
		for(int i = 0; i < parametri.size(); i++) {
			if(parametri.elementAt(i).getCodiceNumerico() == codice) {
				esiste = true;
			}
		}
		return esiste;
	}
	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		Centralina c = new Centralina();
		int scelta = 0;
		do {
			System.out.println("\n\tCENTRALINA AUTO");
			System.out.println(" 1 - registrazione di un nuovo parametro");
			System.out.println(" 2 - visualizza i parametri registrati");
			System.out.println(" 3 - verifica l'esistenza di un parametro");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire l'opzione desiderata: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				c.aggiungiParametro(c.creaParametro());
				break;
				
			case 2:
				c.visualizzaParametri();
				break;
				
			case 3:
				System.out.print(" Inserire il codice del parametro: ");
				System.out.println(" Esistenza del parametro: "+c.esisteParametro(t.leggiInt()));
				break;
				
			case 0:
				System.out.println(" Uscita");
				break;
				
			default:
				System.out.println(" Opzione non riconosciuta");
			}
			
		}
		while(scelta != 0);
	}	

}
