package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestSumDivideByK {

	public static void main(String[] args)
	{
		int arr[] = { 2, 7, 6, 1, 4, 5 };
		int n = arr.length;
		int k = 3;

		System.out.println(
				"Length = "
						+ longestSubarrWthSumDivByK(arr, n, k));
	}

	private static int longestSubarrWthSumDivByK(int[] arr, int n, int k) {
		int mod[] = new int[n];
		int sum = 0;
		int c = 0;
		Map<Integer, Integer> m = new HashMap<>();
		for(int i = 0 ; i < arr.length; ++i) {
			sum =+ arr[i];
			
			mod[i] = ((sum % k) + k) % k;
			
			if(mod[i] == 0) {
				c = i + 1;
			} else if(!m.containsKey(mod[i])) {
				m.put(mod[i], i);
			} else {
				c = Math.max(c, i - m.get(mod[i]));
			}
		}
		return c;
	}
}
