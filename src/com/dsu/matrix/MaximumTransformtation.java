package com.dsu.matrix;

public class MaximumTransformtation {

	public static void main (String[] args) {
		int A[][] = { {1, 1, 1},
				{1, 1, 1},
				{1, 1, 1} };

		int B[][] = { {1, 2, 3},
				{4, 5, 6},
				{7, 8, 9} };

		System.out.println(countOps(A, B, 3, 3)) ;

	}

	private static int countOps(int[][] a, int[][] b, int m, int n) {

		for(int i = 0; i < m ; i++ ) {
			for(int j = 0; j < n; j++) {
				a[i][j] -= b[i][j];
			}
		}

		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(a[i][j] - a[i][0] - a[0][j] + a[0][0] != 0) {
					return -1;
				}
			}
		}

		int res = 0; 
		for(int i = 0; i < m; i++) {
			res += Math.abs(a[i][0]);
		}

		for(int i =0; i < n; i++) {
			res += Math.abs(a[0][i] - a[0][0]);
		}
		return res;
	}
}
