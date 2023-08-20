package com.dsu.stack;

import java.util.Stack;

public class MaxProdLeftRightNextElement {
	
	static int max = 1000;

	public static void main(String args[]) {
		int []arr = new int[]{ 5, 4, 3, 4, 5 };
		int n = arr.length;

		System.out.print(LRProduct(arr, n));
	}

	private static int LRProduct(int[] arr, int n) {
		int l[] = nextLeft(arr, n);
		int r[] = nextRight(arr, n);
		
		int max = -1;
		
		for(int i = 0; i < n; i++) {
			max = Math.max(max, l[i] * r[i]);
		}
		
		return max;
	}

	private static int[] nextRight(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		int r[] = new int[max];
		for(int  i = n - 1; i >= 0; i--) {
			while(!s.isEmpty() && arr[i] > arr[s.peek() - 1]) {
				int c = s.peek();
				r[c - 1] = i + 1;
			}
			s.push(i + 1);
		}
		return r;
	}

	private static int[] nextLeft(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		int[] r = new int[max];
		for(int i = 0; i < n; i++) {
			while(!s.isEmpty() && arr[i] > arr[s.peek() - 1]) {
				int c = s.peek();
				r[c - 1] = i + 1;
			}
			s.push(i + 1);
		}
		return r;
	}
}