package com.dsu.matrix;

public class SprialMatrix {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 4 },
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		// Function call
		spiralOrder(a);
	}

	private static void spiralOrder(int[][] a) {
		int row = 0, col = 0;
		int m = a.length;
		int n = a[0].length;
		
		
		while(row < m && col < n) {
			for(int i = col; i < m; i++) {
				System.out.print(a[row][i]+ " ");
			}
			row++;
			System.out.println();
			for(int i = row; i < n; i++) {
				System.out.print(a[i][n-1]+ " ");
			}
			n--;
			System.out.println();
			for(int i = m - 1; i >= col; i--) {
				System.out.print(a[m-1][i]+ " ");
			}
			m--;
			System.out.println();
			for(int i = m - 1; i > col; i--) {
				System.out.print(a[i][col]+ " ");
			}
			col++;
			System.out.println();
		}
	}
}
