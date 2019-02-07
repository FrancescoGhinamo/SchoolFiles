package prenotazioniLaboratorio.backend.bean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import prenotazioniLaboratorio.backend.service.FileServiceFactory;
import prenotazioniLaboratorio.backend.service.IFileService;

public class ElencoPrenotazioni extends ArrayList<PrenotazioneLaboratorio> {


	private static final long serialVersionUID = 2839220487963455623L;

	public boolean add(PrenotazioneLaboratorio p) {
		boolean ris = false;
		if(p != null) {
			ris = super.add(p);
		}
		else {
			throw new IllegalArgumentException();
		}
		return ris;
	}

	public void esportaCSV(File f) throws IOException {
		IFileService service = FileServiceFactory.getFileService();
		try {
			service.salva(this, f);
		} catch (IOException e) {
			throw e;
		}
	}

	public void importaCSV(File f) throws IOException {
		IFileService service = FileServiceFactory.getFileService();
		ElencoPrenotazioni _e;
		try {
			_e = service.carica(f);
			this.clear();
			this.addAll(_e);
		} catch (IOException e) {
			throw e;
		}
		
	}
	
	
	
}
