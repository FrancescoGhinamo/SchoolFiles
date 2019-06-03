package clientServer.client.backend.beam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Creata come thread per rendere resposiva l'interfaccia grafica anche durante l'invio di un file
 * @author franc
 *
 */
public class CSVCommunicator extends Thread {

	private Socket conn;

	private File csvFile;

	public CSVCommunicator(String hostName, int port, File csvFile) throws IOException {
		try {
			InetAddress addr = InetAddress.getByName(hostName);
			conn = new Socket(addr, port);

		} catch (IOException e) {
			throw e;
		}
		this.csvFile = csvFile;
	}


	public void run() {
		if(conn != null) {
			sendFileLineByLine();
		}
	}

	public void sendFileLineByLine() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(csvFile));
			writer = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));

			//legge e invia le righe del file una per volta, all'invio di stringa vuoto considero la file del file
			String line = reader.readLine();
			while(line != null) {
				writer.println(line);
				line = reader.readLine();
			}
			
			
			writer.flush();
				
			
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			try {
				conn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}