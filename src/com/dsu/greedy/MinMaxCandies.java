package com.dsu.greedy;

import java.util.Arrays;

public class MinMaxCandies {

	public static void main(String[] args)
	{
		int arr[] = { 3, 2, 1, 4 };
		int n = arr.length;
		int k = 2;
		Arrays.sort(arr);

		// Function call
		System.out.println(findMinimum(arr, n, k) + " "
				+ findMaximum(arr, n, k));
	}

	private static int findMaximum(int[] arr, int n, int k) {
		int index = 0;
		int res = 0;
		for(int i = n - 1; i >= index; i--) {
			res +=arr[i];
			
			index += k;
		}
		return res;
	}

	private static int findMinimum(int[] arr, int n, int k) {
		int d = 0;
		for(int i =0; i < n; i++) {
			d += arr[i];
			
			
			n = n - k;
		}
		return d;
	}
}
