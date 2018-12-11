package capeggio;

public class ProgCampeggio {
	
	public Campeggio creaCampeggio() {
		Tastiera t = new Tastiera();
		System.out.println("\n\tINSERIRE I DATI DEL CAMPEGGIO");
		System.out.print(" Inserire il nome: ");
		String nome = t.leggiString();
		System.out.print(" Inserire l'indirizzo: ");
		String ind = t.leggiString();
		System.out.print(" Inserire la latitudine: ");
		float lat = t.leggiFloat();
		System.out.print(" Inserire la longitudine: ");
		float lon = t.leggiFloat();
		return new Campeggio(nome, ind, lat, lon);
	}

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		ProgCampeggio p = new ProgCampeggio();
		System.out.println("\n Inizializzazione di un campeggio");
		Campeggio camp = p.creaCampeggio();
		int scelta = 0;
		do {
			System.out.println("\n\tGESTIONE CAMPEGGI");
			System.out.println(" 1 - scelta di un campeggio su Google Maps");
			System.out.println(" 2 - calcolo distanza del campeggio da un punto geografico");
			System.out.println(" 3 - visualizzazione informazioni del campeggio");
			System.out.println(" 0 - uscita");
			System.out.print(" Inserire la scelta: ");
			scelta = t.leggiInt();
			switch(scelta) {
			case 1:
				camp = p.creaCampeggio();
				break;
				
			case 2:
				System.out.print(" Inserire la latitudine del punto: ");
				float lat = t.leggiFloat();
				System.out.print(" Inserire la longitudine del punto: ");
				float lon = t.leggiFloat();
				System.out.println(" Distanza campeggio - punto: "+camp.distanzaDaPunto(lat, lon)+" km");
				break;
				
			case 3:
				System.out.println(camp.toString());
				break;
				
			case 0:
				System.out.println(" Uscita");
				break;
				
			default:
				System.out.println(" Modalita' non riconosciuta");
			
			}
			
		}
		while(scelta != 0);
				
	}

}
