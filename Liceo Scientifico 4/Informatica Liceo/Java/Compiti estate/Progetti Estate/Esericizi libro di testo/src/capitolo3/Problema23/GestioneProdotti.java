package capitolo3.Problema23;

public class GestioneProdotti {
	
	private Prodotto[] prodotti;
	
	public GestioneProdotti() {
		prodotti = new Prodotto[10];		
	}

	public static void main(String[] args) {
		GestioneProdotti gp = new GestioneProdotti();
		for(int c = 0; c < gp.getProdotti().length; c++) {
			gp.getProdotti()[c] = new Prodotto("Esempio desccrizione", Math.random() * 100);
		}
		
		System.out.println("Prezzo massimo: "+gp.prezzoMax());
		
		

	}
	
	public double prezzoMax() {
		double max = 0.0;
		for(int c = 0; c < prodotti.length; c++) {
			if(prodotti[c].getPrezzo() > max)  {
				max = prodotti[c].getPrezzo();
			}
		}
		return max;
	}

	public Prodotto[] getProdotti() {
		return prodotti;
	}

	public void setProdotti(Prodotto[] prodotti) {
		this.prodotti = prodotti;
	}
	
	

}
