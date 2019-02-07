package singleton;

import java.util.Hashtable;

/**
 * Hashtable utilizzata per ottimizzare la funzione di ricerca di presenza di un URL
 * dato che non sono richieste funioni specifiche di un Array
 * @author franc
 *
 */
public class BlackListWebSite extends Hashtable<String, String> {

	
	private static final long serialVersionUID = -7165135693682461062L;
	
	private static BlackListWebSite me;
	
	private BlackListWebSite() {
		
	}
	
	public static BlackListWebSite getInstance() {
		if(me == null) {
			me = new BlackListWebSite();
		}
		return me;
	}
	
	
	public void addWebSite(String url) {
		if(url != null) {
			/*
			 * aggiungo alla hastable l'url, passando l'url stesso come chiave:
			 */
			this.put(url, url);
		}
	}
	
	public boolean isWebSiteBlocked(String url) {
		/*
		 * se la chiave è presente, l'url e' bloccato
		 */
		return this.containsKey(url);
	}

	
}
