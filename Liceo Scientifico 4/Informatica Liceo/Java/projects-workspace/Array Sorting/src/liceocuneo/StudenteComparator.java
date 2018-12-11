package liceocuneo;

import java.util.Comparator;

public class StudenteComparator implements Comparator<Studente> {

	private Criterio c;
	
	
	
	public StudenteComparator(Criterio c) {
		super();
		this.c = c;
	}



	@Override
	public int compare(Studente s1, Studente s2) {

		int ris = 0;
		
		switch(c)  {
		case COGNOME:
			ris = s1.getCognome().compareTo(s2.getCognome());
			break;
		case NOME:
			ris = s1.getNome().compareTo(s2.getNome());
			break;
		
		
		}
		//ordinamento crescente secondo il cognome
		return ris;
	}

}
