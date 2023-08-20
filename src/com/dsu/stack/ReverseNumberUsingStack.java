package com.dsu.stack;

import java.util.Stack;

public class ReverseNumberUsingStack {

	static Stack<Integer> s= new Stack<>();
	public static void main(String[] args) {
        int number = 39997;
        System.out.println(reverse_number(number));
    }

	private static int reverse_number(int number) {
		push(number);
		int reverse = 0;
		int i = 1;
		
		while(!s.empty()) {
			reverse += s.peek() * i;
			i = i * 10;
			s.pop();
		}
		
		return reverse;
	}

	private static void push(int number) {
		while(number > 0) {
			s.push(number % 10);
			number /= 10;
		}
	}
}
