package com.dsu.dp;

//Bell Triangle
public class NumberOfWayToPartitationASet {

	 public static void main(String[] args)
	    {
	        int n = 5;
	        numberOfWay(5);
	        bellNumberDp(5);
	    }

	private static void bellNumberDp(int n) {
		int a[][] = new int[n+1][n+1];
		a[0][0] = 1;
		
		for(int i = 1; i < n+1; i++) {
			a[i][0] = a[i-1][i-1];
			
			for(int j =1; j <= i; j++) {
				a[i][j] = a[i-1][j-1]+a[i][j-1];
			}
		}
		System.out.println(a[n][0]);
	}

	private static void numberOfWay(int n) {
		int a[][] = new int[n+1][n+1];
		for(int i =0; i< n+1;i++) {
			for(int j =0; j < n+1;j++) {
				if(j > i) {
					a[i][j] = 0;
				} else if( i == j) {
					a[i][j] = 1;
				} else if(i == 0 || j == 0) {
					a[i][j] = 0;
				} else {
					a[i][j] = j * a[i - 1][j]+a[i-1][j-1];
				}
			}
		}
		
		int ans =0;
		for(int i =0; i<n+1;i++) {
			ans+= a[n][i];
		}
		System.out.println(ans);
	}
}
