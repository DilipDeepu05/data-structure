package com.dsu.greedy;

import java.util.Arrays;

public class MaxSubarrayK {

	public static void main(String args[])
	{
		int arr[] = { 8, 4, 5, 2, 10 };
		int N = arr.length;
		int k = 2;
		System.out.println(maxDifference(arr, N, k));
	}

	private static int maxDifference(int[] arr, int n, int k) {
		Arrays.sort(arr);
		int sum =0, sum1 =0;
		for(int i =0;i <k;i++) {
			sum +=arr[i];
		}
		
		for(int i = k; i < n; i++) {
			sum1 +=arr[i];
		}
		return sum1 - sum;
	}
}
