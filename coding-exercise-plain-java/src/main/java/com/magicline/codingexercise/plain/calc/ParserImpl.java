package com.magicline.codingexercise.plain.calc;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {

	@Override
	public List<Element> parse(List<String> list) throws Exception {

		if (list == null) {
			return null;
		}

		final List<Element> result = new ArrayList<>();

		for (int index = 0; index < list.size(); index++) {
			String val = list.get(index);
			Element elem = new Element(val);
			result.add(elem);
		}

		return result;
	}
}
