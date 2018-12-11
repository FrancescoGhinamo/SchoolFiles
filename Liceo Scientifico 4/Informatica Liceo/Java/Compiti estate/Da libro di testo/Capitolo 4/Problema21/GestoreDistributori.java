package capitolo4.Problema21;

public class GestoreDistributori {
	
	public Distributore[] distributori;
	
	public GestoreDistributori() {
		Tastiera t = new Tastiera();
		distributori = new Distributore[5];
		System.out.println(" Inizializzare i distributori: ");
		for(int c = 0; c < distributori.length; c++) {
			System.out.print(" Inserire il prezzo del distributore "+(c+1)+": ");
			distributori[c] = new Distributore(t.leggiFloat());
		}
	}
	
	public float prezzoMax() {
		float max = 0;
		for(int c = 0; c < distributori.length; c++) {
			if(max < distributori[c].getPrezzoL()) {
				max = distributori[c].getPrezzoL();
			}
		}
		return max;
	}
	
	public float prezzoMin() {
		float min = Float.MAX_VALUE;
		for(int c = 0; c < distributori.length; c++) {
			if(min > distributori[c].getPrezzoL()) {
				min = distributori[c].getPrezzoL();
			}
		}
		return min;
	}
	
	public float prezzoMedio() {
		float somma = 0;
		for(int c = 0; c < distributori.length; c++) {
			somma += distributori[c].getPrezzoL();
		}
		return somma / distributori.length;
	}

	public static void main(String[] args) {
		GestoreDistributori gd = new GestoreDistributori();
		System.out.println(" Prezzo massimo: "+gd.prezzoMax());
		System.out.println(" Prezzo medio: "+gd.prezzoMedio());
		System.out.println(" Prezzo minimo: "+gd.prezzoMin());
	}

}
