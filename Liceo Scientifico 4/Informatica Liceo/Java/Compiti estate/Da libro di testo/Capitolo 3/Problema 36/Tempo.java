package capitolo3.Problema36;

public class Tempo {
	
	private int ore;
	private int minuti;
	private int secondi;
	
	

	public Tempo(int ore, int minuti, int secondi) {
		super();
		this.ore = ore;
		this.minuti = minuti;
		this.secondi = secondi;
	}


	public long convertiInSecondi() {
		return secondi + minuti * 60 + ore * 3600;
	}

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inseire le ore: ");
		int ore = t.leggiInt();
		System.out.print(" Inserire i minuti: ");
		int min = t.leggiInt();
		System.out.print(" Inserire i secondi: ");
		int sec = t.leggiInt();
		Tempo temp = new Tempo(ore, min, sec);
		System.out.println(" Equivalente in secondi: "+temp.convertiInSecondi());
		
		

	}

}
