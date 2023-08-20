package com.dsu.greedy;

import java.util.Arrays;

public class SortAnArrayUsingReverseMiddle {

	public static void main(String[] args)
	{
		int arr[] = { 1, 7, 6, 4, 5, 3, 2, 8 };
		int n = arr.length;
		if (ifPossible(arr, n))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean ifPossible(int[] a, int n) {
		int copy[] = Arrays.copyOf(a, n);
		
		for(int i =0; i < n ; i++) {
			if(!(a[i] == copy[i]) && !(a[i] == copy[n -i -1])) return false;
		}
		return true;
	}
}
