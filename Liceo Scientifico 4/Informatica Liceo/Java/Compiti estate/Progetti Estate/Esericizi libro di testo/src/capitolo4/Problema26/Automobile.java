package capitolo4.Problema26;

public class Automobile {

	private float velocitaKmH;
	
	public Automobile() {
		this.velocitaKmH = 50;
	}
	
	
	public void accelera() {
		this.velocitaKmH = velocitaKmH + 5;
		if(velocitaKmH > 90) {
			System.out.println("\n\n Vai troppo forte. Rallenta");
		}
	}
	
	public void frena() {
		this.velocitaKmH = velocitaKmH - 10;
		if(this.velocitaKmH < 0) {
			this.velocitaKmH = 0;
		}
		else {
			if(velocitaKmH > 90) {
				System.out.println("\n\n Vai troppo forte. Rallenta");
			}
		}
	}
	
	
	public void manovra() {
		Tastiera t = new Tastiera();
		String azione = "";
		do {
			System.out.println(" Velocità corrente: "+velocitaKmH+" km / h");
			System.out.println(" Accelerare: 'A'");
			System.out.println(" Frenare: 'F");
			System.out.print(" Inserire l'operazione: ");
			azione = t.leggiString().toLowerCase();
			switch(azione) {
			case "a":
				accelera();
				break;
				
			case "f":
				frena();
				break;
				
			default:
				System.out.println(" Uscita");
				azione = "e";
			}
		}
		while(azione != "e");
	}
	
	public float getVelocitaKmH() {
		return velocitaKmH;
	}



	public void setVelocitaKmH(float velocitaKmH) {
		this.velocitaKmH = velocitaKmH;
	}



	public static void main(String[] args) {
		Automobile auto = new Automobile();
		auto.manovra();

	}

}
