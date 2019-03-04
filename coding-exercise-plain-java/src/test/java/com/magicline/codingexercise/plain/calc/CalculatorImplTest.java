package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorImplTest {

	private final Calculator calculator = new CalculatorImpl(new ScannerImpl(), new ParserImpl(), new TranslatorImpl(),
			new ProcessorImpl());

	@Test
	void testCalculateSingleNumber() throws Exception {
		int result = calculator.calculate("23491");
		assertEquals(23491, result);
	}

	@Test
	void testCalculateExpression() throws Exception {
		int result = calculator.calculate("2+3");
		assertEquals(5, result);
	}

	@Test
	void testCalculateExpressionInParentheses() throws Exception {
		int result = calculator.calculate("(2+3)");
		assertEquals(5, result);
	}

	@Test
	void testCalculateExpressionComplicated() throws Exception {
		int result = calculator.calculate("(2+3)*(4+(5*6))");
		assertEquals(44, result);
	}
}
