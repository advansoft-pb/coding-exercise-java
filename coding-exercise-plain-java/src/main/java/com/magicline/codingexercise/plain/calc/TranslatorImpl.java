package com.magicline.codingexercise.plain.calc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class TranslatorImpl implements Translator {

	@Override
	public List<Element> translate(List<Element> list) {

		if (list == null) {
			return null;
		}

		final Deque<Element> stack = new ArrayDeque<>();
		final List<Element> result = new ArrayList<>();

		Iterator<Element> iterator = list.iterator();

		while (iterator.hasNext()) {
			Element element = iterator.next();

			if (element.isInt()) {
				result.add(element);
			} else if (element.getOper() != null) {
				if (stack.peek() == null || stack.peek().getOper() != null
						&& stack.peek().getOper().prior() < element.getOper().prior()) {
					stack.push(element);
				} else {
					while (stack.peek() != null && stack.peek().getOper() != null
							&& stack.peek().getOper().prior() >= element.getOper().prior()) {
						result.add(stack.pop());
					}

					stack.push(element);
				}
			}
		}

		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}

		return result;
	}
}
