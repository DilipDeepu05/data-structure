package com.dsu.testing;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Testing {

	static Stack<Integer> s = new Stack<>();

	public static void main(String args[]) {
		List<String> l = List.of("1", "2", "4");
		List<Integer> ls = l.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(ls);
	}
}
