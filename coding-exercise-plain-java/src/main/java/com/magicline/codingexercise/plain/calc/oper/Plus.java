package com.magicline.codingexercise.plain.calc.oper;

public class Plus extends Operator {

	private Plus() {
		super();
	}

	private static final Plus instance = new Plus();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(char c) {
		return '+' == c;
	}

	@Override
	public int calc(int a, int b) {
		return a + b;
	}

	@Override
	public int prior() {
		return 0;
	}
}
