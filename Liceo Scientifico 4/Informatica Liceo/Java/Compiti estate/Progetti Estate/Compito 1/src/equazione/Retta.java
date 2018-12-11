package equazione;

public class Retta {
	
	private float a;
	private float b;
	private float c;
	public Retta(float a, float b, float c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public boolean verificaPassaPerOrigine() {
		return verificaPassaPerPunto(new Punto(0, 0));
	}
	
	public boolean verificaPassaPerPunto(Punto p) {
		boolean passa = false;
		if(a * p.getX() + b * p.getY() + c == 0) {
			passa = true;
		}
		return passa;
	}
	
	public void stampaEquazioneImplicita() {
		System.out.println(a+"x + "+b+"y + "+c+" = 0");
	}
	
	public static void main(String[] args) {
		Retta r = new Retta(3, 4, 0);
		System.out.println(" Passa per origine: "+r.verificaPassaPerOrigine());
		System.out.println(" Passa per (2, 3): "+r.verificaPassaPerPunto(new Punto(2, 3)));
		System.out.print(" Equzione implicita: ");
		r.stampaEquazioneImplicita();
	}

}
