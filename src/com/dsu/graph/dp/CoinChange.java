package com.dsu.dp;

public class CoinChange {

	 public static void main(String args[])
	    {
	        int coins[] = { 1, 2, 3 };
	        int n = coins.length;
	 
	        System.out.println(count(coins, n, 4));
	        System.out.println(countdp(coins, n, 4));
	    }

	private static int countdp(int[] coins, int n, int sum) {
		int a[] = new int[sum+1];
		a[0] = 1;
		for(int i = 0; i< n; i++) {
			for(int j = coins[i]; j <= sum; j++) {
				a[j] += a[j - coins[i]];
			}
		}
		return a[sum];
	}

	private static int count(int[] coins, int n, int sum) {
		if(sum == 0) {
			return 1;
		}
		
		if(sum < 0 || n <= 0) {
			return  0;
		}
		
		return count(coins, n - 1, sum) + count(coins, n, sum - coins[n -1]);
	}
}
