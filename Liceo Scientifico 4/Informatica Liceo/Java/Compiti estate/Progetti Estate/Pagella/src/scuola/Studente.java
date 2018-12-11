package scuola;

public class Studente {
	
	private String nome;
	private Pagella pagella;
	
	public Studente(String nome) {
		this.nome = nome;
		registraPagella(creaPagella());
	}
	
	public float calcolaMedia() {
		return pagella.calcolaMedia();
	}
	
	public boolean isSufficiente() {
		boolean suff = false;
		if(calcolaMedia() >= 6) {
			suff = true;
		}
		return suff;
	}
	
	public Pagella creaPagella() {
		return new Pagella();
	}
	
	public void registraPagella(Pagella p) {
		System.out.println("\n\tREGISTRAZIONE DI UNA PAGELLA");
		this.pagella = p;
	}

	public String getNome() {
		return nome;
	}

	public Pagella getPagella() {
		return pagella;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n Studente: "+nome;
		ris += "\n Pagella:\n";
		ris += pagella.toString();
		return ris;
	}

}
