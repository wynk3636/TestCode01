package test01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PdfTest {

	@Test
	public void CreateTest() {
		PdfFunction pdf =  new PdfFunction();
		
		boolean onCreatePdf = pdf.CreatePdf();
		assertTrue(onCreatePdf);
	}

}
