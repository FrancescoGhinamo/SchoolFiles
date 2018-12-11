package capitolo3.Problema26;

public class Array {

	public static void main(String[] args) {
		System.out.println("double array");
		double[] doubleArray = new double[12];
		for(int i = 0; i < doubleArray.length; i++) {
			doubleArray[i] = Math.random() * 10;
		}
		
		for(int i = 0; i < doubleArray.length; i++) {
			System.out.println(doubleArray[i]);
		}
		

	}

}
