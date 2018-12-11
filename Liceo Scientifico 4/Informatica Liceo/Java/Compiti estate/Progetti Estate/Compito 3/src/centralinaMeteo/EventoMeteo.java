package centralinaMeteo;

public class EventoMeteo {
	
	private int idEvento;
	private float valore;
	private TipoEvento tipo;
	
	public EventoMeteo(int idEvento, float valore, TipoEvento tipo) {
		super();
		this.idEvento = idEvento;
		this.valore = valore;
		this.tipo = tipo;
	}
	
	
	
	public int getIdEvento() {
		return idEvento;
	}
	public float getValore() {
		return valore;
	}
	public TipoEvento getTipo() {
		return tipo;
	}

	public String toString() {
		String ris = "\n\tEVETO METEO";
		ris += "\n ID evento: "+idEvento;
		ris += "\n Valore: "+valore;
		ris += "\n Tipo di evento: "+tipo;
		return ris;
	}
	
}
