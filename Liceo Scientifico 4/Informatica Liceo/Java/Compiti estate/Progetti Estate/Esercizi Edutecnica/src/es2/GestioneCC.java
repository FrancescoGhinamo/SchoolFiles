package es2;

import common.Tastiera;

public class GestioneCC {
	
	private CC conto;
	
	public GestioneCC() {
		Tastiera t = new Tastiera();
		System.out.println(" Registrazione conto corrente");
		System.out.print(" Inserire il saldo iniziale: ");
		conto = new CC(t.leggiInt());
	}
	
	public Movimento creaMovimento() {
		Tastiera t = new Tastiera();
		System.out.println("\n Registrazione nuovvo movimento");
		System.out.println(" Selezionare il tipo di movimento:");
		System.out.println(" 1 -- Versamento");
		System.out.println(" 2 -- Prelievo");
		System.out.print(" Inserire la scelta: ");
		int scelta = t.leggiInt();
		TipoMovimento tM = null;
		switch(scelta) {
		case 1:
			tM = TipoMovimento.VERSAMENTO;
			break;
			
		case 2:
			tM = TipoMovimento.PRELIEVO;
			break;
			
		default:
			tM = TipoMovimento.VERSAMENTO;
			
		}
		System.out.print(" Inserire l'importo: ");
		float i = t.leggiFloat();
		return new Movimento(tM, i);
	}
	
	public void aggiungiMovimento() {
		try {
			conto.aggiungiMovimento(creaMovimento());
		} catch (SaldoNegativoException e) {
			System.out.println(e);
		}
	}
	
	public void listaMovimenti() {
		Movimento[] movs = conto.ultimiMovimenti();
		System.out.println("\n Lista ultimi 5 movimenti:\n");
		for(int c = 0; (c < movs.length) && (movs[c] != null); c++) {
			System.out.println(movs[c].toString()+"\n");
		}
	}
	
	public void visualizzaSaldo() {
		System.out.println("\nSaldo corrente: "+conto.getSaldo());
	}

	public static void main(String[] args) {
		int scelta = 0;
		Tastiera t = new Tastiera();
		GestioneCC gest = new GestioneCC();
		do {
			System.out.println("\n\n\t Gestione Conto Corrente");
			System.out.println(" 1 -- registrazione nuovo movimento");
			System.out.println(" 2 -- visualizzazione del saldo");
			System.out.println(" 3 -- visualizzazione ultimi movimenti");
			System.out.println(" 0 -- uscita");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				gest.aggiungiMovimento();
				break;
				
			case 2:
				gest.visualizzaSaldo();
				break;
				
			case 3:
				gest.listaMovimenti();
				break;
				
			case 0:
				System.out.println(" Uscita dal programma");
				break;
				
			default:
					System.out.println("\nOpzione non riconosciuta");
			}
			
		}
		while(scelta != 0);

	}

}
