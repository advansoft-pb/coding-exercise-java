package com.magicline.codingexercise.plain.calc.oper;

public class Minus extends Operator {

	private Minus() {
		super();
	}

	private static final Minus instance = new Minus();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(char c) {
		return '-' == c;
	}

	@Override
	public int calc(int a, int b) {
		return a - b;
	}
}
