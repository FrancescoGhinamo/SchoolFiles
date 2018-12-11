package utente;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Utente {

	private String cognome;
	private String nome;
	private GregorianCalendar dataNascita;
	private String indirizzo;
	private String numeroTelefono;
	public Utente(String cognome, String nome, GregorianCalendar dataNascita, String indirizzo, String numeroTelefono) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.indirizzo = indirizzo;
		this.numeroTelefono = numeroTelefono;
	}
	
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String ris = "\n\tUTENTE";
		ris += "\n Cognome: "+cognome;
		ris += "\n Nome: "+nome;
		ris += "\n Data di nascita: "+fmt.format(dataNascita.getTime());
		ris += "\n Indirizzo: "+indirizzo;
		ris += "\n Numero di telefono: "+numeroTelefono;
		return ris;
	}
}
