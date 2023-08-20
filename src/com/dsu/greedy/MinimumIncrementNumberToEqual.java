package com.dsu.greedy;

public class MinimumIncrementNumberToEqual {

	public static void main(String[] args)
	{
		int arr[] = { 21, 33, 9, 45, 63 };
		int n = arr.length;
		int k = 6;
		System.out.println(minOps(arr, n, k));
	}

	private static int minOps(int[] arr, int n, int k) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		int res =0;
		for(int i =0;i < n; i++) {
			if((max -arr[i]) % k != 0) {
				return -1;
			}
			res += (max-arr[i])/k;
		}
		return res;
	}
}
