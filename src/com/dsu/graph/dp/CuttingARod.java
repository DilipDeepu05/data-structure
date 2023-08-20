package com.dsu.dp;

public class CuttingARod {

	public static void main(String args[])
	{
		int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
		int size = arr.length;
		System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
	}

	private static int cutRod(int[] arr, int size) {
		int a[] = new int[size+1];
		a[0] = 0;
		
		for(int i = 1; i <= size; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 0; j < i; j++) {
				max = Math.max(max, arr[j] + a[i -j -1]);
			}
			a[i] = max;
		}
		return a[size];
	}
}
