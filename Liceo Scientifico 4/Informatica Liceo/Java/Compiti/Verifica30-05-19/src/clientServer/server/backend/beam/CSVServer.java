package clientServer.server.backend.beam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class CSVServer implements Runnable {
	
	private ServerSocket servSocket;
	private Observer forwarded;
	
	
	
	public CSVServer(int port) throws IOException {
		try {
			servSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw e;
		}
	}
	
	public CSVServer(int port, Observer forwarded) throws IOException {
		this(port);
		this.forwarded = forwarded;
	}

	@Override
	public void run() {
		if(servSocket != null) {
			int id = 0;
			while(true) {
				try {
					Socket _s = servSocket.accept();
					ClientHandler c = new ClientHandler(id, _s);
					if(forwarded != null) {
						c.addObserver(forwarded);
					}
					new Thread(c).start();
				} catch (IOException e) {
				
				}
				
				id++;
			}
			
		}
		
	}

}
