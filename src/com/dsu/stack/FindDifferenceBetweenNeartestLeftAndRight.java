package com.dsu.stack;

import java.util.Stack;

public class FindDifferenceBetweenNeartestLeftAndRight {

	public static void main(String args[]) {
		int arr[] = {2, 4, 8, 7, 7, 9, 3};
		int n = arr.length;
		System.out.println("Maximum diff : "+ findMaxDiff(arr, n));
	}

	private static int findMaxDiff(int[] arr, int n) {
		int l[] = new int[n];
		
		leftSmall(arr, n, l);
		reverse(arr, n);
		
		int r[] = new int[n];
		leftSmall(arr, n, r);
		
		int max = 0;
		
		for(int i =0;i < n; i++) {
			max = Math.max(max, l[i] -r[n- i - 1]);
		}
		return max;
	}

	private static void reverse(int[] arr, int n) {
		for(int i = 0; i < n / 2; i++) {
			int t = arr[i];
			arr[i] = arr[n - i - 1];
			arr[n - i- 1] = t;
		}
	}

	private static void leftSmall(int[] arr, int n, int[] l) {
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < n; i++) {
			
			while(!s.isEmpty() && s.peek() >= arr[i]) {
				s.pop();
			}
			
			if(!s.isEmpty()) {
				l[i] = s.peek();
			} else {
				l[i] = 0;
			}
			
			s.push(arr[i]);
		}
	}
}
