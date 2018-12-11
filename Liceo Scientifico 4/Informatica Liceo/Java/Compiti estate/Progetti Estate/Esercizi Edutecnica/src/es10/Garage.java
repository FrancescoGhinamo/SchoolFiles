package es10;

import java.util.Vector;

import common.Tastiera;

public class Garage {

	private Vector<Posto> posti;
	
	public Garage() {
		posti = new Vector<Posto>();
	}
	
	public Auto creaAuto(Veicolo _v) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il numero di porte: ");
		int porte = t.leggiInt();
		Alimentazione alim = null;
		System.out.println(" Scegliere il tipo di alimentazione:");
		System.out.println(" 1 - benzina");
		System.out.println(" 2 - diesel");
		System.out.print(" Inserire la scelta: ");
		int s = t.leggiInt();
		switch(s) {
		case 1:
			alim = Alimentazione.BENZINA;
			break;
		case 2:
			alim = Alimentazione.DIESEL;
			break;
			
		default:
			alim = Alimentazione.BENZINA;
		}
		
		return new Auto(_v.getMarca(), _v.getAnno(), _v.getCilindrata(), porte, alim);
	}
	
	public Moto creaMoto(Veicolo _v) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il numero di tempi: ");
		int tempi = t.leggiInt();
		return new Moto(_v.getMarca(), _v.getAnno(), _v.getCilindrata(), tempi);
	}
	
	public Furgone creaFurgone(Veicolo _v) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la capacita': ");
		float cap = t.leggiFloat();
		return new Furgone(_v.getMarca(), _v.getAnno(), _v.getCilindrata(), cap);
	}
	
	public Veicolo creaVeicolo() {
		Veicolo v = null;
		Tastiera t = new Tastiera();
		System.out.println("\n Registrazione di un nuovo veicolo:");
		System.out.print(" Inserire la marca: ");
		String marca = t.leggiString();
		System.out.print(" Inserire l'anno di immatricolazione: ");
		int anno = t.leggiInt();
		System.out.print(" Inserire la cilindrata: ");
		int cil = t.leggiInt();
		System.out.println(" Scegliere il tipo di veicolo: ");
		System.out.println(" 1 - auto");
		System.out.println(" 2 - moto");
		System.out.println(" 3 - furgone");
		System.out.print(" Inserire la scelta: ");
		int scelta = t.leggiInt();
		Veicolo _v = new Veicolo(marca, anno, cil);
		switch(scelta) {
		case 1:
			v = creaAuto(_v);
			break;

		case 2:
			v = creaMoto(_v);
			break;
		
		case 3:
			v = creaFurgone(_v);
			break;
			
		default:
			System.out.println(" Veicolo non specificato");
		}
		
		return v;
	}
	
	public void aggiungiVeicolo(Veicolo v) throws GarageFullException {
		if(posti.size() < 15) {
			posti.add(new Posto(v, posti.size()));
		}
		else {
			throw new GarageFullException();
		}
	}
	
	public Veicolo cercaPerPosto(int posto) throws NotFoudException {
		Veicolo _v = null;
		for(int c = 0; c < posti.size(); c++) {
			if(posti.elementAt(c).getNumero() == posto) {
				_v = posti.elementAt(c).getVeicolo();
			}
		}
		if(_v == null) {
			throw new NotFoudException();
		}
		return _v;
	}
	
	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		Garage g = new Garage();
		int scelta = 0;
		do {
			System.out.println("\n\tGESTIONE DI UN GARAGE");
			System.out.println(" 1 - Aggiungere un nuovo veicolo al record");
			System.out.println(" 2 - Ricercare un veicolo per numero di parcheggio");
			System.out.println(" 3 - Stampare la situazione del garage");
			System.out.println(" 0 - Uscita dal programma");
			System.out.print(" Inserire la propria scelta: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				try {
					g.aggiungiVeicolo(g.creaVeicolo());
				} catch (GarageFullException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
				break;
				
			case 2:
				System.out.print(" Inserire il numero del parchegio: ");
				int num = t.leggiInt();
				try {
					System.out.println(g.cercaPerPosto(num).toString());
				} catch (NotFoudException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					
				}
				break;
			
			case 3:
				System.out.println(g.toString());
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

	
	public String toString() {
		String ris = "\n\t SITUAZIONE GARAGE";
		for(int c = 0; c < posti.size(); c++) {
			ris += "\n"+posti.elementAt(c).toString();
		}
		return ris;
	}
}
