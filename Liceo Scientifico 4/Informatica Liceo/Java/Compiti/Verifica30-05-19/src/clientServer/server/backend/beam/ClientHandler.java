package clientServer.server.backend.beam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class ClientHandler extends Observable implements Runnable {
	
	private int id;
	private Socket conn;
	
	

	public ClientHandler(int id, Socket conn) {
		super();
		this.id = id;
		this.conn = conn;
		this.addObserver(ListaEventiAssicurazione.getInstance());
	}



	@Override
	public void run() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = reader.readLine();
			while(line != null) {
				setChanged();
				notifyObservers(line);
				line = reader.readLine();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}



	public int getId() {
		return id;
	}
	
	

}
