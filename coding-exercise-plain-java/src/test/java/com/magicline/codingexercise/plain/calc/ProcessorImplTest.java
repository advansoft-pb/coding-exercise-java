package com.magicline.codingexercise.plain.calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class ProcessorImplTest {

	private final Processor processor = new ProcessorImpl();

	@Test
	void testProcessNull() {
		assertThrows(NullPointerException.class, () -> processor.process(null));
	}

	@Test
	void testProcessEmpty() throws Exception {
		assertThrows(NoSuchElementException.class, () -> processor.process(Collections.emptyList()));
	}

	@Test
	void testProcessNotEmpty() throws Exception {
		List<Element> input = new ArrayList<>();
		input.add(new Element("23"));
		input.add(new Element("67"));
		input.add(new Element("+"));
		input.add(new Element("500"));
		input.add(new Element("*"));

		int result = processor.process(input);

		assertEquals(45000, result);
	}
}
