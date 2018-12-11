package capitolo4.Problema19;

public class Email {

	private String destinatario;
	private String mittente;
	private String oggettoETesto;
	
	
	
	public Email(String destinatario, String mittente, String oggettoETesto) {
		this.destinatario = destinatario;
		this.mittente = mittente;
		this.oggettoETesto = oggettoETesto;
	}

	public String toString() {
		String ris = "";
		ris += "\n Destinatario: "+destinatario;
		ris += "\n Mittente: "+mittente;
		ris += "\n Oggetto e testo:\n"+oggettoETesto;
		return ris;
	}


	public static void main(String[] args) {
		Email mail = new Email("test@mail.it", "io@email.com", " Prova\n Questo e' un messaggio di prova");
		System.out.println("Email creata:\n"+mail.toString());

	}

}
