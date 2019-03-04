package com.magicline.codingexercise.plain.calc.oper;

public class Multiply extends Operator {

	private Multiply() {
		super();
	}

	private static final Multiply instance = new Multiply();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(char c) {
		return '*' == c;
	}

	@Override
	public int calc(int a, int b) {
		return a * b;
	}
}
