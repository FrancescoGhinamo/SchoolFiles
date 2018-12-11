package capitolo4.Problema38;

public class NomiPersona {
	
	private String[] elencoNomi;
	
	public NomiPersona() {
		Tastiera t = new Tastiera();
		elencoNomi = new String[5];
		System.out.println(" Inserire 5 nomi di persona:");
		for(int i = 0; i < elencoNomi.length; i++) {
			System.out.print(" Inserire il nome della persona "+(i + 1)+": ");
			elencoNomi[i] = t.leggiString();
		}
	}
	
	public int contaEStampaInizialeVocale() {
		int conta = 0;
		for(int i = 0; i < elencoNomi.length; i++) {
			String iniziale = elencoNomi[i].substring(0, 1).toLowerCase();
			if((iniziale.equals("a")) || (iniziale.equals("e")) || (iniziale.equals("i")) || (iniziale.equals("o")) || (iniziale.equals("u"))) {
				conta++;
				System.out.println(" Trovato: "+elencoNomi[i]);
			}
		}
		return conta;
	}
	
	public static void main(String[] args) {
		NomiPersona nomi = new NomiPersona();
		int voc = nomi.contaEStampaInizialeVocale();
		System.out.println(" Nomi con vocale iniziale: "+voc);

	}

}
