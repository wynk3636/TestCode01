package test01;

import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfFunction {
	
	private final String createPdfName = "sample.pdf";
	private final String readPdfName = "kameiten_touroku_list.pdf";
	
	public boolean createPdf() {
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
			content.showText("World");
			content.endText();
			content.close();
			
			document.save(createPdfName);
			document.close();
			
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("finally")
	public List<String> readPdf() {
		
		List<StoreInfo> storeInfoList = new ArrayList<StoreInfo>();
		List<String> cityList = new ArrayList<String>();
		
		try {
			PDDocument document = PDDocument.load(new FileInputStream(readPdfName));
			System.out.println(document.getNumberOfPages() + "page");

			int getPage =207;
			
			/*
			PDFTextStripper strip = new PDFTextStripper();
			strip.setStartPage(getPage);
			strip.setEndPage(getPage);
			String context = strip.getText(document);
			System.out.println(context);
			*/
			double x = 37.0;
	        double y = 115.05;
	        double w = 513.58;
	        double h = 671.47;
	        Rectangle2D area = new Rectangle2D.Double(x,y,w,h);
	        
	        PDFTextStripperByArea strip = new PDFTextStripperByArea();
	        strip.addRegion("list",area);
	        strip.extractRegions(document.getPage(getPage - 1));
			String context = strip.getTextForRegion("list");
			
			for(String line : context.split("¥n")) {
				String[] words = line.split(" ");
				
				StoreInfo storeinfo = new StoreInfo(words[0],words[1],words[2],words[3],words[4],words[5]);
				storeInfoList.add(storeinfo);
				cityList.add(words[2]);
			}
			//System.out.println(context);
			
			storeInfoList.stream()
					.filter(k -> k.isCity("仙台市泉区"))
					.forEach(System.out::println);
			
		} 
		catch (InvalidPasswordException e) {
			e.printStackTrace();
			//return "Password error";
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			//return "file not found error";
		} 
		catch (IOException e) {
			e.printStackTrace();
			//return "IO error";
		}
		finally {
			return cityList;
		}
	}
}
