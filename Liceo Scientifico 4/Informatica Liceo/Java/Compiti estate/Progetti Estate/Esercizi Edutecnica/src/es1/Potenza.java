package es1;

import common.Tastiera;

public class Potenza {
	
	private float base;
	
	public Potenza(float b) {
		this.base = b;
	}
	
	public void pow() {
		System.out.println(base * base);
	}
	
	public void cambioBase() {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la nuova base: ");
		base = t.leggiFloat();
	}

	public static void main(String[] args) {
		Potenza p = new Potenza(2);
		p.pow();
		p.cambioBase();
		p.pow();

	}

}
