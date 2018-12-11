package numeri;

public class SequenzaNumerica {
	
	private int numeroIniziale;
	private int numeroFinale;
	
	public SequenzaNumerica(int inizio, int fine) {
		this.numeroIniziale = inizio;
		this.numeroFinale = fine;
	}
	
	public void stampaSequenza() {
		for(int i = numeroIniziale; i <= numeroFinale; i++) {
			System.out.print(" "+i);
		}
	}

	public static void main(String[] args) {
		SequenzaNumerica s = new SequenzaNumerica(5, 90);
		s.stampaSequenza();
	}

}
