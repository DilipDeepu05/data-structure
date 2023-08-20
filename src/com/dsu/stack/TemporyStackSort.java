package com.dsu.stack;

import java.util.Stack;

public class TemporyStackSort {

	public static void main(String args[]) {
		Stack<Integer> input = new Stack<Integer>();
		input.add(34);
		input.add(3);
		input.add(31);
		input.add(98);
		input.add(92);
		input.add(23);

		// This is the temporary stack
		Stack<Integer> tmpStack = sortstack(input);
		System.out.println("Sorted numbers are:");

		while (!tmpStack.empty()) {
			System.out.print(tmpStack.pop()+" ");
		}
	}

	private static Stack<Integer> sortstack(Stack<Integer> input) {
		Stack<Integer> temp = new Stack<>();

		while(!input.isEmpty()) {
			int t = input.pop();

			while(!temp.isEmpty() && temp.peek() > t) {
				input.push(temp.pop());
			}
			
			System.out.println(t);
			temp.push(t);
		}
		return temp;
	}
}
