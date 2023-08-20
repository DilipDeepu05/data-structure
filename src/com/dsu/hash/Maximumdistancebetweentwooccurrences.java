package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class Maximumdistancebetweentwooccurrences {

	public static void main(String args[])
	{
		int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
		int n = arr.length;
		System.out.println(maxDistance(arr, n));
	}

	private static int maxDistance(int[] arr, int n) {
		int max = 0;
		Map<Integer, Integer> m = new HashMap<>();
		
		for(int i = 0; i < arr.length; ++i) {
			if(!m.containsKey(arr[i])) {
				m.put(arr[i], i);
			} else {
				max = Math.max(max, i - m.get(arr[i]));
			}
		}
		return max;
	}
}
