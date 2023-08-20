package com.dsu.dp;

public class NumberOfPath {

	public static void main(String args[]) {
		System.out.println(numberOfPaths(3, 3));
		int DP[][] = new int[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				DP[i][j] = 0;
			}
		}

		System.out.println(numberOfPaths(3, 3, DP));
	}

	private static int numberOfPaths(int i, int j, int[][] dp) {
		if(i == 1 || j == 1)  {
			dp[i][j] = 1;
		}
		
		if(dp[i][j] == 0) {
			dp[i][j] = numberOfPaths(i-1, j, dp) + numberOfPaths(i, j - 1, dp);
		}
		
		return dp[i][j];
	}

	private static int numberOfPaths(int i, int j) {
		if(i == 1 || j == 1) {
			return 1;
		}
		return numberOfPaths(i - 1, j) + numberOfPaths(i, j - 1);
	}
}
