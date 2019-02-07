package prenotazioniLaboratorio.backend.service;

import java.io.File;
import java.io.IOException;

import prenotazioniLaboratorio.backend.bean.ElencoPrenotazioni;

public interface IFileService {

	public void salva(ElencoPrenotazioni el, File f) throws IOException;
	
	public ElencoPrenotazioni carica(File f) throws IOException;
}
