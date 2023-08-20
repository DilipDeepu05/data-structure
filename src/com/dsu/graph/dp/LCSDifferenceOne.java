package com.dsu.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LCSDifferenceOne {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 3, 2 };
		int n = arr.length;
		System.out.println(longestSubsequence(n, arr));
	}

	private static int longestSubsequence(int n, int[] arr) {
		Integer dp[] = new Integer[n];
		if(n == 1) {
			return 1;
		}
		
		Map<Integer, Integer> m = new HashMap<>();
		dp[0] = 1;
		m.put(arr[0], 0);
		
		for(int i = 1; i < n; i++) {
			if(Math.abs(arr[i] - arr[i - 1]) == 1) {
				dp[i] = dp[i -1] +1;
			} else {
				if(m.containsKey(arr[i] + 1) || m.containsKey(arr[i] - 1)) {
					dp[i] = 1 + Math.max(m.getOrDefault(arr[i] + 1, 0), m.getOrDefault(arr[i] - 1, 0));
				} else {
					dp[i] = 1;
				}
			}
			m.put(arr[i], dp[i]);
		}
 		return Collections.max(Arrays.asList(dp));
	}
}
