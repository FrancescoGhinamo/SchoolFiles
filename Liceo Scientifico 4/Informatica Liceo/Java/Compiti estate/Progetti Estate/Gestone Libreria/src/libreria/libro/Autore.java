package libreria.libro;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Autore {

	private String codice;
	private String nome;
	private String cognome;
	private GregorianCalendar dataNascita;
	public Autore(String codice, String nome, String cognome, GregorianCalendar dataNascita) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
	}
	public String getCodice() {
		return codice;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public GregorianCalendar getDataNascita() {
		return dataNascita;
	}
	
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String ris = "";
		ris += "\n Dati autore";
		ris += "\n Codice: "+codice;
		ris += "\n Nome: "+nome;
		ris += "\n Cognome: "+cognome;
		ris += "\n Data di nascita: "+fmt.format(dataNascita.getTime());
		return ris;
	}
}
