package test01;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class PdfTest extends PdfFunction {

	@Test
	public void createTest() {
		boolean onCreatePdf = createPdf();
		assertTrue(onCreatePdf);
	}
	@Test
	public void readTest() {
		List<String> messageList = readPdf();
		
		for(String message : messageList) {
			assertThat(message,is(containsString("仙台")));
		}
		
	}
}
