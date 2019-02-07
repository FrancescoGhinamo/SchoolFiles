package prenotazioniLaboratorio.backend.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class PrenotazioneLaboratorio {
	
	private static final String CSV_SEPARATOR = ";";

	private String classe;
	private String nomeDocente;
	private GregorianCalendar data;
	private int durataMin;
	
	
	
	public PrenotazioneLaboratorio(String classe, String nomeDocente, GregorianCalendar data, int durataMin) {
		super();
		this.classe = classe;
		this.nomeDocente = nomeDocente;
		this.data = data;
		this.durataMin = durataMin;
	}
	
	public PrenotazioneLaboratorio(String daCSV) {
		String[] campi = daCSV.split(CSV_SEPARATOR);
		this.classe = campi[0];
		this.nomeDocente = campi[1];
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		GregorianCalendar d = new GregorianCalendar();
		try {
			d.setTime(fmt.parse(campi[2]));
		} catch (ParseException e) {
		}
		this.data = d;
		this.durataMin = Integer.parseInt(campi[3]);
		
	}
	
	public String toCSVString() {
		StringBuffer sB = new StringBuffer();
		sB.append(classe);
		sB.append(CSV_SEPARATOR);
		sB.append(nomeDocente);
		sB.append(CSV_SEPARATOR);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		sB.append(fmt.format(data.getTime()));
		sB.append(CSV_SEPARATOR);
		sB.append(String.valueOf(durataMin));
		sB.append(CSV_SEPARATOR);
		
		
		return sB.toString();
	}
	
	
	public String getClasse() {
		return classe;
	}
	public String getNomeDocente() {
		return nomeDocente;
	}
	public GregorianCalendar getData() {
		return data;
	}
	public int getDurataMin() {
		return durataMin;
	}
	
	
}
