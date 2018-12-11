package libreria.interazione;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Cliente {

	private String nome;
	private String cognome;
	private String codiceFiscale;
	private GregorianCalendar dataNascita;
	
	public Cliente(String nome, String cognome, String codiceFiscale, GregorianCalendar dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public GregorianCalendar getDataNascita() {
		return dataNascita;
	}
	
	public String toString() {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		String ris = "";
		ris += "\n Dati cliente";
		ris += "\n Nome: "+nome;
		ris += "\n Cognome: "+cognome;
		ris += "\n Codice fiscale: "+codiceFiscale;
		ris += "\n Data di nascita: "+fmt.format(dataNascita.getTime());
		return ris;
	}
	
	public boolean equals(Object arg0) {
		Cliente _l = (Cliente) arg0;
		boolean eq = false;
		if(nome == _l.getNome() && cognome == _l.getCognome() && codiceFiscale == _l.getCodiceFiscale() && dataNascita == _l.getDataNascita()) {
			eq = true;
		}
		return eq;
	}
	
}
