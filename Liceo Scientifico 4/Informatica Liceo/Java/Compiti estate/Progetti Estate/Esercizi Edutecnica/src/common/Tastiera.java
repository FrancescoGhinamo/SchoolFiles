package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

	public String leggiString() {
		String ris = "";
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(in);
		try {
			ris = r.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ris;
	
	}
	
	public int leggiInt() {
		return Integer.parseInt(leggiString());
	}
	
	public float leggiFloat() {
		return Float.parseFloat(leggiString());
	}
	
	public boolean leggiBoolean() {
		return Boolean.parseBoolean(leggiString());
	}
}
