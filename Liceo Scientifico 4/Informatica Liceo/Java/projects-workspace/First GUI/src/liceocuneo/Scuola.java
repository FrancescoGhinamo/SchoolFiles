package liceocuneo;

import java.util.Hashtable;

public class Scuola {
	
	/**
	 * Hashtable che contiene oggetti Studente passando come chiave una String
	 */
	private Hashtable<String, Studente> mapStudenti;
	
	public Scuola() {
		mapStudenti = new Hashtable<String, Studente>();
	}
	
	public void aggiungiStudente(Studente s) {
		//registro uno studente dando la matricola come chiave
		mapStudenti.put(s.getMatricola(), s);
		
	}
	
	public Studente cercaStudente(String matricola) {
		return mapStudenti.get(matricola);
	}
	
	
	
	public static void main(String[] args) {
		
	}
		

}
