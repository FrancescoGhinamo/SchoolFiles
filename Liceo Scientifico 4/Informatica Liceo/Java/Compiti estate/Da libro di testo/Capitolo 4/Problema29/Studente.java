package capitolo4.Problema29;

public class Studente extends Anagrafica {

	public String matricola;
	
	public void stampaDati() {
		super.stampaDati();
		System.out.println("Matricola	= "+matricola);
	}
	
	public static void main(String[] ags) {
		Studente s = new Studente();
		s.nome = "Francesco";
		s.cognome = "Ghinamo";
		s.matricola = "68223";
		s.registraEmail("francesco.ghinamo@hotmail.com");
		s.stampaDati();
	}
	
}
