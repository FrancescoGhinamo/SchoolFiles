package capitolo4.Problema25;

public class Libro {
	
	private String titolo;
	private int nrPagine;
	
	public Libro(String titolo, int pagine) {
		this.titolo = titolo;
		this.nrPagine = pagine;
	}

	public int getNrPagine() {
		return nrPagine;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n\n  Libro";
		ris += "\n Titolo: "+this.titolo;
		ris += "\n Numero di pagine: "+this.nrPagine;
		return ris;
	}

}
