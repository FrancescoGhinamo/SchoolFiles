package capitolo4.Problema31;


public class DipendenteSpecializzato extends Dipendente {
	
	public void incrementaLivello(int scatti) {
		for(int c = 0; c < scatti && livello < 7; c++) {
			livello++;
			float bonus = 0;
			if(livello >= 5) {
				bonus = 1000;
			}
			stipendio += stipendio / 10 + bonus;
		}
	}

	public static void main(String[] args) {
		DipendenteSpecializzato d = new DipendenteSpecializzato();
		d.impostaLivello(1);
		d.impostaStipendio(1000);
		d.incrementaLivello(4);
		System.out.println(" Nuovo stipendio: "+d.stipendio);

	}

}
