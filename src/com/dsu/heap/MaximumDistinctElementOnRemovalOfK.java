package com.dsu.heap;

import java.util.HashMap;
import java.util.Map;

public class MaximumDistinctElementOnRemovalOfK {

    public static void main(String[] args)
    {
        int arr[] = { 5, 7, 5, 5, 1, 2, 2 };
        int n = arr.length;
        int k = 3;
 
        // Function Call
        System.out.println("Maximum distinct elements = "
                           + maxDistinctNum(arr, n, k));
    }

	private static int maxDistinctNum(int[] arr, int n, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		
		for(int i = 0; i < arr.length; ++i) {
			
			m.put(i, m.getOrDefault(i, 0) + 1);
		}
		
		int temp = 0;
		for(int i: m.keySet()) {
			temp += (int)m.get(i)  - 1;
		}
		
		if(k <= temp) {
			return arr.length;
		} else {
			k = k - temp;
			int i =arr.length;
			while(k != 0) {
				i--;
				k--;
			}
			return i;
		}
	}
}
