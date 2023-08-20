package com.dsu.stack;

import java.util.LinkedList;
import java.util.Queue;

public class CheckQueueCanBeStoredUsingStack {

	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String args[]) {
		q.add(5);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);

		int n = q.size();

		if (checkSorted(n))
			System.out.print("Yes");
		else
			System.out.print("No");
	}

	private static boolean checkSorted(int n) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		int fnt = 0, expected = 1;

		while(!q.isEmpty()) {
			fnt = q.poll(); 
			if(fnt == expected) {
				expected++;
			} else {
				if(s.isEmpty()) {
					s.push(fnt);
				}

				else if ( !s.isEmpty() && s.peek() < fnt) {
					return false;
				} else  {
					s.push(fnt);
				}
			}
		}
		System.out.println(s + " "+ expected);
		while(!s.isEmpty() && s.peek() == expected) {
			s.pop();
			expected++;
		}
		return true;
	}
}
