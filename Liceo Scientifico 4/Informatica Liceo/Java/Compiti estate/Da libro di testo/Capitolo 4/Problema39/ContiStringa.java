package capitolo4.Problema39;

public class ContiStringa {
	
	private String stringa;
	
	
	
	public ContiStringa(String stringa) {
		super();
		this.stringa = stringa;
	}

	public int contaNumeri() {
		int conta = 0;
		for(int i = 0; i < stringa.length(); i++) {
			if((stringa.charAt(i) == '1') || (stringa.charAt(i) == '2') || (stringa.charAt(i) == '3') || (stringa.charAt(i) == '4') || (stringa.charAt(i) == '5') || (stringa.charAt(i) == '6') || (stringa.charAt(i) == '7') || (stringa.charAt(i) == '8') || (stringa.charAt(i) == '9') || (stringa.charAt(i) == '0')) {
				conta++;
			}
		}
		return conta;
	}
	
	public int contaCaratteri() {
		return stringa.length() - contaNumeri();
	}

	public static void main(String[] args) {
		ContiStringa conti = new ContiStringa("Nel 2017 io e la mia famiglia siamo stati in Canada");
		System.out.println(" Conteggio numeri: "+conti.contaNumeri());
		System.out.println(" Conteggio caratteri: "+conti.contaCaratteri());

	}

}
