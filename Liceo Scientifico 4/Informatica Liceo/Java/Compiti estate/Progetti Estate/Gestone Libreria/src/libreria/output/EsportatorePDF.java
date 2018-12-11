package libreria.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class EsportatorePDF {
	
	public static final String FILE = "H:\\File Liceo\\Backup\\Liceo Scientifico 4\\Informatica Liceo\\Java\\Compiti estate\\Progetti Estate\\Gestone Libreria\\Libreria.pdf";
	
	private Object obj;

	public EsportatorePDF(Object obj) {
		super();
		this.obj = obj;
	}
	
	public void esportaPDF() throws FileNotFoundException, DocumentException {
		// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(FILE));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("\tLIBRERIA JAVA"));
        document.add(new Paragraph(obj.toString()));
        // step 5
        document.close();
	}

}
