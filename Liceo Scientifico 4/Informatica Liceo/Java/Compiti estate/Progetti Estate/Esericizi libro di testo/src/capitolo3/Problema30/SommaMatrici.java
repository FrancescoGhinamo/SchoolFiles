package capitolo3.Problema30;

public class SommaMatrici {

	public static void main(String[] args) {
		SommaMatrici somma = new SommaMatrici();
		int[][] mat1 = new int[2][2];
		int[][] mat2 = new int[2][2];
		System.out.println(" Caricamento matrice 1:");
		somma.caricaMatrice(mat1);
		System.out.println(" Caricamento matrice 2:");
		somma.caricaMatrice(mat2);
		System.out.println(" Somma 1: "+somma.somma(mat1));
		System.out.println(" Somma 2: "+somma.somma(mat2));
		
		

	}
	
	public void caricaMatrice(int[][] mat) {
		Tastiera t = new Tastiera();
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.println(" Inserire l'elemento "+i+" "+j+": ");
				mat[i][j] = t.leggiInt();
			}
		}
	}
	
	public int somma(int[][] mat) {
		int somma = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				somma += mat[i][j];
			}
		}
		return somma;
	}

}
