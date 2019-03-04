package com.magicline.codingexercise.plain.calc;

import com.magicline.codingexercise.plain.calc.oper.Divide;
import com.magicline.codingexercise.plain.calc.oper.Minus;
import com.magicline.codingexercise.plain.calc.oper.Multiply;
import com.magicline.codingexercise.plain.calc.oper.Operator;
import com.magicline.codingexercise.plain.calc.oper.Plus;

public class Element {

	static {
		Plus.getInstance();
		Minus.getInstance();
		Multiply.getInstance();
		Divide.getInstance();
	}

	private final String value;

	public Element(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public Operator getOper() {
		for (Operator op : Operator.values()) {
			if (op.mark(value.charAt(0))) {
				return op;
			}
		}

		return null;
	}

	public boolean isInt() {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int getInt() {
		return Integer.parseInt(value);
	}

	public Parenth getParenth() {
		if ("(".equals(value)) {
			return Parenth.OPENING;
		}

		if (")".equals(value)) {
			return Parenth.CLOSING;
		}

		return null;
	}

	@Override
	public String toString() {
		return value;
	}
}
