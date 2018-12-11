package scuola;

public class Materia {

	private static final int MAX_VOTI = 10;
	private String nome;
	private int[] voti;
	
	public Materia(String nome) {
		this.nome = nome;
		voti = new int[MAX_VOTI];
		for(int i = 0; i < voti.length; i++) {
			voti[i] = 0;
		}
		registraVoti();
	}
	
	private int primoIndiceLibero() {
		int i = 0;
		for(i = 0; (i < voti.length) && (voti[i] == 0); i++) {
			
		}
		if(i >= voti.length) {
			i = voti.length - 1;
		}
		
		return i;
	}
	
	public float calcolaMedia() {
		int somma = 0, num = 0;
		for(num = 0; num < primoIndiceLibero(); num++) {
			somma += voti[num];
		}
		return (float) somma / num;
	}
	
	public int creaVoto() {
		Tastiera t = new Tastiera();
		System.out.println("\n Registrazione voto "+primoIndiceLibero() + 1);
		System.out.print(" Inserire il voto: ");
		return t.leggiInt();
	}
	
	public void aggiungiVoto(int v) {
		voti[primoIndiceLibero()] = v;
	}
	
	public void registraVoti() {
		Tastiera t = new Tastiera();
		do {
			System.out.println("\n Inserire i dati di un voto");
			aggiungiVoto(creaVoto());
			System.out.print(" Continuare con l'inserimento? ");
		}
		while(t.leggiBoolean() == true);
		
		
	}

	public String getNome() {
		return nome;
	}

	public int[] getVoti() {
		return voti;
	}
	
	public String toString() {
		String ris = "\n\t"+nome.toUpperCase();
		ris += "\n Voti: ";
		for(int i = 0; i < primoIndiceLibero(); i++) {
			ris += voti[i]+"; ";
		}
		ris += "\n Media voti: "+calcolaMedia();
		return ris;
	}
}
