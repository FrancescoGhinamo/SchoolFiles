package zoo;

import java.util.ArrayList;

import animali.Animale;

/**
 * classe per rappresentare una gabbia contenente animali
 * @author Francesco
 *
 */
public class Gabbia {
	private String codice;
	private ArrayList<Animale> animali;

	public Gabbia(String codice) {
		this.animali = new ArrayList<Animale>();
		this.codice = codice;
	}

	
	public void aggiungiAnimale(Animale a) {
		animali.add(a);
	}
	
	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	

	public ArrayList<Animale> getAnimali() {
		return animali;
	}

	public void setAnimali(ArrayList<Animale> animali) {
		this.animali = animali;
	}

//	public void copiaAnimali(Animale[] destinazione) {
//		for(int c = 0; c < animali.length; c++) {
//			destinazione[c] = animali[c];
//		}
//	}


	public String toString() {
		String ris = "";
		ris += "\t\tGABBIA "+codice;
		ris += "\n\t Numero animali: "+animali.size();
		for(Animale a: animali) {
			ris += "\n"+a.toString()+"\n";
		}
		return ris;
	}
	

}
