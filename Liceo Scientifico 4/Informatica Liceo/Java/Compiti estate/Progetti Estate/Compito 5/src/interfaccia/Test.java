package interfaccia;

public class Test implements IOperazioniVettore {

	
	
	public static void main(String[] args) {
		Test t = new Test();
		int [] myVet = t.generaNumeriCasuali();
		System.out.println(" Vettore generato:");
		for(int i = 0; i < myVet.length; i++) {
			System.out.print(" "+myVet[i]);
		}
		t.somma(myVet, 5);
		System.out.println(" Nuovi valori:");
		for(int i = 0; i < myVet.length; i++) {
			System.out.print(" "+myVet[i]);
		}
	}

	@Override
	public int[] generaNumeriCasuali() {
		int[] vet = new int[100];
		for(int i = 0; i < vet.length; i++) {
			vet[i] = (int) (Math.random() * 1000);
		}
		return vet;
	}

	@Override
	public void somma(int[] vet, int num) {
		for(int i = 0; i < vet.length; i++) {
			vet[i] += num;
		}
		
	}

}
