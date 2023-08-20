package com.dsu.queue;

import java.util.Stack;

public class QueueWithStack {

	public static void main(String[] args) { 
		Queue2 q = new Queue2(); 
		q.enQueue(1); 
		q.enQueue(2); 
		q.enQueue(3); 

		System.out.println(q.deQueue()); 
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
	} 
}

class Queue2 {
	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public void enQueue(int i) {
		while(!s1.empty()) {
			s2.push(s1.pop());
		}

		s1.push(i);

		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}

	}

	public int deQueue() {
		if(!s1.isEmpty()) {
			return s1.pop();
		}
		return -1;
	}
}