package capitolo3.Problema15;

public class TempiDocumentario {
	
	private static final int MIN_ANNO = 525600;
	private static final int MIN_ORA = 60;

	public static void main(String[] args) {
		int totMin = 5876;
		int anni = 5876 / MIN_ANNO;
		totMin -= anni * MIN_ANNO;
		int ore = totMin / MIN_ORA;
		int min = totMin - ore * MIN_ORA;
		System.out.println(anni+" anni "+ore+" ore "+min+" minuti ");
	}

}
