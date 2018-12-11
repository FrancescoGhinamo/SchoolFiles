package es10;

public class Veicolo {

	protected String marca;
	protected int anno;
	protected int cilindrata;
	public Veicolo(String marca, int anno, int cilindrata) {
		super();
		this.marca = marca;
		this.anno = anno;
		this.cilindrata = cilindrata;
	}
	public String getMarca() {
		return marca;
	}
	public int getAnno() {
		return anno;
	}
	public int getCilindrata() {
		return cilindrata;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n Marca: "+marca;
		ris += "\n Anno: "+anno;
		ris += "\n Cillindrata: "+cilindrata;
		return ris;
	}
}
