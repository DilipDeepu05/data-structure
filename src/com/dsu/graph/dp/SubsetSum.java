package com.dsu.dp;

public class SubsetSum {

	public static void main(String args[])
	{
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		int n = set.length;
		if (isSubsetSum(set, n, sum) == true)
			System.out.println("Found a subset"
					+ " with given sum");
		else
			System.out.println("No subset with"
					+ " given sum");
		
		
		if (isSubsetSumdp(set, n, sum) == true)
			System.out.println("Found a subset"
					+ " with given sum");
		else
			System.out.println("No subset with"
					+ " given sum");
	}

	private static boolean isSubsetSumdp(int[] set, int n, int sum) {
		boolean a[][] = new boolean[sum + 1][n + 1];
		
		for(int i = 0; i <= n ; i++) {
			a[0][i] = true;
		}
		
		for(int i = 1; i <= sum; i++) {
			a[i][0] = false;
		}
		
		for(int i = 1; i <= sum; i++) {
			for(int j = 1; j <= n; j++) {
				a[i][j] = a[i][j - 1];
				if(i >= set[j- 1]) {
					a[i][j] = a[i][j] || a[i - set[j - 1]][j -1];
				}
			}
		}
		
		return a[sum][n];
	}

	private static boolean isSubsetSum(int[] set, int n, int sum) {
		if(sum == 0) {
			return true;
		}
		if(n == 0) {
			return false;
		}
		
		if(set[n - 1] > sum) {
			return isSubsetSum(set, n - 1, sum);
		}
		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
	}
}
