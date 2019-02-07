package interfaccia;

import java.util.ArrayList;

public interface IFileOperations {

	public void salvaMultipli(int num, String percorso);
	
	public void serializzaValori(ArrayList<Double> listaValori, String percorso);
	
	public ArrayList<Double> deserializzaValori(String percorso);
}
