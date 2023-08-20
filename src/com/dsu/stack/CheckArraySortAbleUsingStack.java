package com.dsu.stack;

import java.util.Stack;

public class CheckArraySortAbleUsingStack {

	public static void main(String[] args) {

		int A[] = {4, 1, 2, 3};
		int N = A.length;

		if (check(A, N)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static boolean check(int[] a, int n) {
		Stack<Integer> s = new Stack<>();
		int top = 0;
		
		for(int i =0;i < n; i++) {
			if(!s.isEmpty()) {
				
				while( top + 1 == s.peek()) {
					top++;
					s.pop();
					if(s.isEmpty()) {
						break;
					}
				}
				
				if(s.isEmpty()) {
					s.push(a[i]);
				} else {
					top = s.peek();
					
					if(a[i] < top) {
						s.push(a[i]);
					} else {
						return false;
					}
				}
				
			} else {
				s.push(a[i]);
			}
		}
		return true;
	}
}
