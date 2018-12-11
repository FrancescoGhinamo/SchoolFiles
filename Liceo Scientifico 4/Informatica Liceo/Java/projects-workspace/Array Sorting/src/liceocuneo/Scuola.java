package liceocuneo;

import java.util.ArrayList;

public class Scuola {
	
	private ArrayList<Studente> elencoStudenti;
	
	public Scuola() {
		elencoStudenti = new ArrayList<Studente>();
	}
	
	public void aggiungiStudente(Studente s) {
		elencoStudenti.add(s);
	}
	
	public void visualizzaStudenti() {
		for(int i = 0; i < elencoStudenti.size(); i++) {
			//se non faccio il toString mi visualizza Classediappartenenza@indirizzodimemoriainesadecimale
			System.out.println(elencoStudenti.get(i));
		}
	}
	
	public void ordina() {
		elencoStudenti.sort(new StudenteComparator(Criterio.NOME));
	}
	
	public static void main(String[] args) {
		Scuola s = new Scuola();
		Studente s1 = new Studente("Mario", "Rossi");
		Studente s2 = new Studente("Luigi", "Bianchi");
	
		s.aggiungiStudente(s1);
		s.aggiungiStudente(s2);
		s.ordina();
		s.visualizzaStudenti();
		
	}
		

}
