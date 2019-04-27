package fraseThread;


public class FraseThread extends Thread {
	
	private String frase;
	
	private String consonanti;

	public FraseThread(String frase) {
		super();
		this.frase = frase.toLowerCase();
		consonanti = "qwrtypsdfghjklzxcvbnm";
	}
	
	
	public void run() {
		char[] characters = frase.toCharArray();
		for(char c: characters) {
			//se la char è contenuta nella stringa consonanti, contenente tutte le consonanti, è una consonante
			if(consonanti.indexOf(c) != -1) {
				System.out.println(c);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
