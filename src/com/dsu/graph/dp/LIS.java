package com.dsu.dp;

import java.util.Arrays;

public class LIS {

	public static void main(String args[])
	{
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n = arr.length;

		// Function call
		System.out.println("Length of lis is "+ lis(arr, n));
	}

	private static int lis(int[] arr, int n) {
		int res[] = new int[n];
		Arrays.fill(res, 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]  && res[i] < res[j] + 1) {
					res[i] = res[j] + 1;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i: res) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
}
