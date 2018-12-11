package capeggio;

public class Campeggio {

	private String nome;
	private String indirizzo;
	private float latitudine;
	private float longitudine;
	
	
	
	public Campeggio(String nome, String indirizzo, float latitudine, float longitudine) {
		super();
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	public double distanzaDaPunto(double latB, double lonB) {
		final double R = 6371; 
		final double pigreco = 3.1415927; 
		double lat_alfa, lat_beta; 
		double lon_alfa, lon_beta; 
		double fi; double p, d;  
		lat_alfa = pigreco * getLatitudine() / 180; lat_beta = pigreco * latB / 180; 
		lon_alfa = pigreco * getLatitudine() / 180; lon_beta = pigreco * lonB / 180; 
		fi = Math.abs(lon_alfa - lon_beta); 
		p = Math.acos(Math.sin(lat_beta) * Math.sin(lat_alfa) + Math.cos(lat_beta) * Math.cos(lat_alfa) * Math.cos(fi));
		d = p * R;
		return(d);
    } 

	public String getNome() {
		return nome;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public float getLatitudine() {
		return latitudine;
	}
	public float getLongitudine() {
		return longitudine;
	}
	
	
	public String toString() {
		String ris = "\n\tCampeggio: "+nome;
		ris += "\n Indirizzo: "+indirizzo;
		ris += "\n Latituidine: "+latitudine;
		ris += "\n Longitudine: "+longitudine;
		return ris;
	}
	
}
