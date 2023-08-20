package com.dsu.stack;

import java.util.Stack;

public class MonoTonicStackIDecreasing {

	public static void main(String args[])
    {
        int arr[] = { 15, 17, 12, 13, 14, 10 };
        int N = arr.length;
 
        // Function call
        decreasingStack(arr, N);
    }
	
	private static void decreasingStack(int[] arr, int n) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		
		for(int i = 0; i < n; ++i) {
			while(s.size() > 0 && s.peek() < arr[i]) {
				s.pop();
			}
			s.push(arr[i]);
		}
		
		
		int n2 = s.size();
		int[] arr1 = new int[n2];
		int j = s.size() - 1;
		
		while(!s.isEmpty()) {
			arr1[j--] = s.pop();
		}
		
		System.out.println("Original Array:- ");
		
		for(int i = 0 ; i < n ; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println();
		System.out.println("Monotonic stack Array:- ");
		
		for(int i = 0 ; i < n2 ; i++) {
			System.out.print(arr1[i]+ " ");
		}
	}
}
