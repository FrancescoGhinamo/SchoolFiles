package es9;

import common.Tastiera;

public class InsiemieDiStringhe {
	
	private String[] stringhe;
	
	

	public InsiemieDiStringhe(String[] stringhe) {
		super();
		this.stringhe = stringhe;
	}

	public String stringaLunga() {
		String ris = "";
		for(int c = 0; c < stringhe.length; c++) {
			if(ris.length() < stringhe[c].length()) {
				ris = stringhe[c];
			}
		}
		return ris;
	}
	
	public int contaSpazi(String stringa) {
		int conta = 0;
		for(int i = 0; i < stringa.length(); i++) {
			if(stringa.charAt(i) == ' ') {
				conta ++;
			}
		}
		return conta;
	}
	
	public String spaziStringa() {
		String ris = "";
		for(int c = 0; c < stringhe.length; c++) {
			if(contaSpazi(ris) < contaSpazi(stringhe[c])) {
				ris = stringhe[c];
			}
		}
		return ris;
	}
	
	public void preStringa(String prefisso) {
		for(int c = 0; c < stringhe.length; c++) {
			if(stringhe[c].startsWith(prefisso)) {
				System.out.println(stringhe[c]);
			}
		}
	}

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Quante stringhe inserire? ");
		int n = t.leggiInt();
		String[] _s = new String[n];
		for(int c = 0; c < n; c++) {
			System.out.print(" Inserire la stringa "+(c + 1)+": ");
			_s[c] = t.leggiString();
		}
		
		InsiemieDiStringhe ins = new InsiemieDiStringhe(_s);

		int scelta = 0;
		do {
			System.out.println("\n 1 - trovare la stringa piu' lunga");
			System.out.println(" 2 - trovare la stringa con piu' spazi");
			System.out.println(" 3 - trovare le strighe che iniziano con un prefisso");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire la scelta: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				System.out.println("\n "+ins.stringaLunga());
				break;
				
			case 2:
				System.out.println("\n "+ins.spaziStringa());
				break;
				
			case 3:
				System.out.print(" Inserire un prefisso: ");
				ins.preStringa(t.leggiString());
				break;
				
			case 0:
				System.out.println(" Uscita dal programma");
				break;
				
			default:
				System.out.println(" Opzione non riconosciuta");
			}
			
		}
		while(scelta != 0);
	}

}
