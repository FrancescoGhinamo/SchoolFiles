package capitolo3.Problema28;

public class NumeriCasuali {

	public static void main(String[] args) {
		int[] vals = new int[5];
		for(int i = 0; i < vals.length; i++) {
			vals[i] = (int) (((Math.random() * 1000) % 90) + 1);
		}
		
		System.out.println(" Numeri generati: ");
		for(int i = 0; i < vals.length; i++) {
			System.out.print(vals[i]+" ");
		}

	}

}
