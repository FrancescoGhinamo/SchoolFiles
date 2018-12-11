package portoNavi;

import java.sql.Time;
import java.util.GregorianCalendar;

import portoNavi.input.Tastiera;

public class Porto {
	
	private static final int MAX_NAVI = 50;

	private Nave[] navi;
	
	public Porto() {
		this.navi = new Nave[MAX_NAVI];
	}
	
	public NavePasseggeri creaNavePasseggeri(Nave _n) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire il numero dei passeggeri: ");
		int pass = t.leggiInt();
		return new NavePasseggeri(_n.getLunghezza(), _n.getLarghezza(), _n.getDataArrivo(), _n.getOraArrivo(), _n.getOrePermanenza(), _n.getNrAttracco(), _n.getCompagnia(), pass);
	}
	
	public NaveMerci creaNaveMerci(Nave _n) {
		return new NaveMerci(_n.getLunghezza(), _n.getLarghezza(), _n.getDataArrivo(), _n.getOraArrivo(), _n.getOrePermanenza(), _n.getNrAttracco(), _n.getCompagnia());
	}
	
	public Nave creaNave() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tREGISTRAZIONE DATI NAVE");
		System.out.print(" Inserire la lunghezza: ");
		float lung = t.leggiFloat();
		System.out.print(" Inserire la larghezza: ");
		float larg = t.leggiFloat();
		System.out.print(" Inserire la data di arrivo: ");
		GregorianCalendar data = t.leggiCalendar();
		System.out.print(" Inserire l'ora di arrivo: ");
		Time ora = t.leggiTime();
		System.out.print(" Inserire le ore di permanenza: ");
		int perm = t.leggiInt();
		System.out.print(" Inserire la posizione di attracco: ");
		int att = t.leggiInt();
		System.out.print(" Inserire il nome della compagnia: ");
		String comp = t.leggiString();
		System.out.println(" Tipologie di navi:");
		System.out.println(" 1 - nave passeggeri");
		System.out.println(" 2 - nave merci");
		System.out.print(" Inserire la tipolgia: ");
		Nave _n = new Nave(lung, larg, data, ora, perm, att, comp);
		switch(t.leggiInt()) {
		case 1:
			_n = creaNavePasseggeri(_n);
			break;
			
		case 2:
			_n = creaNaveMerci(_n);
			break;
			
		default:
			System.out.println(" Tipologia non specificata");
		}
		return _n;
	}
	
	public int primoIndiceLibero(Object[] vect) {
		int i = 0;
		for(i = 0; i < vect.length && vect[i] != null; i++) {
			
		}
		return i;
	}
	
	
	public void aggiungiNave(Nave n) throws PortoPienoException {
		if(primoIndiceLibero(navi) < MAX_NAVI) {
			navi[primoIndiceLibero(navi)] = n;
		}
		else {
			throw new PortoPienoException();
		}
	}
	
	public void stampaNavi() {
		System.out.println("\n\t\tNAVI REIGSTRATE AL PORTO\n");
		for(int i = 0; i < primoIndiceLibero(navi); i++) {
			System.out.println(navi[i].toString());
		}
	}
	
	public Nave[] naviPartenzaData(GregorianCalendar data) {
		Nave[] _temp = new Nave[primoIndiceLibero(navi)];
		for(int i = 0; i < primoIndiceLibero(navi); i++) {
			if(navi[i].getDataArrivo().get(GregorianCalendar.DAY_OF_YEAR) == data.get(GregorianCalendar.DAY_OF_YEAR)) {
				_temp[primoIndiceLibero(_temp)] = navi[i];
			}
		}
		return _temp;
	}
	
	public void visualizzaNaviPartenza() {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la data di partenza: ");
		Nave[] part = naviPartenzaData(t.leggiCalendar());
		for(int i = 0; i < primoIndiceLibero(part); i++) {
			System.out.println(part[i].toString());
		}
	}
	
	public static void main(String[] args) {
		Porto p = new Porto();
		Tastiera t = new Tastiera();
		int scelta = 0;
		do {
			System.out.println("\n\tPORTO DI NAVI");
			System.out.println(" 1 - registrazine di una nuova nave");
			System.out.println(" 2 - visualizzazione di tutte le navi registrate");
			System.out.println(" 3 - visualizzazione della navi in partenza in una determinata data");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire la scelta: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				try {
					p.aggiungiNave(p.creaNave());
				} catch (PortoPienoException e) {
					System.out.println(e);
				}
				break;
				
			case 2:
				p.stampaNavi();
				break;
				
			case 3:
				p.visualizzaNaviPartenza();
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
