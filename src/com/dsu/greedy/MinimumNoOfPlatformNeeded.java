package com.dsu.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinimumNoOfPlatformNeeded {

	public static void main(String[] args) {
		int[] arr = { 100, 300, 600 };
		int[] dep = { 900, 400, 500 };
		int n = arr.length;
		System.out.println(findPlatformOptimized(arr, dep, n));
	}

	private static int findPlatformOptimized(int[] arr, int[] dep, int n) {
		int max = Integer.MIN_VALUE;

		for(int i = 0;i < arr.length; i++) {
			max = Math.max(max, dep[i]);
		}

		List<Integer> ls = new ArrayList<>(max+2);

		for(int i =0; i < max+2; i++) {
			ls.add(0);
		}

		for(int i = 0;i < arr.length; i++) {
			ls.set(arr[i] , ls.get(arr[i])+1);
			ls.set(dep[i]+1, ls.get(dep[i]+1) -1);
		}

		int count = 0, min = Integer.MIN_VALUE;
		for(int i = 0;i < max+2; i++) {
			count = ls.get(i);
			min = Math.max(min, count);
		}
		return min;
	}
}
