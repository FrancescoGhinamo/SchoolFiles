package libreria.libro;

import java.util.Vector;

public class Libro {

	private String codiceISBN;
	private String titolo;
	private String genere;
	private float prezzo;
	private Vector<Autore> autori;
	public Libro(String codiceISBN, String titolo, String genere, float prezzo, Vector<Autore> autori) {
		super();
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
	public String getGenere() {
		return genere;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public Vector<Autore> getAutori() {
		return autori;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n\tINFORMAZIONI LIBRO";
		ris += "\n Codice ISBN: "+codiceISBN;
		ris += "\n Titolo: "+titolo;
		ris += "\n Genere: "+genere;
		ris += "\n Prezzo: "+prezzo;
		ris += "\n Autori:";
		for(int i = 0; i < autori.size(); i++) {
			ris += autori.elementAt(i).toString();
			ris += "\n";
		}
		return ris;
	}
	
	public boolean equals(Object arg0) {
		Libro _l = (Libro) arg0;
		boolean eq = false;
		if(codiceISBN == _l.getCodiceISBN() && titolo == _l.getTitolo() && genere == _l.getGenere() && prezzo == _l.getPrezzo() && autori == _l.getAutori()) {
			eq = true;
		}
		return eq;
	}
	
}
