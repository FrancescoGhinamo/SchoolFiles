package es12;

public class Decespugliatore extends MacchinaAgricola {
	
	private boolean accensioneElettronica;

	public Decespugliatore(int numeroOrdine, String marca, float costoRiparazione, boolean accensioneElettronica) {
		super(numeroOrdine, marca, costoRiparazione);
		this.accensioneElettronica = accensioneElettronica;
	}

	
	
	public boolean isAccensioneElettronica() {
		return accensioneElettronica;
	}



	public String toString() {
		String info = "";
		info += "\n\tTAGLIAERBA";
		info += "\n Accensione elettronica: "+accensioneElettronica;
		info += super.toString();
		return info;
	}

}
