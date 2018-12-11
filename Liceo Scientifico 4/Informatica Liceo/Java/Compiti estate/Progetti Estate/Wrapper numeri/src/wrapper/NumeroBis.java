package wrapper;

public class NumeroBis {
	
	private double valore;

	public NumeroBis(double valore) {
		super();
		this.valore = valore;
	}
	
	
	public double radiceQuadrata() {
		return Math.sqrt(valore);
	}
	
	public double valoreAssoluto() {
		return Math.abs(valore);
	}

	public double getValore() {
		return valore;
	}
	
	

}
