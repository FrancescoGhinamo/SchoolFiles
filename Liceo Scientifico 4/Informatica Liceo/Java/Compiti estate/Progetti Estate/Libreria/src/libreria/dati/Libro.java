package libreria.dati;

public class Libro {
	
	public static final int MAX_AUTORI = 5;
	
	private String codiceISBN;
	private String titolo;
	private Genere genere;
	private float prezzo;
	private Autore[] autori;
	
		
	
	public Libro(String codiceISBN, String titolo, Genere genere, float prezzo, Autore[] autori) {
		this.codiceISBN = codiceISBN;
		this.titolo = titolo;
		this.genere = genere;
		this.prezzo = prezzo;
		this.autori = autori;
	}
	
	
	public String getCodiceISBN() {
		return codiceISBN;
	}
	public String getTitolo() {
		return titolo;
	}
	public Genere getGenere() {
		return genere;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public Autore[] getAutori() {
		return autori;
	}
	
	
	

}
