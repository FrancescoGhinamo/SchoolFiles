package clientServer.server.backend.beam;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

@SuppressWarnings("deprecation")
public class ListaEventiAssicurazione extends Vector<EventoAssicurazione> implements Observer {


	private static final long serialVersionUID = -8128410870827826654L;

	private static ListaEventiAssicurazione me;

	public static  ListaEventiAssicurazione getInstance() {
		if(me == null) {
			me = new ListaEventiAssicurazione();
		}
		return me;
	}

	private ListaEventiAssicurazione() {

	}
	
	public boolean add(EventoAssicurazione e) {
		boolean ris = false;
		if(e != null) {
			ris = super.add(e);
		}
		return ris;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof ClientHandler) {
			String line = (String) arg;
			EventoAssicurazione _e = new EventoAssicurazione(line);
			this.add(_e);
		}

	}

	

}
