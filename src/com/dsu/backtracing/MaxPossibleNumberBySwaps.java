package com.dsu.backtracing;

public class MaxPossibleNumberBySwaps {
	static String max;
	
	public static void main(String[] args)
	{
		String str = "129814999";
		int k = 4;
		max = str;
		findMaximumNum(str.toCharArray(), k);
		//Print the answer stored in res class
		System.out.println(max);
	}

	private static void findMaximumNum(char[] c, int k) {
		if(k == 0) {
			return;
		}
		int n =c.length;
		
		for(int i =0; i < n -1;i++) {
			for(int j = i + 1;j < n; j++) {
				if(c[j] > c[i]) {
					char temp = c[i];
					c[i] = c[j];
					c[j] = temp;
					
					
					if(max.compareTo(String.valueOf(c)) < 0) {
						max = String.valueOf(c);
					}
					
					findMaximumNum(c, k - 1);
					
					temp = c[i];
					c[i] = c[j];
					c[j] = temp;
				}
			}
		}
	}
}
