package com.dsu.stack;

import java.util.PriorityQueue;

//log(n)
public class StackUsingProrityQueue {

	int c;
	PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
	
	public static void main(String[] args) {
		StackUsingProrityQueue s = new StackUsingProrityQueue();
		s.push(3);
		s.push(2);
		s.push(1);
		while (!s.isEmpty()) {
			System.out.println(s.top());
			s.pop();
		}
	}

	private int top() {
		int temp[] = q.peek();
		return temp[1];
	}

	private void pop() {
		if(q.isEmpty()) {
			System.out.println("empty");
			return;
		}
		
		c--;
		q.poll();
	}

	private boolean isEmpty() {
		return q.isEmpty();
	}

	private void push(int i) {
		c++;
		q.add(new int[] {c, i});
	}
}
