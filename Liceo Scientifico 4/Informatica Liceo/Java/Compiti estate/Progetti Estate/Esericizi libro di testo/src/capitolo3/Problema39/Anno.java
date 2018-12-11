package capitolo3.Problema39;

public class Anno {
	
	private int anno;
	
	

	public Anno(int anno) {
		super();
		this.anno = anno;
	}

	public boolean isBisestile() {
		boolean bis = false;
		if(((anno % 4 == 0) && (anno % 100 != 0)) || (anno % 400 == 0)) {
			bis = true;
		}
		return bis;
	}


	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		System.out.println(" Inserire un anno: ");
		Anno a = new Anno(t.leggiInt());
		System.out.println(" Anno bisestile: "+a.isBisestile());

	}

}
