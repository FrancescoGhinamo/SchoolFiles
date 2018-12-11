package liceocuneo;

import java.util.ArrayList;

public class ElencoPersone extends ArrayList<Persona> {
	
	public void aggiungiPersona(Persona p) {
		if(p == null) {
			//eccezione implicita nella dichiarazione dei metodi, anche nei costruttori
			throw new IllegalArgumentException("persona non specificata");
		}
		this.add(p);
	}

}
