package voti;

import java.util.ArrayList;
import java.util.Hashtable;

public class ElencoVoti extends ArrayList<Voto> {

	private static final long serialVersionUID = 1L;
	
	public float mediaTotaleStudente(String matricola) {
		float sum = 0;
		int n = 0;
		
		for(Voto v: this) {
			if(v.getMatricola().equals(matricola)) {
				n++;
				sum += v.getValore();
			}
		}
		
		return sum / n;
	}
	
	public Hashtable<Materia, Float> mediaPerMateriaStudente(String matricola) {
		
		/*
		 * meglio con ordinamento, ordinno prima per matricola e poi per materia o viceversa
		 */
		Hashtable<Materia, Float> medie = new Hashtable<Materia, Float>();
		
		ArrayList<Materia> materie = getMaterie();
		for(Materia m: materie) {
			int n = 0;
			int sum = 0;
			for(Voto v: this) {
				if(v.getMatricola().equals(matricola) && v.getMateria().equals(m)) {
					sum += v.getValore();
					n++;
				}
			}
			medie.put(m, (float) (sum / n));
		}
		
		
		return medie;
	}
	
	public ArrayList<Materia> getMaterie() {
		ArrayList<Materia> materie = new ArrayList<Materia>();
		for(Voto v: this) {
			if(!materie.contains(v.getMateria())) {
				materie.add(v.getMateria());
			}
			
		}
		return materie;
	}

}
