package com.dsu.matrix;

import java.util.Arrays;

public class Determinent {

	// Dimension of input square matrix
	static final int N = 4;

	// Driver code
	public static void main(String[] args) {
		int mat[][] = {{0, 1, 1},
				{4, 0, 5},
				{2, 8, 0}};

		//		int mat[][] = { { 1, 0, 2, -1 },
		//				{ 3, 0, 0, 5 },
		//				{ 2, 1, 4, -3 },
		//				{ 1, 0, 5, 0 } };

		// Function call
		System.out.printf("Determinant of the matrix is : %d", determinantOfMatrix(mat, 3));
	}

	private static Object determinantOfMatrix(int[][] mat, int n) {
		int num1 = 0, num2 = 0, det = 1, total = 1, index = 0;

		int temp[] = new int[n + 1];

		for(int i = 0; i < n; i++) {
			index = i;

			while(index < n && mat[index][i] == 0) {
				index++;
			}

			if(index == n) continue;
			System.out.println(index+ " "+i);
			if(index != i) {
				for(int j = 0 ; j < n; j++) {
					swap(mat, index, j, i, j);
				}
				det =  (int) (det * Math.pow(-1, index - i));
			}

			for(int j = 0 ; j < n; j++) {
				temp[j] = mat[i][j];
			}
			System.out.println(Arrays.toString(temp));
			for(int j= i + 1 ; j < n; j++) {
				num1 = temp[i];
				num2 = mat[j][i];

				for(int k = 0; k < n; k++) {
					mat[j][k] = (num1 * mat[j][k]) - (num2 * temp[k]);
				}
				total = total * num1;
			}
		}


		for(int i = 0; i < n; i++) {
			det *= mat[i][i];
		}

		return (det/ total);
	}

	static int[][] swap(int[][] arr, int i1, int j1, int i2, int j2)
	{
		int temp = arr[i1][j1];
		System.out.println(temp+ " swap "+ arr[i2][j2]);
		arr[i1][j1] = arr[i2][j2];
		arr[i2][j2] = temp;
		return arr;
	}
}