package capitolo3.Problema38;

public class InserimentoNumeri {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		int cPos = 0;
		int cNeg = 0;
		System.out.println(" Inserire una sequenza di numeri, 0 per terminare");
		int val;
		do {
			val = t.leggiInt();
			if(val != 0) {
				if(val > 0) {
					cPos++;
				}
				else {
					cNeg++;
				}
			}
		}
		while(val != 0);
		System.out.println(" Numeri positivi inseriti: "+cPos);
		System.out.println(" Numeri negativi inseriti: "+cNeg);

	}

}
