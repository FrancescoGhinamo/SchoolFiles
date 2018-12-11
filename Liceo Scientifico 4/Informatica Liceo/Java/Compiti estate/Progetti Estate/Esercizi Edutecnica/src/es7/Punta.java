package es7;

import common.Tastiera;

public class Punta extends Motore {
	
	private int x_corrente;
	private int y_corrente;

	public Punta() {
		super();
		x_corrente = 0;
		y_corrente = 0;
	}
	
	public void raggiungiCoordinate(int x, int y) {
		if(isAcceso()) {
			muoviLungoX(x - x_corrente);
			muoviLungoY(y - y_corrente);
		}
		else {
			System.out.println(" E' necessario accendere il motore");
		}
		x_corrente = x;
		y_corrente = y;
	}
	
	
	public void muoviLungoX(int lunghezza) {
		System.out.println(" Muovimento lungo x di "+lunghezza);
	}
	
	public void muoviLungoY(int lunghezza) {
		System.out.println(" Muovimento lungo y di "+lunghezza);
	}
	
	public void trapana() {
		if(isAcceso())
			System.out.println(" Trapanamento in posizione "+x_corrente+" "+y_corrente);
		else
			System.out.println(" E' necessario accendere il motore");
	}
	
	public static final void main(String[] args) {
		Punta p = new Punta();
		Tastiera t = new Tastiera();
		int scelta = 0;
		do {
			System.out.println("\n Operazioni disponibilli:");
			System.out.println(" 1 -- Accendi motore");
			System.out.println(" 2 -- Spegni motore");
			System.out.println(" 3 -- Sposta in posizione di taglio");
			System.out.println(" 4 -- Trapana");
			System.out.println(" 0 -- uscita");
			System.out.print(" Inserire un' opzione: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				p.accendi();
				break;
				
			case 2:
				p.spegni();
				break;
				
			case 3:
				System.out.print(" Inserire la coordinata x: ");
				int x = t.leggiInt();
				System.out.print(" Inserire la cooridnata y: ");
				int y = t.leggiInt();
				p.raggiungiCoordinate(x, y);
				break;
			
			case 4:
				p.trapana();
				break;
				
			case 0:
				System.out.println(" Uscita dal programma");
				break;
				
			default:
				System.out.println(" Operazione non riconosciuta");
				
			}
		}
		while(scelta != 0);
	}
	
}
