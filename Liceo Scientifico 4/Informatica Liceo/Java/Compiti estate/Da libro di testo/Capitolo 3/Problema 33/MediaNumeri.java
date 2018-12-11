package capitolo3.Problema33;

public class MediaNumeri {

	public static void main(String[] args) {
		MediaNumeri m = new MediaNumeri();
		double[] numeri = new double[5];
		for(int c = 0; c < numeri.length; c++) {
			numeri[c] = Math.random();
		}
		
		System.out.println("Media valori generati: "+m.calcolaMedia(numeri));

	}
	
	public double calcolaMedia(double[] arr) {
		double somma = 0.0;
		for(int c = 0; c < arr.length; c++) {
			somma += arr[c];
		}
		return somma / arr.length;
	}

}
