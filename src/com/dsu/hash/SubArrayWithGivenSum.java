package com.dsu.hash;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

	public static void main(String[] args)
	{
		int[] arr = { 10, 2, -2, -20, 10 };
		int n = arr.length;
		int sum = -10;

		subArraySum(arr, n, sum);
	}

	private static void subArraySum(int[] arr, int n, int sum) {
		Map<Integer, Integer> m = new HashMap<>();
		int start = 0;
		int end = -1;
		int csum = 0;
		
		for(int i = 0 ; i < arr.length; ++i) {
			csum+=arr[i];
			
			if(sum - csum == 0) {
				System.out.println("sum");
				start = 0;
				end = i;
				break;
			}
			
			if(m.containsKey(sum - csum)) {
				start = m.get(sum  - csum) + 1;
				end = i;
				break;
			}
			
			m.put(csum, i);
 		}
		
		if(end == -1) {
			System.out.println("No pair");
		} else {
			System.out.println(start+" "+ end);
		}
		
	}
}
