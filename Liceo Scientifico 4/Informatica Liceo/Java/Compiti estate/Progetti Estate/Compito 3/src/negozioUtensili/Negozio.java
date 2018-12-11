package negozioUtensili;

import java.util.Vector;

public class Negozio {
	
	private Vector<Utensile> utensili;
	
	public Negozio() {
		utensili = new Vector<Utensile>();
	}
	
	public void stampaUtensiliDaDescrizione(String parola) {
		for(int i = 0; i < utensili.size(); i++) {
			if(utensili.elementAt(i).getDescrizione().contains(parola)) {
				utensili.elementAt(i).stampaCodiceEPrezzo();
			}
		}
	}
	
	
	public Utensile cercaPrezzoMinimo(Qualita q) {
		Utensile _u = new Utensile(null, null, null, Float.MAX_VALUE);
		for(int i = 0; i < utensili.size(); i++) {
			if(utensili.elementAt(i).getPrezzo() <= _u.getPrezzo() && utensili.elementAt(i).getQualita() == q) {
				_u = utensili.elementAt(i);
			}
		}
		
		return _u;
	}
	
	public Utensile cercaPrezzoMassimo(Qualita q) {
		Utensile _u = new Utensile(null, null, null, Float.MIN_VALUE);
		for(int i = 0; i < utensili.size(); i++) {
			if(utensili.elementAt(i).getPrezzo() >= _u.getPrezzo() && utensili.elementAt(i).getQualita() == q) {
				_u = utensili.elementAt(i);
			}
		}
		
		return _u;
	}
	

	public Vector<Utensile> getUtensili() {
		return utensili;
	}

	public static void main(String[] args) {
		Negozio n = new Negozio();
		n.getUtensili().add(new Utensile("a1a2a3", "Traforo per compensato", Qualita.PROFESSIONALE, 100));
		n.getUtensili().add(new Utensile(" abc123", "Martello generico", Qualita.OBBISTICO, 10));
		n.stampaUtensiliDaDescrizione("compensato");
		System.out.println(" Prezzo massimo professionale: "+n.cercaPrezzoMassimo(Qualita.PROFESSIONALE).toString());
		System.out.println(" Prezzo minimo obbistico: "+n.cercaPrezzoMinimo(Qualita.OBBISTICO).toString());
		

	}

}
