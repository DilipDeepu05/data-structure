package com.dsu.matrix;

public class AdJacentInverse {
	static int N = 4;

	public static void main(String[] args) {
		int A[][] = { {5, -2, 2, 7},
				{1, 0, 0, 3},
				{-3, 1, 5, 0},
				{3, -1, -9, 4}};

		int [][]adj = new int[N][N]; // To store adjoint of A[][]

		int [][]inv = new int[N][N]; // To store inverse of A[][]

		System.out.print("Input matrix is :\n");
		display(A);

		System.out.print("\nThe Adjoint is :\n");
		adjoint(A, adj);
		display(adj);

		System.out.print("\nThe Inverse is :\n");
		if (inverse(A, inv))
			display(inv);

	}

	private static boolean inverse(int[][] a, int[][] inv) {
		int d = determinant(a, N);
		if(d==0) {
			System.out.println("No inverse");
			return false;
		}
		int adj[][] = new int[N][N];
		adjoint(a, adj);
		for(int i =0; i < N; i++) {
			for(int j =0 ; j < N; j++) {
				inv[i][j] = adj[i][j]/d;
			}
		}
		return true;
	}

	private static void adjoint(int[][] a, int[][] adj) {
		int n = a.length;
		int sign = 1;
		int temp [][] = new int[n][n];

		for(int i =0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				getCoFactor(a, temp, i, j, n);

				sign = (i +j) %2 == 0 ? 1 : -1;

				adj[j][i] = sign * determinant(temp, n-1);
			}
		}

	}

	public static int determinant(int a[][], int n) {

		int d = 0;
		if(n == 1) {
			return a[0][0];
		}
		int sign = 1;
		int temp[][] = new int[n][n];
		for(int i =0; i < n; i++) {
			getCoFactor(a, temp, 0, i, n);
			d += sign * a[0][i] * determinant(temp, n - 1);

			sign = -sign;
		}

		return d;
	}

	public static void getCoFactor(int a[][], int temp[][], int p, int q, int n) {
		int row = 0, col= 0;
		for(int i = 0; i < n; ++i) { 
			for(int j = 0; j < n ; j++) {
				if(i != p && j != q) {
					temp[row][col++] = a[i][j];
					if(col == n - 1) {
						row++;
						col = 0;
					}
				}
			}
		}
	}

	private static void display(int[][] a) {
		for(int i =0 ;i < a.length; ++i) {
			for(int j = 0; j < a[i].length;  j++) {
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
