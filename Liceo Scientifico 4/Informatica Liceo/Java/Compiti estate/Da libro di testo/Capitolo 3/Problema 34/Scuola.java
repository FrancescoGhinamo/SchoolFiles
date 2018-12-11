package capitolo3.Problema34;

public class Scuola {
	
	private static final int N = 5;
	
	private Classe[] classi;
	
	public Scuola() {
		Tastiera t = new Tastiera();
		classi = new Classe[N];
		System.out.println(" Inserire il numero di studenti nelle classi");
		for(int c = 0; c < N; c++) {
			classi[c] = new Classe(t.leggiInt());
		}
	}
	
	public int alunniTot() {
		int tot = 0;
		for(int c = 0; c < N; c++) {
			tot += classi[c].getNumAlunni();
		}
		return tot;
	}
	
	public float mediaPerClasse() {
		return ((float) alunniTot() / (float) N);
	}

	public static void main(String[] args) {
		Scuola s = new Scuola();
		System.out.println(" Totale alunni: "+s.alunniTot());
		System.out.println(" Media per classe: "+s.mediaPerClasse());
	}
}
