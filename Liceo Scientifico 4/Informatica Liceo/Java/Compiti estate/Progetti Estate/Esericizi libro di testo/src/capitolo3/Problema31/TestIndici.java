package capitolo3.Problema31;

public class TestIndici {

	public static void main(String[] args) {
		int[] vet = new int[10];
		try {
			int c = vet[20];
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}

	}

}
