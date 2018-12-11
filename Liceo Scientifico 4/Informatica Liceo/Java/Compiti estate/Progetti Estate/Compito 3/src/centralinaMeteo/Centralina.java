package centralinaMeteo;

import java.util.Vector;

import centralinaMeteo.input.Tastiera;

public class Centralina {
	
	private int ultimoID;
	
	private Vector<EventoMeteo> eventi;
	
	public Centralina() {
		ultimoID = 0;
		eventi = new Vector<EventoMeteo>(); 
	}

	public EventoMeteo creaEvento() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tCREAZIONE DI UN EVENTO METEO");
		System.out.println(" Tipologie di evento: ");
		System.out.println(" 1 - raggi UV");
		System.out.println(" 2 - temperatura");
		System.out.println(" 3 - umidita'");
		System.out.println(" 4 - velocita del vento");
		System.out.print(" Inserire una tipoogia: ");
		int tip = t.leggiInt();
		TipoEvento tipo = null;
		switch(tip) {
		case 1:
			tipo = TipoEvento.RAGGI_UV;
			break;
			
		case 2:
			tipo = TipoEvento.TEMPERATURA;
			break;
			
		case 3:
			tipo = TipoEvento.UMIDITA;
			break;
			
		case 4:
			tipo = TipoEvento.VELOCITA_VENTO;
			break;
			
		default:
			System.out.println(" Inserimento non riconosciuto, default: raggi UV");
			tipo = TipoEvento.RAGGI_UV;
		}
		System.out.print(" Insierire il valore numerico: ");
		float val = t.leggiFloat();
		return new EventoMeteo(ultimoID++, val, tipo);
	}
	
	public void aggiungiEvento(EventoMeteo e) {
		eventi.add(e);
	}
	
	public void visualizzaEventi() {
		System.out.println("\n\tEVENTI REGISTRATI\n");
		for(int i = 0; i < eventi.size(); i++) {
			System.out.println(eventi.elementAt(i).toString());
		}
 	}
	
	public boolean esisteEvento(int numeroProg) {
		boolean esiste = false;
		for(int i = 0; i < eventi.size(); i++) {
			if(eventi.elementAt(i).getIdEvento() == numeroProg) {
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
			System.out.println("\n\tSTAZIONE METEO");
			System.out.println(" 1 - registrazione di un nuovo evento");
			System.out.println(" 2 - visualizzazione degli eventi inseriti");
			System.out.println(" 3 - ricerca di un evento");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire l'opzione desiderata: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				c.aggiungiEvento(c.creaEvento());
				break;
				
			case 2:
				c.visualizzaEventi();
				break;
				
			case 3:
				System.out.print(" Inserire l'ID di ricerca: ");
				System.out.println(" Esistenza dell'evento: "+c.esisteEvento(t.leggiInt()));
				break;
				
			case 0:
				System.out.println(" Uscita dal programma");
				break;
				
			default:
				System.out.println(" Opzione non riconosciuta");
			}
			
		}
		while(scelta != 0);

	}

}
