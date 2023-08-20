package com.dsu.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreatElementStack {
	static Stack<Integer> s = new Stack<>();

	public static void main(String args[]) {
		int arr[] = { 11, 13, 21, 3 };
		int n = arr.length;
		printNGE(arr, n);
	}

	private static void printNGE(int[] arr, int n) {
		int res[] = new int[n];

		for(int i = arr.length - 1; i >= 0; i--) {
			while(!s.isEmpty() && s.peek() <= arr[i]) {
				s.pop();
			}

			res[i] = s.isEmpty() ? -1 : s.peek();
			s.push(arr[i]);
		}

		System.out.println(Arrays.toString(res));
	}
}
