package gestioneMagazzino.dati;

import java.util.ArrayList;

public class ElencoArticoli extends ArrayList<Articolo> {
	
	private static final long serialVersionUID = 2206106440524437050L;

	public void aggiungiArticolo(Articolo a) {
		if(a == null) {
			throw new IllegalArgumentException("Articolo non specificato");
		}
		else {
			add(a);
		}
		
	}
	
	public String toString() {
		String ris = "";
		for(Articolo ar: this) {
			ris  += "\n" + ar.toString();
		}
		return ris;
	}
	
	public void oridina(String criterio) {
		sort(new ArticoloComparator(criterio));
	}

}
