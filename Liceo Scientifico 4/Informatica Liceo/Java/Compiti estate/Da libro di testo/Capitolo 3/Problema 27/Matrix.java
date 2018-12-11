package capitolo3.Problema27;

public class Matrix {

	public static void main(String[] args) {
		Matrix m = new Matrix();
		int tab[][] = new int[3][4];
		System.out.println(" Inizializzazione radom");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				tab[i][j] = (int) (Math.random() * 10);
			}
		}
		
		for(int c = 0; c < 3; c++) {
			System.out.println("Somma riga "+c+m.sommaRiga(tab, c));
		}
		
		for(int c = 0; c < 4; c++) {
			System.out.println("Somma colonna "+c+m.sommaColonna(tab, c));
		}
	}
	
	public double sommaRiga(int[][] matrice, int riga)  {
		double somma = 0.0;
		for(int i = 0; i < 4; i++) {
			somma += matrice[riga][i];
		}
		return somma;
	}
	
	public double sommaColonna(int[][] matrice, int colonna) {
		double somma = 0.0;
		for(int i = 0; i < 3; i++) {
			somma += matrice[i][colonna];
		}
		return somma;
	}
}
