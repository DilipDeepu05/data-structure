package com.dsu.stack;

import java.util.ArrayList;
import java.util.List;

public class CustomizedDS {

	static class Pair {
		int ele;
		int min;
		Pair(int e, int m) {
			ele = e;
			min = m;
		}
	}
	
	int min = Integer.MAX_VALUE;
	List<Pair> ls = new ArrayList<>();
	
	public static void main(String[] args) {
		CustomizedDS newStack = new CustomizedDS();
		newStack.addElement(5);
		newStack.addElement(7);
		newStack.addElement(3);
		System.out.println("min element :: "+newStack.getMin());
		newStack.removeLastElement();
		newStack.addElement(2);
		newStack.addElement(9);
		System.out.println("last element :: "+newStack.getLastElement());
		newStack.addElement(0);
		System.out.println("min element :: "+newStack.getMin());
		newStack.removeLastElement();
		newStack.addElement(11);
		System.out.println("min element :: "+newStack.getMin());
	}

	private void removeLastElement() {
		if(ls.size() == 0) {
			System.out.println("no value");
		} else if(ls.size() > 1) {
			min = ls.get(ls.size() - 2).min;
		} else {
			min = Integer.MAX_VALUE;
		}
		ls.remove(ls.size() - 1);
	}

	private int getMin() {
		if(!ls.isEmpty()) {
			return ls.get(ls.size() - 1).min;
		}
		return -1;
	}

	private int getLastElement() {
		if(!ls.isEmpty()) {
			return ls.get(ls.size()- 1).ele;
		}
		return -1;
	}

	private void addElement(int i) {
		if(ls.isEmpty() || i < min) {
			min = i;
		}
		Pair p = new Pair(i, min);
		ls.add(p);
	}
}
