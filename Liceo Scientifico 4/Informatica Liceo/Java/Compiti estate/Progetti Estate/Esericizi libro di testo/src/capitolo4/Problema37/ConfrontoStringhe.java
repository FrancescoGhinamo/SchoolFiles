package capitolo4.Problema37;

public class ConfrontoStringhe {

	public static void main(String[] args) {
		String stringa1 = "aaa";
		String stringa2 = "aaa";
		System.out.println(" Test operatore ==");
		if(stringa1 == stringa2) {
			System.out.println("\tStirnghe identiche");
		}
		else {
			System.out.println("\tStringhe diverse");
		}
		
		System.out.println("\n Test metodo equals");
		if(stringa1.equals(stringa2)) {
			System.out.println("\tStirnghe identiche");
		}
		else {
			System.out.println("\tStringhe diverse");
		}

	}

}
