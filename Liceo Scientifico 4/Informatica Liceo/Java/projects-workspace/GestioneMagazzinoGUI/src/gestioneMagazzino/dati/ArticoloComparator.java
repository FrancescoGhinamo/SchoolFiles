package gestioneMagazzino.dati;

import java.util.Comparator;

import config.Comandi;

public class ArticoloComparator implements Comparator<Articolo>, Comandi {

	private String criterio;
	
	
	
	public ArticoloComparator(String criterio) {
		super();
		this.criterio = criterio;
	}


	public int compareCodice(Articolo a0, Articolo a1) {
		return a0.getCodice().compareTo(a1.getCodice());
	}
	
	public int compareDescrizione(Articolo a0, Articolo a1) {
		return a0.getDescrizione().compareTo(a1.getDescrizione());
	}

	public int comparePrezzo(Articolo a0, Articolo a1) {
		if(a0.getPrezzo() > a1.getPrezzo()) {
			return 1;
		}
		else if(a0.getPrezzo() < a1.getPrezzo()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	@Override
	public int compare(Articolo a0, Articolo a1) {
		int ris = 0;
		switch(criterio) {
		case ORDINA_CODICE:
			ris = compareCodice(a0, a1);
			break;
			
		case ORDINA_DESCRIZIONE:
			ris = compareDescrizione(a0, a1);
			break;
			
		case ORDINA_PREZZO:
			ris = comparePrezzo(a0, a1);
			break;			
		}
		return ris;
	}

}
