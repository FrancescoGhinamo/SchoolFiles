package animali;

import java.util.GregorianCalendar;
/**
 * estensione della classe Animale pe la rappresentazione di un pinguino
 * @author Francesco
 *
 */
public class Pinguino extends Animale {

	public Pinguino(String nome, String matricola, GregorianCalendar nascita, GregorianCalendar arrivo, float kg) {
		this.setNome(nome);
		this.setMatricola(matricola);
		this.setDataNascita(nascita);
		this.setDataArrivo(arrivo);
		this.setPesoKg(kg);

	}

	public void stampaCaratteristiche() {
		System.out.println("\n\tCaratteristiche dell'animale:");
		System.out.println(" Specie: pinguino");
		System.out.println(" Nome: "+getNome());
		System.out.println(" Matricola: "+getMatricola());
		System.out.println(" Data di nascita: "+getDataNascita().toString());
		System.out.println(" Data di arrivo allo zoo: "+getDataArrivo().toString());
		System.out.println(" Peso: "+getPesoKg()+" kg");
	}
	
	public String toString() {
		String ris = "";
		ris += "\t\t\tPINGUINO";
		ris += super.toString();
		return ris;
	}


}
