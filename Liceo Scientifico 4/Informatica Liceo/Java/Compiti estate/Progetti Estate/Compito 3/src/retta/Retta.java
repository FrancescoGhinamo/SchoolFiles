package retta;

public class Retta {
	
	private float m;
	private float q;
	
	

	public Retta(float m, float q) {
		super();
		this.m = m;
		this.q = q;
	}
	
	public boolean passaPerOrigine() {
		return passaPerPunto(new Punto(0, 0));
	}

	public boolean passaPerPunto(Punto p) {
		boolean passa = false;
		if(p.getY() == m * p.getX() + q) {
			passa = true;
		}
		return passa;
	}
	
	public void visualizzaEquazioneEsplicita() {
		System.out.println(" y = "+m+"x + "+q);
	}


	public static void main(String[] args) {
		Retta r = new Retta(3, 4);
		System.out.print(" Equazione esplicita: ");
		r.visualizzaEquazioneEsplicita();
		System.out.println(" Passa per origine: "+r.passaPerOrigine());
		System.out.println(" Passa per punto (0, 4): "+r.passaPerPunto(new Punto(0, 4)));

	}

}
