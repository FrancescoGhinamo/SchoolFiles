package capitolo4.Problema27;

public class Automobile {

	private float velocitaKmH;
	private boolean accesa;
	
	public Automobile() {
		this.velocitaKmH = 0;
		this.accesa = false;
	}
	
	
	public void accelera() {
		if(accesa) {
			this.velocitaKmH = velocitaKmH + 5;
		}
		else {
			System.out.println("\t Devi prima accendere la macchina");
		}
		
		if(velocitaKmH > 90) {
			System.out.println("\n\n Vai troppo forte. Rallenta");
		}
	}
	
	public void frena() {
		if(accesa) {
			this.velocitaKmH = velocitaKmH - 10;
		}
		else {
			System.out.println("\t Devi prima accendere la macchina");
		}
		
		if(this.velocitaKmH < 0) {
			this.velocitaKmH = 0;
		}
		else {
			if(velocitaKmH > 90) {
				System.out.println("\n\n Vai troppo forte. Rallenta");
			}
		}
	}
	
	public void accendi() {
		this.accesa = true;
		this.velocitaKmH = 0;
	}
	
	public void spegni() {
		this.velocitaKmH = 0;
		this.accesa = false;
	}
	
	
	public void manovra() {
		Tastiera t = new Tastiera();
		String azione = "";
		do {
			System.out.println("\n Macchina accesa: "+accesa);
			System.out.println(" Velocità corrente: "+velocitaKmH+" km / h");
			System.out.println(" Accendere la macchina: 'I");
			System.out.println(" Spegnere la macchine: 'S'");
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
				
			case "i":
				accendi();
				break;
				
			case "s":
				spegni();
				break;
				
				
			default:
				System.out.println(" Uscita");
				azione = "e";
			}
		}
		while(azione != "e");
	}
	
	
	public static void main(String[] args) {
		Automobile auto = new Automobile();
		auto.manovra();

	}

}
