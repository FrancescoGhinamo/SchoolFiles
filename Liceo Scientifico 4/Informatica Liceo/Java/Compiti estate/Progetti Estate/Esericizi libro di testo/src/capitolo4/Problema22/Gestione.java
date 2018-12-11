package capitolo4.Problema22;

public class Gestione {
	
	private SupportoMemorizzazione[] elenco;
	
	public Gestione() {
		this.elenco = new SupportoMemorizzazione[3];
		System.out.println(" Inizilizzare il record di memorie:");
		Tastiera t = new Tastiera();
		for(int c = 0; c < elenco.length; c++) {
			System.out.print(" Inserire la capacita' del disco "+(c + 1)+": ");
			float cap = t.leggiFloat();
			System.out.print(" Inserire il prezzo del disco "+(c + 1)+": ");
			elenco[c] = new SupportoMemorizzazione(cap, t.leggiFloat());
		}
	}
	
	public SupportoMemorizzazione calcolaPiuConveniente() {
		SupportoMemorizzazione supp = null;
		float min = Float.MAX_VALUE;
		for(int c = 0; c < elenco.length; c++) {
			if(min > elenco[c].calcPrezzoAlMB()) {
				min = elenco[c].calcPrezzoAlMB();
				supp = elenco[c];
			}
		}
		return supp;
	}

	public static void main(String[] args) {
		Gestione g = new Gestione();
		System.out.println(" Prodotto piu' conveniente:\n"+g.calcolaPiuConveniente());

	}

}
