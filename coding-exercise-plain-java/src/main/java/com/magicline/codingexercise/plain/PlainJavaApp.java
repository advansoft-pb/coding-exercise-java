package com.magicline.codingexercise.plain;

import com.magicline.codingexercise.plain.calc.Calculator;

public class PlainJavaApp {

	public static void main(String... args) {
		try {
			if (args.length < 1) {
				throw new Exception("There should be at least one argument");
			}

			int result = Calculator.calculate(args[0]);

			System.out.println(result);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
