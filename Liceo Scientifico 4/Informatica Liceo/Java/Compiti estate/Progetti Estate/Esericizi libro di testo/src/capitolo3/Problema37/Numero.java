package capitolo3.Problema37;

import java.util.Vector;

public class Numero {

	private int val;
	
	
	public Numero(int val) {
		super();
		this.val = val;
	}

	public int[] convertiInBinario() {
		int[] ris = new int[32];
		for(int c = 0; c < 32; c++) {
			ris[c] = 0;
		}
		int _i = 31;
		int _val = val;
		do {
			ris[_i] = _val % 2;
			_val /= 2;
			_i--;
			
		}
		while(_val > 0);
			
		return ris;
	}
	
	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire un numero intero: ");
		Numero num = new Numero(t.leggiInt());
		int[] bin = num.convertiInBinario();
		System.out.println(" Converisione in binario:");
		for(int c = 0; c < bin.length; c++) {
			System.out.print(bin[c]);
		}
	}

}
