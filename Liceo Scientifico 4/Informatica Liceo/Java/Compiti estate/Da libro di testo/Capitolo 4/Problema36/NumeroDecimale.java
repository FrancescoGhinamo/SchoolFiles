package capitolo4.Problema36;

public class NumeroDecimale {
	
	public static float arrotonda(float num, int cifreDecimali) {
		//isolamento parte intera
		int parteIntera = (int) num;
		//isolamento parte decimale
		float parteDecimale = num - parteIntera;
		//calcolo della parte decimale di interesse
		float isolamentoParteDecimaleInteresse = (float) (parteDecimale * Math.pow(10, cifreDecimali));
		int parteDecimaleInteresse = (int) isolamentoParteDecimaleInteresse;
		if(isolamentoParteDecimaleInteresse - parteDecimaleInteresse >= 0.5) {
			parteDecimaleInteresse++;
		}
		//parte decimale finale
		float parteDecimaleFinale = (float) (parteDecimaleInteresse / Math.pow(10, cifreDecimali));
		//composizione del numero
		return parteIntera + parteDecimaleFinale;
	}

	public static void main(String[] args) {
		System.out.println(" Arrotondamento: "+NumeroDecimale.arrotonda(5.6797f, 3));
		System.out.println(" Arrotondamento: "+NumeroDecimale.arrotonda(6.285823f, 4));

	}

}
