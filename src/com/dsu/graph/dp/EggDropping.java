package com.dsu.dp;

public class EggDropping {

	public static void main(String[] args) {
		int n = 2, k = 36;
		System.out.println("Minimum number of trials "
				+ "in worst case with " + n + " eggs and "
				+ k + " floors is "+ minTrials(2, 36));
	}

	private static int minTrials(int n, int k) {
		int dp[][] = new int[k+1][n+1];
		int m =0;
		while(dp[m][n] < k) {
			m++;
			for(int i = 1;i <= n; i++) {
				dp[m][i] = 1 + dp[m - 1][i -1] + dp[m - 1][i];
			}
		}
		return m;
	}
}
