package tassonomia;

import regnoVegetale.*;
import tassonomia.input.Tastiera;

public class RicercaInformazioni {

	public static void main(String[] args) {
		Tastiera t = new Tastiera();
		int scelta = 0;
		do {
			System.out.println("\n\tTASSONOMIA VEGETALE");
			System.out.println(" 1 - Alberi forestali");
			System.out.println(" 2 - Alghe");
			System.out.println(" 3 - Composte");
			System.out.println(" 4 - Crucifere");
			System.out.println(" 5 - Felci");
			System.out.println(" 6 - Graminacee");
			System.out.println(" 7 - Leguminose");
			System.out.println(" 8 - Liliacee");
			System.out.println(" 9 - Muschi");
			System.out.println("10 - Ombrellifere");
			System.out.println("11 - Rosacee");
			System.out.println("12 - Solanacee");
			System.out.println(" 0 - =======> Uscita");
			System.out.print(" Inserire il tipo di pianta di cui ottenere alcune inforrmazioni: ");
			scelta = t.leggiInt();
			Pianta pianta = null;
			switch(scelta) {
			case 0:
				System.out.println(" Uscita");
				break;
				
			case 1:
				pianta = new AlberiForestali();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 2:
				pianta = new Alga();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 3:
				pianta = new Composte();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
			
			case 4:
				pianta = new Crucifere();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 5:
				pianta = new Felce();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 6:
				pianta = new Graminacee();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 7:
				pianta = new Leguminose();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 8:
				pianta = new Liliacee();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 9:
				pianta = new Muschio();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 10:
				pianta = new Ombrellifere();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 11:
				pianta = new Rosacee();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
				
			case 12:
				pianta = new Solanacee();
				System.out.println(" Informzioni:");
				System.out.println(pianta.toString());
				break;
			
				
				
			default:
				System.out.println(" Opzione non riconosciuta");
			}
			
		}
		while(scelta != 0);

	}

}
