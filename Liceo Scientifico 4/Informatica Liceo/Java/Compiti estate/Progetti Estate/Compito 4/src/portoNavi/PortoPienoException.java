package portoNavi;

public class PortoPienoException extends Exception {

	private static final long serialVersionUID = 1L;

	public PortoPienoException() {
		super("Il porto e' al completo");
	}
}
