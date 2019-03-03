package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	private static final String INPUT_NUMBER = "23491";

	@Test
	void testCalculate() throws Exception {
		int result = Calculator.calculate(INPUT_NUMBER);
		assertEquals(INPUT_NUMBER, String.valueOf(result));
	}
}
