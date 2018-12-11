package zoo;

import java.util.Enumeration;
import java.util.Hashtable;

import animali.Animale;

public class Zoo {
	
	private Hashtable<String, Gabbia> gabbie;
	
	public Zoo() {
		gabbie = new Hashtable<String, Gabbia>();
	}
	
	public void aggiungiGabbia(Gabbia g) {
		gabbie.put(g.getCodice(), g);
	}
	
	public void aggiungiAnimale(String codiceGabbia, Animale a) {
		gabbie.get(codiceGabbia).aggiungiAnimale(a);
		
	}

	public Hashtable<String, Gabbia> getGabbie() {
		return gabbie;
	}

	public void setGabbie(Hashtable<String, Gabbia> gabbie) {
		this.gabbie = gabbie;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n\tCARATTERISTICHE DELLO ZOO";
		Enumeration<String> keys = gabbie.keys();
		while(keys.hasMoreElements()) {
			ris += "\n"+gabbie.get(keys.nextElement()).toString();
		}
		return ris;
	}
	
	

}
