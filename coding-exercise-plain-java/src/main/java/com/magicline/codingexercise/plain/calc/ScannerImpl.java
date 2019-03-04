package com.magicline.codingexercise.plain.calc;

import java.util.ArrayList;
import java.util.List;

import com.magicline.codingexercise.plain.calc.oper.Divide;
import com.magicline.codingexercise.plain.calc.oper.Minus;
import com.magicline.codingexercise.plain.calc.oper.Multiply;
import com.magicline.codingexercise.plain.calc.oper.Operator;
import com.magicline.codingexercise.plain.calc.oper.Plus;

public class ScannerImpl implements Scanner {

	static {
		Plus.getInstance();
		Minus.getInstance();
		Multiply.getInstance();
		Divide.getInstance();
	}

	@Override
	public List<String> scan(String exp) {

		if (exp == null) {
			return null;
		}

		final List<String> result = new ArrayList<>();
		boolean readingNumber = false;
		StringBuilder sb = null;

		for (int index = 0; index < exp.length(); index++) {
			char ch = exp.charAt(index);

			if (isDigit(ch)) {

				if (!readingNumber) {
					readingNumber = true;
					sb = new StringBuilder();
				}

				sb.append(ch);

			} else {

				if (readingNumber) {
					readingNumber = false;
					result.add(sb.toString());
					sb = null;
				}

				if (isOper(ch) || isParenth(ch)) {
					result.add(String.valueOf(ch));
				}
			}
		}

		if (readingNumber) {
			readingNumber = false;
			result.add(sb.toString());
			sb = null;
		}

		return result;
	}

	private static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	private static boolean isOper(char ch) {
		for (Operator op : Operator.values()) {
			if (op.mark(ch)) {
				return true;
			}
		}

		return false;
	}

	private static boolean isParenth(char ch) {
		return ch == '(' || ch == ')';
	}
}
