package capitolo4.Problema17;

public class Orologio {
	
	private int ore;
	private int minuti;
	
	public Orologio()  {
		this.ore = 0;
		this.minuti = 0;
	}
	
	public Orologio(int ore) {
		this.ore = ore;
		this.minuti = 0;
	}
	
	public Orologio(int ore, int minuti) {
		this.ore = ore;
		this.minuti = minuti;
	}
	
	

	public static void main(String[] args) {
		Orologio o1 = new Orologio();
		Orologio o2 = new Orologio(4);
		Orologio o3 = new Orologio(3, 4);

	}

}
