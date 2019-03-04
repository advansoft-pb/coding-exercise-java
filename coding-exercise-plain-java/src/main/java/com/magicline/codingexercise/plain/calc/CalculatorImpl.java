package com.magicline.codingexercise.plain.calc;

import java.util.List;

public class CalculatorImpl implements Calculator {

	private final Scanner scanner;
	private final Parser parser;
	private final Translator translator;
	private final Processor processor;

	public CalculatorImpl(Scanner scanner, Parser parser, Translator translator, Processor processor) {
		this.scanner = scanner;
		this.parser = parser;
		this.translator = translator;
		this.processor = processor;
	}

	@Override
	public int calculate(String exp) throws Exception {
		List<String> scanned = scanner.scan(exp);
		List<Element> list = parser.parse(scanned);
		List<Element> rpn = translator.translate(list);
		return processor.process(rpn);
	}
}
