package com.magicline.codingexercise.plain.calc;

import java.util.List;

public interface Parser {
	List<Element> parse(List<String> list) throws Exception;
}
