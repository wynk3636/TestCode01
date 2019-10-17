package test01;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfFunction {
	
	public static boolean CreatePdf() {
		try {
			PDDocument document = new PDDocument();
			
			PDPage page = new PDPage();
			document.addPage(page);
			
			PDFont font = PDType1Font.HELVETICA_BOLD;
			
			PDPageContentStream content = new PDPageContentStream(document,page);
			content.beginText();
			content.setFont(font, 12);
			content.newLineAtOffset(0f,0f);
			content.showText("Hello");
			content.endText();
			content.close();
			
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
