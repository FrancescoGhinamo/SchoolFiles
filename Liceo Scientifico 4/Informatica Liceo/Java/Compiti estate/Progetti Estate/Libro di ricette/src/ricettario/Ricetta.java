package ricettario;

public class Ricetta {

	private String nome;
	private String ingredienti;
	private String procedimento;
	public Ricetta(String nome, String ingredienti, String procedimento) {
		super();
		this.nome = nome;
		this.ingredienti = ingredienti;
		this.procedimento = procedimento;
	}
	public String getNome() {
		return nome;
	}
	public String getIngredienti() {
		return ingredienti;
	}
	public String getProcedimento() {
		return procedimento;
	}
	
	public String toString() {
		String ris = "\n\tRICETTA";
		ris += "\n Nome: "+nome;
		ris += "\n Ingredienti: "+ingredienti;
		ris += "\n Procedimento: "+procedimento;
		return ris;
	}
}
