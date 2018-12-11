package equazione.eccezioni;

public class InserimentoErratoException extends Exception {

	private static final long serialVersionUID = 1299387591944837392L;
	
	public InserimentoErratoException() {
		super("Dati inseriti errati o mancanti.\nInserire una equazione nella forma y=mx+q");
	}

}
