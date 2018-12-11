package es2;

public class Movimento {
	
	private TipoMovimento tipo;
	private float importo;
	
	public Movimento(TipoMovimento tipo, float importo) {
		super();
		this.tipo = tipo;
		this.importo = importo;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public float getImporto() {
		return importo;
	}

	public void setImporto(float importo) {
		this.importo = importo;
	}
	
	
	public String toString() {
		String ris = "";
		ris += " Movimento\n";
		ris += " Tipo: "+tipo+"\n";
		ris += " Importo: "+importo;
		
		return ris;
	}

}
