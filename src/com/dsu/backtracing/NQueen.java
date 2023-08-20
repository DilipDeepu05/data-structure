package com.dsu.backtracing;

public class NQueen {
	
	static int  n = 4;
	
	static int ld[] = new int[30];
	static int rd[] = new int[30];
	static int cl[] = new int[30];
	
	static boolean solveNQ()
	{
		int board[][] = { { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };

		if (solveNQUtil(board, 0) == false) {
			System.out.printf("Solution does not exist");
			return false;
		}

		print(board);
		return true;
	}

	private static boolean solveNQUtil(int[][] board, int c) {
		if(c>= n)  {
			return true;
		}
		
		for(int i =0; i < n; i++) {
			if(ld[i - c + n -1] != 1 && rd[i + c] != 1 && cl[i] != 1) {
				
				ld[i - c + n -1] = rd[i+c] = cl[i] = 1;
				board[i][c] = 1;
				if(solveNQUtil(board, c+1)) {
					return true;
				}
				
				ld[i - c + n -1] = rd[i+c] = cl[i] = 0;
				board[i][c] = 0;
			}
		}
		return false;
	}

	private static void print(int[][] sol) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(
						" " + sol[i][j] + " ");
			System.out.println();
		}
	}
	// Driver Code
	public static void main(String[] args)
	{
		solveNQ();
	}
}
