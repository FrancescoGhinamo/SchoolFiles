package libreria.dati;

import java.util.GregorianCalendar;

public class Cliente extends Persona {
	
	
	private String codiceFiscale;

	public Cliente(String nome, String cognome, GregorianCalendar dataNascita, String codiceFiscale) {
		super(nome, cognome, dataNascita);
		this.codiceFiscale = codiceFiscale;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	
	

}
