package capitolo3.Problema40;

public class Estrattore {
	
	private static final int MIN = 1;
	private static final int MAX = 20;
	
	public int estrai() {
		return (int) ((Math.random() * 1000) % MAX) + MIN;
	}
	
	public boolean vittoria() {
		boolean v = false;
		int val = estrai();
		System.out.print(val);
		if(val % 2 == 0) {
			v = true;
		}
		return v;
	}
 
	public static void main(String[] args) {
		Estrattore es = new Estrattore();
		System.out.println(": Vittoria all'estrazione: "+es.vittoria());

	}

}
