package capitolo4.Problema31;

public class Dipendente extends Anagrafica {
	
	protected float stipendio;
	protected int livello;
	
	public void impostaStipendio(float stipendio) {
		if(stipendio <= 0) {
			this.stipendio = 1;
		}
		else {
			this.stipendio = stipendio;
		}
	}
	
	public void impostaLivello(int livello) {
		if(livello < 1) {
			livello = 1;
		}
		else if(livello > 7) {
			livello = 7;
		}
		else {
			this.livello = livello;
		}
	}
	
	public void incrementaLivello(int scatti) {
		for(int c = 0; c < scatti && livello < 7; c++) {
			livello++;
			stipendio += stipendio / 10;
		}
		
	}

	public static void main(String[] args) {
		Dipendente d = new Dipendente();
		d.impostaLivello(1);
		d.impostaStipendio(1000);
		d.incrementaLivello(3);
		System.out.println(" Nuovo stipendio: "+d.stipendio);

	}

}
