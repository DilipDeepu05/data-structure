package com.dsu.matrix;

public class MinimumFlip {

	public static void main(String[] args) {
		int n = 3;
		int mat[][] = {{ 0, 0, 1 },
				{ 1, 1, 1 },
				{ 1, 0, 0 }};

		System.out.println(minimumflip(mat, n));
	}

	private static int minimumflip(int[][] mat, int n) {
		int flip =0;
		for(int i = 0; i <  n; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] != mat[j][i]) {
					flip++;
				}
			}
		}
		return flip / 2;
	}
}
