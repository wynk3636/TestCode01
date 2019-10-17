package test01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		int actual = Calculator.add(1,2);
		assertThat(actual, is(3));
	}
}
