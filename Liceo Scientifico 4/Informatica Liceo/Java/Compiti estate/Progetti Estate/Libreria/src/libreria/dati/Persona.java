package libreria.dati;

import java.util.GregorianCalendar;

public abstract class Persona {

	private String nome;
	private String cognome;
	private GregorianCalendar dataNascita;
	
	
	public Persona(String nome, String cognome, GregorianCalendar dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
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
	
	
	
	
}
