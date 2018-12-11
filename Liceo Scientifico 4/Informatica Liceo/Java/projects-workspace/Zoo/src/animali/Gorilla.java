package animali;

import java.util.GregorianCalendar;
/**
 * estensione della classe Animale per la rappresentazione di un gorilla
 * @author Francesco
 *
 */
public class Gorilla extends Animale {
	private TipoPelo pelo;

	public Gorilla(String nome, String matricola, GregorianCalendar nascita, GregorianCalendar arrivo, float kg, TipoPelo pelo) {
		this.setNome(nome);
		this.setMatricola(matricola);
		this.setDataNascita(nascita);
		this.setDataArrivo(arrivo);
		this.setPesoKg(kg);
		this.setPelo(pelo);		
	}

	public void stampaCaratteristiche() {
		System.out.println("\n\tCaratteristiche dell'animale:");
		System.out.println(" Specie: gorilla");
		System.out.println(" Nome: "+getNome());
		System.out.println(" Matricola: "+getMatricola());
		System.out.println(" Data di nascita: "+getDataNascita().toString());
		System.out.println(" Data di arrivo allo zoo: "+getDataArrivo().toString());
		System.out.println(" Peso: "+getPesoKg()+" kg");
		System.out.println(" Tipo pelo: "+getPelo());
	}

	public TipoPelo getPelo() {
		return pelo;
	}

	public void setPelo(TipoPelo pelo) {
		this.pelo = pelo;
	}

	public String toString() {
		String ris = "";
		ris += "\t\t\tGORILLA";
		ris += super.toString();
		ris += "\n\t\t Tipo pelo: "+pelo;
		return ris;
	}


}
