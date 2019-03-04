package com.magicline.codingexercise.plain;

import com.magicline.codingexercise.plain.calc.Calculator;
import com.magicline.codingexercise.plain.calc.CalculatorImpl;
import com.magicline.codingexercise.plain.calc.ParserImpl;
import com.magicline.codingexercise.plain.calc.ProcessorImpl;
import com.magicline.codingexercise.plain.calc.ScannerImpl;
import com.magicline.codingexercise.plain.calc.TranslatorImpl;

public class PlainJavaApp {

	public static void main(String... args) {
		try {
			if (args.length < 1) {
				throw new Exception("There should be at least one argument");
			}

			Calculator calculator = new CalculatorImpl(new ScannerImpl(), new ParserImpl(), new TranslatorImpl(),
					new ProcessorImpl());

			int result = calculator.calculate(args[0]);

			System.out.println(result);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
