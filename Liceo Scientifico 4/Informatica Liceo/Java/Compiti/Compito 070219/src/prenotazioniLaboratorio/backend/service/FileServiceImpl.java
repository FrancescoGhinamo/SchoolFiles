package prenotazioniLaboratorio.backend.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import prenotazioniLaboratorio.backend.bean.ElencoPrenotazioni;
import prenotazioniLaboratorio.backend.bean.PrenotazioneLaboratorio;

public class FileServiceImpl implements IFileService {

	FileServiceImpl() {
		
	}
	
	@Override
	public void salva(ElencoPrenotazioni el, File f) throws IOException {
		FileWriter fW = null;
		try {
			fW = new FileWriter(f);
			for(PrenotazioneLaboratorio p: el) {
				fW.write(p.toCSVString());
				fW.write("\r\n");
			}
		} catch (IOException e) {
			throw e;
		}
		finally {
			if(fW != null) {
				try {
					fW.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						fW.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	@Override
	public ElencoPrenotazioni carica(File f) throws IOException {
		BufferedReader buffR= null;
		ElencoPrenotazioni ris = new ElencoPrenotazioni();
		try {
			buffR = new BufferedReader(new FileReader(f));

			
			String line = buffR.readLine();
			while(line != null) {
				ris.add(new PrenotazioneLaboratorio(line));
				line = buffR.readLine();
			}				

		} catch (IOException e) {
			throw e;
		}
		finally {
			if(buffR != null) {

				try {
					buffR.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return ris;

	}

}
