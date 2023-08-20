package com.dsu.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackInSingleQueue {

	public static void main(String[] args) {
		stack s = new stack();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.top());
		s.pop();
		s.push(30);
		s.pop();
		System.out.println("Top element :" + s.top());
	}
}

class stack {
	Queue<Integer> q = new LinkedList<Integer>();

	public void push(int i) {
		// TODO Auto-generated method stub
		int size = q.size();

		q.add(i);
		System.out.println(q);
		for(int j = 0 ; j < size;j++) {
			int x = q.remove();
			q.add(x);
		}
		System.out.println(q);
	}

	public  int top() {
		if(!q.isEmpty()) {
			return q.peek();
		}
		return -1;
	}

	public void pop() {
		// TODO Auto-generated method stub
		if(!q.isEmpty())  {
			q.remove();
		}
	}

}
