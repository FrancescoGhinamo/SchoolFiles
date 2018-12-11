package capitolo3.Problema41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tastiera {

	public String leggiString() {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(in);
		String line = "";
		try {
			line = buff.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return line;
	}
	
	public double leggiDouble() {
		return Double.parseDouble(leggiString());
	}
	
	public int leggiInt() {
		return Integer.parseInt(leggiString());
	}
	
	public float leggiFloat() {
		return Float.parseFloat(leggiString());
	}
}
