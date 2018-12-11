package intefaccia;

import java.io.IOException;
import java.io.InputStreamReader;

public class UsingInt implements ITesto {

	public static void main(String[] args) {
		UsingInt test = new UsingInt();
		String testo = test.leggiContenuto();
		System.out.println(" Testo inserito: "+testo);
		System.out.println(" Occorrenze di ciao: "+test.numeroOccorrenze(testo, "ciao"));

	}

	@Override
	public String leggiContenuto() {
		StringBuffer ris = new StringBuffer();
		InputStreamReader in = new InputStreamReader(System.in);
		char ch = 0;
		do {
			ris.append(ch);
			try {
				ch = (char) in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(ch != '>');
		ris.deleteCharAt(0);
		return ris.toString();
	}

	@Override
	public int numeroOccorrenze(String testo, String parola) {
		int occ = 0;
		do {
			if(testo.contains(parola)) {
				occ++;
				testo = testo.substring(0, testo.lastIndexOf(parola));
			}
		}
		while(testo.length() > 0);
		return occ;
	}
	

}
