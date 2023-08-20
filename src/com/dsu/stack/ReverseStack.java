package com.dsu.stack;

public class ReverseStack {

	static java.util.Stack<Character> st = new java.util.Stack<>();
	
	public static void main(String[] args) {

		st.push('1');
		st.push('2');
		st.push('3');
		st.push('4');

		System.out.println("Original Stack");

		System.out.println(st);

		// function to reverse
		// the stack
		reverse();

		System.out.println("Reversed Stack");

		System.out.println(st);
	}
	
	private static void reverse() {
		if(st.size() > 0) {
			char c = st.pop();
			reverse();
			insert_at_bottom(c);
		}
	}
	
	private static void insert_at_bottom(char c) {
		if(st.isEmpty()) {
			st.push(c);
		} else {
			char t = st.pop();
			insert_at_bottom(c);
			st.push(t);
		}
	}
}
