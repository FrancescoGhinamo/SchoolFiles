package prenotazioniLaboratorio.backend.service;

public class FileServiceFactory {

	public static IFileService getFileService() {
		return (IFileService)new FileServiceImpl();
	}
}
