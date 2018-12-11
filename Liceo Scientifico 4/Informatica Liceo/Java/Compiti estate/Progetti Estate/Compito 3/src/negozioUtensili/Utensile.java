package negozioUtensili;

public class Utensile {

	private String codice;
	private String descrizione;
	private Qualita qualita;
	private float prezzo;
	public Utensile(String codice, String descrizione, Qualita qualita, float prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.qualita = qualita;
		this.prezzo = prezzo;
	}
	public String getCodice() {
		return codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public Qualita getQualita() {
		return qualita;
	}
	public float getPrezzo() {
		return prezzo;
	}
	
	public void stampaCodiceEPrezzo() {
		System.out.println("\n\tUTENSILE IN LEGNO");
		System.out.println(" Codice: "+codice);
		System.out.println(" Prezzo: "+prezzo);
	}
	
	public String toString() {
		String ris = "\n\tUTENSILE IN LEGNO";
		ris += "\n Codice: "+codice;
		ris += "\n Descrizione: "+descrizione;
		ris += "\n Qualita: "+qualita;
		ris += "\n Prezzo: "+prezzo+" €";
		return ris;
	}
}
