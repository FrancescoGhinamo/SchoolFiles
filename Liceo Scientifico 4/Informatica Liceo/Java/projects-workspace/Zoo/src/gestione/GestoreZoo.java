package gestione;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import animali.Animale;
import animali.Gorilla;
import animali.Pinguino;
import animali.Tigre;
import animali.TipoAnimale;
import animali.TipoPelo;
import zoo.Gabbia;
import zoo.Zoo;

public class GestoreZoo {

private Zoo zoo;
	
	public GestoreZoo() {
		zoo = new Zoo();
	}
	
	public Animale creaAnimale(TipoAnimale t, String nome, String matricola, String dataNascita, String dataArrivo, float peso,
			TipoPelo pelo) throws ParseException {
		Animale an = null;
		
		switch(t) {
		case GORILLA:
			an = creaGorilla(nome, matricola, dataNascita, dataArrivo, peso, pelo);
			break;
		case PINGUINO:
			an = creaPinguino(nome, matricola, dataNascita, dataArrivo, peso);
			break;
		case TIGRE:
			an = creaTigre(nome, matricola, dataNascita, dataArrivo, peso, pelo);
			break;
		default:
			
			break;
		
		}
		return an;
		
	}
	
	public Gorilla creaGorilla(String nome, String matricola, String dataNascita, String dataArrivo, float peso,
			TipoPelo pelo) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar dataN = new GregorianCalendar();
		dataN.setTime(fmt.parse(dataNascita));
		GregorianCalendar dataA = new GregorianCalendar();
		dataA.setTime(fmt.parse(dataArrivo));
		return new Gorilla(nome, matricola, dataN, dataA, peso, pelo);
		
	}
	
	public Pinguino creaPinguino(String nome, String matricola, String dataNascita, String dataArrivo, float peso) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar dataN = new GregorianCalendar();
		dataN.setTime(fmt.parse(dataNascita));
		GregorianCalendar dataA = new GregorianCalendar();
		dataA.setTime(fmt.parse(dataArrivo));
		return new Pinguino(nome, matricola, dataN, dataA, peso);
	}
	
	public Tigre creaTigre(String nome, String matricola, String dataNascita, String dataArrivo, float peso,
			TipoPelo pelo) throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar dataN = new GregorianCalendar();
		dataN.setTime(fmt.parse(dataNascita));
		GregorianCalendar dataA = new GregorianCalendar();
		dataA.setTime(fmt.parse(dataArrivo));
		return new Tigre(nome, matricola, dataN, dataA, peso, pelo);
	}
	
	
	public Gabbia creaGabbia(String codice) {
		return new Gabbia(codice);
	}
	
	public void aggiungiGabbia(String codice) {
		zoo.aggiungiGabbia(creaGabbia(codice));
	}
	
	public void aggiungiAnimale(String codiceGabbia, TipoAnimale t, String nome, String matricola, String dataNascita, String dataArrivo, float peso,
			TipoPelo pelo) throws ParseException {
		zoo.aggiungiAnimale(codiceGabbia, creaAnimale(t, nome, matricola, dataNascita, dataArrivo, peso, pelo));
	}
	
	public String datiZoo() {
		return zoo.toString();
	}
	
	public Zoo getZoo() {
		return zoo;
	}

	public void setZoo(Zoo zoo) {
		this.zoo = zoo;
	}
	
	

}
