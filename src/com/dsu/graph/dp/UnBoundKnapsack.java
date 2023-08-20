package com.dsu.dp;

public class UnBoundKnapsack {

	public static void main(String args[])
	{
		int W = 100;
		int val[] = { 10, 30, 20 };
		int wt[] = { 5, 10, 15 };
		int n = val.length;
		System.out.println(unboundedKnapsack(W, wt, val, n - 1));
	}

	private static int unboundedKnapsack(int w, int[] wt, int[] val, int n) {
		int dp[][] = new int[n+1][w+1];

		for(int i = 0;i <= n; i++) {
			for(int j = 0; j <=w; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if( wt[i - 1] <= w) {
					dp[i][j] = Math.max(val[i -1]+dp[i][w- wt[i -1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][w];
	}
}
