package capitolo3.Problema29;

public class SommaNumeri {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		float[] vals = new float[10];
		System.out.println(" Inserire 10 numeri:");
		for(int i = 0; i < vals.length; i++) {
			vals[i] = t.leggiFloat();
		}
		
		float somma = 0.0f;
		for(int i = 0; i < vals.length; i++) {
			somma += vals[i];
		}
		System.out.println(" Sommma elementi inseriti: "+somma);
	}

}
