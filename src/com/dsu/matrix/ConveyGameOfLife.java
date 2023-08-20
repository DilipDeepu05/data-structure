package com.dsu.matrix;

public class ConveyGameOfLife {

	public static void main(String[] args) {
		int M = 10, N = 10;

		// Initializing the grid.
		int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
		};

		// Displaying the grid
		System.out.println("Original Generation");
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		nextGeneration(grid, M, N);
	}

	private static void nextGeneration(int[][] grid, int m, int n) {
		// TODO Auto-generated method stub
		int future[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j =0; j < n; j++) {

				int alive = 0;
				for(int l = -1; l <=1; l++) {
					for(int k = -1; k <=1 ; k++) {
						if((l+i > 0 && l+i < m) && (k+j > 0 && k+j < n)) {
							alive += grid[l+i][k+j];
						}
					}
				}

				alive -= grid[i][j];

				if((grid[i][j] == 1) && (alive < 2))
					future[i][j] =0;
				else if((grid[i][j] == 1) && (alive > 3))
					future[i][j] = 0;
				else if((grid[i][j] == 0) && (alive == 3))
					future[i][j] = 1;
				else 
					future[i][j] = grid[i][j];
			}
		}

		System.out.println("next Generation");
		for (int i = 0; i < m; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if (future[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("*");
			}
			System.out.println();
		}
	}
}