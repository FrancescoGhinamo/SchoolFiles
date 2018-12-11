package numeroRazionale;

public class GestioneNumeri {

	public static void main(String[] args) {
		NumeroRazionale num = new NumeroRazionale(3, 5);
		System.out.print(" Numero inserito: ");
		num.visualizzaNumero();
		System.out.println(" Valore della frazione: "+num.calcolaFrazione());
		System.out.println(" Numero intero: "+num.numeroIntero());

	}

}
