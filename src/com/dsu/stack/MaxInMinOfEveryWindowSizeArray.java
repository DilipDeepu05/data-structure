package com.dsu.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxInMinOfEveryWindowSizeArray {
	static int arr[] = { 10, 20, 30, 50, 10, 70, 30 };

	public static void main(String[] args) {
		printMaxOfMin(arr.length);
	}

	private static void printMaxOfMin(int n) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		int l[] = new int[n+1];
		int r[] =  new int[n+1];

		for(int i=0;i <= n; ++i) {
			l[i] = -1;
			r[i] = n;
		}

		for(int i = 0; i < n; i++) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}

			if(!s.isEmpty()) {
				l[i] = s.peek();
			}

			s.push(i);
		}
		System.out.print(Arrays.toString(l));
		while(!s.isEmpty())
			s.pop();

		for(int i = n-1; i >= 0; i--) {
			while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
				s.pop();
			}

			if(!s.isEmpty()) {
				r[i] = s.peek();
			}

			s.push(i);
		}

		int ans[] = new int[n+1];
		for(int i = 0; i <= n; ++i) {
			ans[i] = 0;
		}


		for(int i = 0; i < n; i++) {
			int len =  r[i] -l[i]  - 1;
			ans[len] = Math.max(ans[len], arr[i]);
		}

		for(int i = n -1; i >= 1; i--) {
			ans[i] = Math.max(ans[i], ans[i+1]);
		}

		for (int i = 1; i <= n; i++)
			System.out.print(ans[i] + " ");
	}
}
