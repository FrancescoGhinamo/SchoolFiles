package es2;

public class SaldoNegativoException extends Exception {

	/**
	 * default serial version ID
	 */
	private static final long serialVersionUID = 1L;

	public SaldoNegativoException() {
		super("Movimento non registrabile: saldo insufficiente");
	}
}
