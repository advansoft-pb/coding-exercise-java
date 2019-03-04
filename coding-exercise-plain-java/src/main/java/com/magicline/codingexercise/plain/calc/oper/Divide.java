package com.magicline.codingexercise.plain.calc.oper;

public class Divide extends Operator {

	private Divide() {
		super();
	}

	private static final Divide instance = new Divide();

	public static Operator getInstance() {
		return instance;
	}

	@Override
	public boolean mark(char c) {
		return '/' == c;
	}

	@Override
	public int calc(int a, int b) {
		return a / b;
	}

	@Override
	public int prior() {
		return 1;
	}
}
