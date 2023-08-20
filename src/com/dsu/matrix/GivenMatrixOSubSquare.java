package com.dsu.matrix;

public class GivenMatrixOSubSquare {

	public static void main (String[] args) {
		int mat[][] = {
				{ 'X', 'O', 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'X', 'X', 'O', 'O', 'X' },
				{ 'O', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O' },
		};

		// Function call
		System.out.println(maximumSubSquare(mat));
	}

	private static int maximumSubSquare(int[][] mat) {
		int dp[][][] = new int[51][51][2];

		for(int i= 0; i < mat.length; i++) {
			int x = 0;
			for(int j = 0; j < mat.length; j++) {
				if(mat[i][j] == 'X') {
					x += 1;
				} else {
					x = 0;
				}
				dp[i][j][0] = x;
			}
		}

		for(int i= 0; i < mat.length; i++) {
			int x = 0;
			for(int j = 0; j < mat.length; j++) {
				if(mat[j][i] == 'X') {
					x += 1;
				} else {
					x = 0;
				}
				dp[j][i][1] = x;
			}
		}

		int max = 0, val =0;
		for(int i= 0; i < mat.length; i++) {
			int x = 0;
			for(int j = 0; j < mat.length; j++) {
				val  = Math.min(dp[i][j][0], dp[i][j][1]);
				if(dp[i][j - val + 1][1] >= val && dp[i - val + 1][j][0] >= val) {
					x = val;
				} else {
					x = 0;
				}
				max = Math.max(max, x);
			}
		}

		return max;
	}
}
