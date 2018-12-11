package wrapper.eccezzioni;

public class NumeroNegativoException extends Exception {

	public NumeroNegativoException() {
		super("Il numero corrente e' negativo");
	}
}
