package com.dsu.backtracing;

public class RatMaze {
	static int n;

	public static void main(String args[])
	{
		RatMaze rat = new RatMaze();
		int maze[][] = { { 1, 0, 0, 0 },
				{ 1, 1, 0, 1 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 1 } };

		n = maze.length;
		rat.solveMaze(maze);
	}

	private void solveMaze(int[][] maze) {
		int sol[][] = new int[n][n];

		if(!solveUtil(maze, 0, 0, sol)) {
			  System.out.print("Solution doesn't exist");
			return;
		}

		print(sol);
	}

	private void print(int[][] sol) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(
						" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	private boolean solveUtil(int[][] maze, int x, int y, int[][] sol) {
		if(x == n -1 && y == n -1 && maze[x][y] == 1 && sol[x][y] == 1) 
			return true;

		if(isSafeInteger(maze, x, y))  {
			if(sol[x][y] == 1) {
				return false;
			}

			sol[x][y] = 1;
			if(solveUtil(maze, x +1 , y, sol)) return true;
			if(solveUtil(maze, x, y+1, sol)) return true;

			sol[x][y]=0;
			return false;
		}
		return false;
	}

	private boolean isSafeInteger(int[][] maze, int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y <n && maze[x][y] == 1) ;
	}
}
