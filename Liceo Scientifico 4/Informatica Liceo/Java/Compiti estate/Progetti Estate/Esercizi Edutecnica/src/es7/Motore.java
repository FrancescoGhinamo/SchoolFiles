package es7;

public class Motore {
	
	private boolean acceso;
	
	public Motore() {
		this.acceso = false;
	}

	public void accendi() {
		acceso = true;
		System.out.println(" Motore acceso");
		
	}
	
	public void spegni() {
		acceso = false;
		System.out.println(" Motore spento");
	}

	public boolean isAcceso() {
		return acceso;
	}

	
}
