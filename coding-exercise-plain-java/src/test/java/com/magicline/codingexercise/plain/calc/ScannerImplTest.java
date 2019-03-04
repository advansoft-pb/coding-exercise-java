package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;

class ScannerImplTest {

	private final Scanner scanner = new ScannerImpl();

	@Test
	void testScanNull() {
		List<String> result = scanner.scan(null);
		assertNull(result);
	}

	@Test
	void testScanEmpty() {
		List<String> result = scanner.scan("");
		assertEquals(0, result.size());
	}

	@Test
	void testScanOneNumber() {
		List<String> result = scanner.scan("12904");
		assertEquals(1, result.size());
		assertEquals("12904", result.get(0));
	}

	@Test
	void testScanComplicated() {
		List<String> result = scanner.scan("12)904+-109((");

		assertEquals(8, result.size());
		assertEquals("12", result.get(0));
		assertEquals(")", result.get(1));
		assertEquals("904", result.get(2));
		assertEquals("+", result.get(3));
		assertEquals("-", result.get(4));
		assertEquals("109", result.get(5));
		assertEquals("(", result.get(6));
		assertEquals("(", result.get(7));
	}
}
