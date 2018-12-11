package libreria.dati;

import java.util.GregorianCalendar;

public class Autore extends Persona {
	
	private String codice;

	public Autore(String nome, String cognome, GregorianCalendar dataNascita, String codice) {
		super(nome, cognome, dataNascita);
		this.codice = codice;
	}

	public String getCodice() {
		return codice;
	}
	
		

}
