package lists;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Set;

public class HashtableList extends Hashtable<Integer, Integer> {

	private static final long serialVersionUID = -4828408711810334658L;
	
	public void put(int val) {
		put(val, val);
	}
	
	public String getElements() {
		String ris = "";
		Enumeration<Integer> keys = this.keys();
		while(keys.hasMoreElements()) {
			ris += keys.nextElement() + " ";
		}
		return ris;
	}
	
	public void printAll() {
		
		//ragiona sul singolo elemento dell'Hashtable
		//li mette tutti in un Enumeration (insieme), scorre ogni elemento e lo stampa, finchè ce ne sono di nuovi
		for(Enumeration<Integer> elS = this.elements(); elS.hasMoreElements();) {
			System.out.println(elS.nextElement());
		}
		
		//struttura foreach;
		Set<Integer> elS = this.keySet();
		for(Integer key: elS) {
			System.out.println(this.get(key));
		}
	}
	

}
