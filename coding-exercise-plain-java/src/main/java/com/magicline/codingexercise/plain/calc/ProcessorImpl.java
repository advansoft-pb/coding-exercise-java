package com.magicline.codingexercise.plain.calc;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class ProcessorImpl implements Processor {

	@Override
	public int process(List<Element> list) {

		Deque<Element> valueStack = new ArrayDeque<>();
		Iterator<Element> iterator = list.iterator();

		while (iterator.hasNext()) {
			Element elem = iterator.next();

			if (elem.isInt()) {
				valueStack.push(elem);
			} else if (elem.getOper() != null) {
				int b = valueStack.pop().getInt();
				int a = valueStack.pop().getInt();
				int x = elem.getOper().calc(a, b);
				valueStack.push(new Element(Integer.toString(x)));
			}
		}

		return valueStack.pop().getInt();
	}
}
