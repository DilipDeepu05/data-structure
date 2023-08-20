package com.dsu.hash;

import java.util.Collections;

public class LongestIncreasigSubSequence {

	public static void main(String args[]) {
		int[] a = {6, 7, 8, 3, 4, 5, 9, 10};
	    int n = a.length;
	    System.out.println(LongestSubsequence(a, n));
	}

	private static int LongestSubsequence(int[] a, int n) {
		java.util.Map<Integer, Integer> m = new java.util.HashMap<>();
		
		m.put(a[0], 1);
		for(int i = 1; i < n ;i++) {
			if(m.containsKey(a[i] - 1)) {
				m.put(a[i], m.get(a[i] - 1) + 1);
			} else {
				m.put(a[i], 1);
			}
		}
		return Collections.max(m.values());
	}
}
