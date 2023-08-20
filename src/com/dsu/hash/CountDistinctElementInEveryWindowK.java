package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementInEveryWindowK {

	public static void main(String arg[])
	{
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int K = 4;

		// Function call
		countDistinct(arr, K);
	}

	private static void countDistinct(int[] arr, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0 ; i < k; i++) {
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
		}
		
		System.out.println(m.size());
		for(int i = k ; i < arr.length; i++) {
			
			if(m.get(arr[i - k]) == 1) {
				m.remove(arr[i - k]);
			} else {
				m.put(arr[i - k], m.get(arr[i - k]) - 1);
			}
			
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
			System.out.println(m.size());
		}
	}
}
