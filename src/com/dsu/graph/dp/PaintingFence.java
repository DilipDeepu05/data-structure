package com.dsu.dp;

public class PaintingFence {

	public static void main(String[] args)
	{
		int n = 3, k = 2;
		System.out.println(countWays(n, k));
	}

	private static int countWays(int n, int k) {
		int total = k;
		 int mod = 1000000007;
		 
		 int same = 0, diff = k;
		 
		 for(int i = 2; i < k; i++) {
			 same = diff;
			 diff = total * ( k - 1);
			 diff = diff % mod;
			 
			 total = (same + diff) % mod;
		 }
		return total;
	}
}
