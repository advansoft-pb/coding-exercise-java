package com.magicline.codingexercise.plain.calc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TranslatorImpl implements Translator {

	@Override
	public List<Element> translate(List<Element> list) {

		Deque<Element> stack = new ArrayDeque<>();
		List<Element> result = new ArrayList<>();

		for (int index = 0; index < list.size(); index++) {
			Element element = list.get(index);

			if (element.isInt()) {
				result.add(element);
			} else if (element.getOper() != null) {
				stack.push(element);
			}
		}

		while (!stack.isEmpty()) {
			Element elem = stack.pop();
			result.add(elem);
		}

		return result;
	}
}
