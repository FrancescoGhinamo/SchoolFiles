package es5;

public class T {

	private int ore;
	private int minuti;
	private int secondi;
	
	public T(int o, int m, int s) {
		if(valido(o, m, s)) {
			ore = o;
			minuti = m;
			secondi = s;			
		}
		else {
			ore = 0;
			minuti = 0;
			secondi = 0;
		}
	}
	
	public boolean valido(int o, int m, int s) {
		boolean valido = false;
		if(o >= 0 && o <= 24 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
			valido = true;
		}
		return valido;
	}
	
	public void setT(int o, int m, int s) {
		if(valido(o, m, s)) {
			ore = o;
			minuti = m;
			secondi = s;			
		}
		else {
			ore = 0;
			minuti = 0;
			secondi = 0;
		}
	}
	
	public T sommaOrari(T orario) {
		int sommaS = this.getSec() + orario.getSec();
		return getT(sommaS);
	}
	
	public T sottraiOrari(T orario) {
		int differenzaS = this.getSec() - orario.getSec();
		return getT(differenzaS);
	}
	
	public int getSec() {
		return ore * 3600 + minuti * 60 + secondi;
	}
	
	public static T getT(int sec) {
		int o = sec / 3600;
		int rest = sec - 3600 * o;
		int m = rest / 60;
		rest = rest - 60 * m;
		int s = rest;
		return new T(o, m, s);
	}
	
	public String toString() {
		return ore+" : "+minuti+" : "+secondi;
	}
	
	public static void main(String[] args) {
		T t = new T(12, 34, 45);
		T t2 = new T(2, 15, 42);
		T t3 = T.getT(t.getSec());
		System.out.println(" Orario t: "+t.toString());
		System.out.println(" Secondi t2: "+t2.getSec());
		System.out.println(" Calcolo di t: "+t3.toString());
		System.out.println(" Somma orari: "+t.sommaOrari(t2));
		System.out.println(" Differenza orari: "+t.sottraiOrari(t2));
		

	}

}
