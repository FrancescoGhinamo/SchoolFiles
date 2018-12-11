package gestioneMagazzino.dati;

public class Articolo {
	
	private String codice;
	private String descrizione;
	private float prezzo;
	
	public Articolo(String codice, String descrizione, float prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public float getPrezzo() {
		return prezzo;
	}
	
	public String caratteristicheProdotto() {
		String ris = "";
		ris += "\n\tPRODOTTO";
		ris += "\n Codice: "+codice;
		ris += "\n Descrizione: "+descrizione;
		ris += "\n Prezzo: "+prezzo;
		return ris;
	}
	
	public String toString() {
		return descrizione;
	}
	
	

}
