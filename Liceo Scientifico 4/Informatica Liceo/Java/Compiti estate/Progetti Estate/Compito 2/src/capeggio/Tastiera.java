package capeggio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
//import java.sql.Date;		deprecated
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 * La classe permette di inserire facilmente da tastiera valori di tipo:
 * -int
 * -boolean
 * -float
 * -double
 * -long
 * -String
 * -Date
 * -Calendar
 * 
 * Ogni metodo restituisce il dato inserito da tastiera
 * @author Francesco
 *
 */
public class Tastiera {


	public String leggiString() {
		InputStreamReader in = new InputStreamReader(System.in);					//lettore stream
		BufferedReader tastiera = new BufferedReader(in);							//lettore buffer
		String str = "";															//stringa in cui verrà memorizzata una linea
		try {																		//se non ci sono anomalie
			str = tastiera.readLine();												//lettura di una linea
		} catch (IOException e) {
			e.printStackTrace();													//eseguito in caso di anomalie
		}

		return str;																	//ritorno del risultato

	}

	public int leggiInt() {

		return Integer.parseInt(leggiString());										//conversione in tipo intero
	}

	public float leggiFloat() {
		return Float.parseFloat(leggiString());
	}

/*	public Date leggiData() {
		return Date.valueOf(leggiString());		
	}*/			//deprecated

	public double leggiDouble() {

		return Double.parseDouble(leggiString());
	}

	public long leggiLong() {
		return Long.parseLong(leggiString());
	}

	public boolean leggiBoolean() {
		return Boolean.parseBoolean(leggiString());
	}
	
	public GregorianCalendar leggiCalendar() {
		String data = leggiString();
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar calendar = new GregorianCalendar();
		try {
			Date d = fmt.parse(data);
			calendar.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar;		
		
		
	}
	
	public Time leggiTime() {
		
		return Time.valueOf(leggiString());
	}
}