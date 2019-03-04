package com.magicline.codingexercise.plain.calc.oper;

import java.util.HashSet;
import java.util.Set;

public abstract class Operator {

	public static Operator getInstance() {
		return null;
	}

	private static final Set<Operator> subclasses = new HashSet<>();

	protected Operator() {
		subclasses.add(this);
	}

	public static Set<Operator> values() {
		return subclasses;
	}

	public abstract boolean mark(char c);

	public abstract int calc(int a, int b);

	public abstract int prior();
}
