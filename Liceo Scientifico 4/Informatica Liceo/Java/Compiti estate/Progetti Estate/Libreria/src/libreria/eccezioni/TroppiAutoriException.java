package libreria.eccezioni;

public class TroppiAutoriException extends Exception {

	public TroppiAutoriException() {
		super("Massimo numero di autori superato");
		
	}
	
}
