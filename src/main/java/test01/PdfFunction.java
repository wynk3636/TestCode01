package test01;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfFunction {
	
	public static boolean CreatePdf() {
		try {
			PDDocument document = new PDDocument();
			
			PDPage page = new PDPage();
			document.addPage(page);
			
			document.save("sample.pdf");
			document.close();
			
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
