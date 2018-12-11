package liceocuneo;

public class Studente {
	
	private String nome;
	private String cognome;

	public Studente(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public String toString() {
		return nome + " " + cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	

}
