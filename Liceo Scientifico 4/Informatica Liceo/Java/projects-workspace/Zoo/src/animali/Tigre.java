package animali;


import java.util.GregorianCalendar;
/**
 * estensione della classe Animale per la rappresentazione di una tigre
 * @author Francesco
 *
 */
public class Tigre extends Animale {
	private TipoPelo pelo;

	public Tigre(String nome, String matricola, GregorianCalendar nascita, GregorianCalendar arrivo, float kg, TipoPelo pelo) {
		this.setNome(nome);
		this.setMatricola(matricola);
		this.setDataNascita(nascita);
		this.setDataArrivo(arrivo);
		this.setPesoKg(kg);
		this.setPelo(pelo);		
	}

	public void stampaCaratteristiche() {
		System.out.println("\n\tCaratteristiche dell'animale:");
		System.out.println(" Specie: tigre");
		System.out.println(" Nome: "+getNome());
		System.out.println(" Matricola: "+getMatricola());
		System.out.println(" Data di nascita: "+getDataNascita().toString());
		System.out.println(" Data di arrivo allo zoo: "+getDataArrivo().toString());
		System.out.println(" Peso: "+getPesoKg()+" kg");
		System.out.println(" Tipo pelo: "+getPelo());
	}

	public String toString() {
		String ris = "";
		ris += "\t\t\tTIGRE";
		ris += super.toString();
		ris += "\n\t\t Tipo pelo: "+pelo;
		return ris;
	}


	public TipoPelo getPelo() {
		return pelo;
	}
	public void setPelo(TipoPelo pelo) {
		this.pelo = pelo;
	}
}