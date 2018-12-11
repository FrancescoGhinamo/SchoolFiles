package centralinaAuto;

public class Parametro {
	
	private int codiceNumerico;
	private String descrizione;
	private int valore;
	private Categoria categoria;
	
	
	public Parametro(int codiceNumerico, String descrizione, int valore, Categoria categoria) {
		super();
		this.codiceNumerico = codiceNumerico;
		this.descrizione = descrizione;
		this.valore = valore;
		this.categoria = categoria;
	}

	
	
	

	public int getCodiceNumerico() {
		return codiceNumerico;
	}


	public String getDescrizione() {
		return descrizione;
	}


	public int getValore() {
		return valore;
	}


	public Categoria getCategoria() {
		return categoria;
	}
	
	
	
	public String toString() {
		String ris = "\n PARAMETRO";
		ris += "\n Codice numerico: "+codiceNumerico;
		ris += "\n Descrizione: "+descrizione;
		ris += "\n Valore: "+valore;
		ris += "\n Categoria: "+categoria;
		return ris;
	}
	
	
	
	

}
