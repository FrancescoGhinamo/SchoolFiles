package capitolo4.Problema22;

public class SupportoMemorizzazione {
	
	private float capacitaMB;
	private float prezzo;
	
	public SupportoMemorizzazione(float capacitaMB, float prezzo) {
		this.capacitaMB = capacitaMB;
		this.prezzo = prezzo;
	}
	
	public float calcPrezzoAlMB() {
		return prezzo / capacitaMB;
	}
	
	public String toString() {
		String ris = "";
		ris += " Supporto di memorizzazione:\n";
		ris += " Capacita' [MB]: "+capacitaMB+"\n";
		ris += " Prezzo [€]: "+prezzo;
		return ris;
	}

}
