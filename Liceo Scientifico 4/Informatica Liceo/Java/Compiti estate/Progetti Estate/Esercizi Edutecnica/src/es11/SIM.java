package es11;

import java.util.Vector;

import common.Tastiera;

public class SIM {

	private String numeroTelefono;
	private float creditoDisponibileEuro;
	private Vector<Telefonata> telefonate;
	
	public SIM(String numeroTelefono, float creditoDisponibileEuro) {
		super();
		this.numeroTelefono = numeroTelefono;
		this.creditoDisponibileEuro = creditoDisponibileEuro;
		this.telefonate = new Vector<Telefonata>();
	}
	
	
	public Telefonata creaTelefonata() {
		Tastiera t = new Tastiera();
		System.out.println("\n Registrazione di una telefonata:");
		System.out.print(" Inserire il numero telefonico del destinatario: ");
		String num = t.leggiString();
		System.out.print(" Inserire la durata in minuti: ");
		return new Telefonata(num, t.leggiInt());
	}
	
	public void registraTelefonata(Telefonata t) {
		telefonate.add(t);
	}
	
	public int minutiTotConversazione() {
		int tot = 0;
		for(int c = 0; c < telefonate.size(); c++) {
			tot += telefonate.elementAt(c).getDurataMin();
		}
		return tot;
	}
	
	public int numChiamateVersoNumero(String numero) {
		int tot = 0;
		for(int i = 0; i < telefonate.size(); i++) {
			if(telefonate.elementAt(i).getDestnatario().equals(numero)) {
				tot ++;
			}
		}
		return tot;
	}
	
	public void stampaInfoSim() {
		System.out.println(this.toString());
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public float getCreditoDisponibileEuro() {
		return creditoDisponibileEuro;
	}

	public Vector<Telefonata> getTelefonate() {
		return telefonate;
	}
	
	
	
	
	
	public String toString() {
		String ris = "";
		ris += "\n\t\tINFORMAZIONI SIM";
		ris += "\n - Numero di telefono: "+numeroTelefono;
		ris += "\n - Credito disponibile in euro: "+creditoDisponibileEuro;
		ris += "\n - Registro chiamate:\n";
		for(int c = 0; c < telefonate.size(); c++) {
			ris += telefonate.elementAt(c).toString();
		}
		
		return ris;
	}
	
	
	
	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.println(" Inizializzazione scheda SIM");
		System.out.print(" Inserire il numero di telefono: ");
		String num = t.leggiString();
		System.out.print(" Inserire il credito disponibile: ");
		SIM sim = new SIM(num, t.leggiFloat());
		
		int scelta = 0;
		do {
			System.out.println("\n Gestore SIM");
			System.out.println(" 1 - registrare una nuova chiamata");
			System.out.println(" 2 - calcolare i minuti totali di conversazione");
			System.out.println(" 3 - calcolare il numero di telefonate verso un certo numero");
			System.out.println(" 4 - stampare i dati della SIM");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire un'opzione: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				sim.registraTelefonata(sim.creaTelefonata());
				break;
				
			case 2:
				System.out.println(" Minuti totali di conversazione: "+sim.minutiTotConversazione());
				break;
				 
				
			case 3:
				System.out.print(" Inserire il numero di telefono di ricerca: ");
				String numR = t.leggiString();
				System.out.println(" Chiamate effettuate verso "+numR+": "+sim.numChiamateVersoNumero(numR));
				break;
				
			case 4:
				sim.stampaInfoSim();
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
