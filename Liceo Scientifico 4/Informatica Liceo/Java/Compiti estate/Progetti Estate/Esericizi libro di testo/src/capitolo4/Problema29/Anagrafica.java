package capitolo4.Problema29;

public class Anagrafica {
	
	public String nome;
	public String cognome;
	
	private String email;
	private boolean registrata;
	
	public void registraEmail(String p_email) {
		this.email = p_email;
		this.registrata = true;
	}
	
	public void stampaDati() {
		System.out.println("Nome		= "+nome);
		System.out.println("Cognome		= "+cognome);
		if(registrata) {
			System.out.println("Email		= "+email);
		}
		else {
			System.out.println("Email non registrata");
		}
	}

}
