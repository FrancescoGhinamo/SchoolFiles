package numeroRazionale;

public class NumeroRazionale {
	
	private int numeratore;
	private int denominatore;
	public NumeroRazionale(int numeratore, int denominatore) {
		super();
		this.numeratore = numeratore;
		this.denominatore = denominatore;
	}
	
	public void visualizzaNumero() {
		System.out.println(+numeratore+" / "+denominatore);
	}
	
	public float calcolaFrazione() {
		return (float) (numeratore) / (float) (denominatore);
	}
	
	public boolean numeroIntero() {
		boolean inte = false;
		if(numeratore % denominatore == 0) {
			inte = true;
		}
		return inte;
	}
	
	public int getNumeratore() {
		return numeratore;
	}
	public int getDenominatore() {
		return denominatore;
	}
	
	

}
