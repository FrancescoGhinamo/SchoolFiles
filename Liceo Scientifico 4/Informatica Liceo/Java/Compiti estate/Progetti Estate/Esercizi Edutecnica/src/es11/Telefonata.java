package es11;

public class Telefonata {
	
	private String destinatario;
	private int durataMin;
	
	public Telefonata(String destinatario, int min) {
		this.destinatario = destinatario;
		this.durataMin = min;
	}

	
	public String getDestnatario() {
		return destinatario;
	}


	public int getDurataMin() {
		return durataMin;
	}
	
	
	public String toString() {
		String ris = "";
		ris += "\n\tTELEFONATA";
		ris += "\n - Destinatario: "+destinatario;
		ris += "\n - Durata in minuti: "+durataMin;
		return ris;
	}
	
	

}
