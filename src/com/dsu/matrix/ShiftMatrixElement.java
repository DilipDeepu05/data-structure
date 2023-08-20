package com.dsu.matrix;

public class ShiftMatrixElement {

	public static void main(String args[]) {
		int [][]mat = new int [][]
				{ {1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16} };
			int k = 2;

			// Function call
			shiftMatrixByK(mat, k);
	}

	private static void shiftMatrixByK(int[][] mat, int k) {
		int j = 0;
		int n = mat.length;
		while(j < n) {
			for(int i =k; i < n; i++) {
				System.out.print(mat[j][i]+ " ");
			}

			for(int i = 0; i < k; i++) {
				System.out.print(mat[j][i]+" ");
			}
			j++;
			System.out.println();
		}
	}
}
