package capitolo3.Problema12;

public class CalcoliQuadrato {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.print(" Inserire la misura del lato di un quadrato: ");
		double lato = t.leggiDouble();
		System.out.println(" Area del quadrato: "+lato * lato);
		System.out.println(" Perimetro del quadrato: "+4 * lato);

	}

}
