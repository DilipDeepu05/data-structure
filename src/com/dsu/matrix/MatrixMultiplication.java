package com.dsu.matrix;

public class MatrixMultiplication {

	public static void main(String[] args)
	{
		int[][] mat1 = { { 1, 1 },
				{ 2, 2 } };

		int[][] mat2 = { { 1, 1 },
				{ 2, 2 } };


		if (mat1.length != mat2.length) {
			System.out.println(
					"The number of columns in Matrix-1  must be equal to the number of rows in Matrix-2");
			System.out.println(
					"Please update the global variables according to your array dimension");
		}
		else {

			// Function call
			mulMat(mat1, mat2);
		}
	}

	private static void mulMat(int[][] mat1, int[][] mat2) {
		int res[][] = new int[mat1.length][mat2[0].length];
		for(int i = 0; i < mat1.length; i++) {
			for(int j =0; j < mat2[0].length; j++) {
				res[i][j] = 0;
				for(int k = 0; k <mat2.length; k++) {
					res[i][j] += mat1[i][k] * mat2[k][j];
				}
				System.out.print(res[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
