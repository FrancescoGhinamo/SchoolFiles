package es12;

public class PostoRiparazione {

	private String descrizioneRiparazione;
	private float costoLavorazioni;
	private MacchinaAgricola macchina;
	
	
	public PostoRiparazione(String descrizioneRiparazione, float costoLavorazioni, MacchinaAgricola macchina) {
		super();
		this.descrizioneRiparazione = descrizioneRiparazione;
		this.costoLavorazioni = costoLavorazioni;
		this.macchina = macchina;
	}
	
	public MacchinaAgricola getMacchina() {
		return macchina;
	}
	public String getDescrizioneRiparazione() {
		return descrizioneRiparazione;
	}
	public float getCostoLavorazioni() {
		return costoLavorazioni;
	}
	
	public String toString() {
		String ris = "";
		ris += "\n\nPOSTO RIPARAZIONE";
		ris += "\n Descrizione riparazione:\n"+descrizioneRiparazione;
		ris += "\n Costo lavorazioni: "+costoLavorazioni;
		ris += "\n Informazioni macchina agricola:";
		ris += macchina.toString();
		return ris;
	}
	
}
