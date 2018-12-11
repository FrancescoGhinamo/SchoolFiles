package capitolo4.Problema33;

import java.awt.Color;

public class TriangoloColorato extends Triangolo {
	
	private Color coloreSfondo;
	private Color coloreBordo;

	public TriangoloColorato(double cat1, double cat2) {
		super(cat1, cat2);
		// TODO Auto-generated constructor stub
	}
	
	public void impostaColori(Color coloreSfondo, Color coloreBordo) {
		this.coloreSfondo = coloreSfondo;
		this.coloreBordo = coloreBordo;
	}
	
	public void impostaColori(Color coloreBordo) {
		this.coloreBordo = coloreBordo;
	}

}
