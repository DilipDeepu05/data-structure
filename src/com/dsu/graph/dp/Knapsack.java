package com.dsu.dp;

public class Knapsack {

	public static void main(String[] args) {
		int profit[] = { 60, 100, 120 };
		int weight[] = { 10, 20, 30 };

		int W = 50;
		int N = profit.length;

		System.out.println(knapSack(W, weight, profit, N));

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		W = 50;
		int n = val.length;

		printknapSack(W, wt, val, n);
	}

	private static void printknapSack(int w, int[] wt, int[] val, int n) {
		int[][] dp = new int[n+1][w+1];
		
		for(int i = 0;i <=n; i++) {
			for(int j =0;j <=w; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if(wt[i - 1] <= w) {
					dp[i][j] = Math.max(val[i - 1]+ dp[i-1][w-wt[i-1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i - 1][w];
				}
			}
		}
		
		int k = dp[n][w];
		System.out.println(k);
		int j = w;
		
		for(int i = n; i > 0 &&  k > 0; i--) {
			if( k == dp[i - 1][j]) continue;
			else {
				System.out.println(wt[i - 1]);
				k = k - val[i - 1];
				w = w - wt[i - 1];
			}
		}

	}

	private static int knapSack(int w, int[] weight, int[] profit, int n) {
		int[][] dp = new int[w+1][n+1];
		for(int i =0; i <= w; i++) {
			for(int j =0; j <=n ; j++) {
				dp[i][j] = -1;
			}
		}
		return knapSackDp(w, weight, profit, n, dp);
	}

	private static int knapSackDp(int w, int[] weight, int[] profit, int n, int[][] dp) {
		if(n == 0 || w == 0) {
			return 0;
		}

		if(dp[w][n] != -1) {
			return dp[w][n];
		}

		if(weight[n - 1] > w) {
			return dp[w][n] = knapSackDp(w, weight, profit, n - 1, dp);
		}

		return dp[w][n] = Math.max(profit[n -1] + knapSackDp(w - weight[n - 1], weight, profit, n -1 , dp), knapSackDp(w, weight, profit, n - 1, dp));
	}
}
