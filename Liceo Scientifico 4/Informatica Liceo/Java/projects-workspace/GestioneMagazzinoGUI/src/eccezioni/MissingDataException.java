package eccezioni;

public class MissingDataException extends Exception {

	private static final long serialVersionUID = 6799063838452260526L;

	public MissingDataException() {
		super("Si prega di inserire tutti i dati riguardanti il prodotto");
	}
	
}
