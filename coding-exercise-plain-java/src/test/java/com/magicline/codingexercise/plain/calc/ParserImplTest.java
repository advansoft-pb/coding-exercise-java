package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class ParserImplTest {

	private final Parser parser = new ParserImpl();

	@Test
	void testParseNull() throws Exception {
		List<Element> result = parser.parse(null);
		assertNull(result);
	}

	@Test
	void testParseEmpty() throws Exception {
		List<Element> result = parser.parse(Collections.emptyList());
		assertEquals(0, result.size());
	}

	@Test
	void testParseNotEmpty() throws Exception {
		List<String> input = new ArrayList<>();
		input.add("(");
		input.add("1209");
		input.add("-");

		List<Element> result = parser.parse(input);

		assertEquals(3, result.size());
		assertEquals(Parenth.OPENING, result.get(0).getParenth());
		assertEquals(1209, result.get(1).getInt());
		assertTrue(result.get(2).getOper().mark('-'));
	}
}
