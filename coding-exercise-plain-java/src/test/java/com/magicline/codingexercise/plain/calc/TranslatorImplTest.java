package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class TranslatorImplTest {

	private final Translator translator = new TranslatorImpl();

	@Test
	void testTranslateNull() throws Exception {
		List<Element> result = translator.translate(null);
		assertNull(result);
	}

	@Test
	void testTranslateEmpty() throws Exception {
		List<Element> result = translator.translate(Collections.emptyList());
		assertEquals(0, result.size());
	}

	@Test
	void testTranslateNotEmpty() throws Exception {
		List<Element> input = new ArrayList<>();
		input.add(new Element("123"));
		input.add(new Element("+"));
		input.add(new Element("678"));
		input.add(new Element("*"));
		input.add(new Element("("));
		input.add(new Element("500"));
		input.add(new Element("/"));
		input.add(new Element("100"));
		input.add(new Element(")"));

		List<Element> result = translator.translate(input);

		assertEquals(7, result.size());
		assertEquals(123, result.get(0).getInt());
		assertEquals(678, result.get(1).getInt());
		assertEquals(500, result.get(2).getInt());
		assertTrue(result.get(3).getOper().mark('*'));
		assertEquals(100, result.get(4).getInt());
		assertTrue(result.get(5).getOper().mark('/'));
		assertTrue(result.get(6).getOper().mark('+'));
	}
}
