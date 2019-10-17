package test01;

import static org.junit.Assert.*;

import org.junit.Test;

public class PdfTest {

	@Test
	public void CreateTest() {
		boolean onCreatePdf = PdfFunction.CreatePdf();
		assertTrue(onCreatePdf);
	}

}
