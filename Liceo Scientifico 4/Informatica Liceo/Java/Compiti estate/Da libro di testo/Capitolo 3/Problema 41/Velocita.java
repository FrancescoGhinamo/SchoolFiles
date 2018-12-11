package capitolo3.Problema41;

public class Velocita {
	
	private static final double FATTORE_CONV = 3.6;
	

	public double vel;
	
	
	public Velocita(double vel) {
		super();
		this.vel = vel;
	}
	
	public double convertiInMs() {
		return vel * FATTORE_CONV;
	}


	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la velicita' in km/h: ");
		Velocita vel = new Velocita(t.leggiDouble());
		System.out.println(" Velocita' in m/s: "+vel.convertiInMs());
		

	}

}
