package com.dsu.stack;

public class ArrayStack {
	
	public static void main(String args[]) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.pop() + " Popped from stack");
		System.out.println("Top element is :" + s.peek());
		System.out.print("Elements present in stack :");
		s.print();
	}
}

class Stack {
	static int arr[] = new int[1000];
	int top;
	
	Stack() {
		top = -1;
	}
	
	void push(int x) {
		if(top>= arr.length - 1) {
			System.out.println("Over flow");
		} else {
			arr[++top] = x;
		}
	}
	
	int pop() {
		if(top < 0) {
			System.out.println("Under flow");
			return 0;
		} else {
			return arr[top--];
		}
	}
	
	int peek() {
		if(top < 0) {
			System.out.println("Under flow");
			return 0;
		} else {
			return arr[top];
		}
	}
	
	void print() {
		for(int i = top; i >=0; i--) {
			System.out.println(arr[i]);
		}
	}
}
