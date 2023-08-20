package com.dsu.backtracing;

import java.util.Arrays;

public class EightQueens {

    static final int N = 8;
    
	public static void main(String[] args)
	{
		int[][] board = new int[N][N];
		if (!solveNQueens(board, 0))
			System.out.println("No solution found");
	}

	private static boolean solveNQueens(int[][] board, int col) {
		if(col == N) {
			for(int arr[]: board) {
				System.out.println(Arrays.toString(arr));
			}
			return true;
		}
		
		for(int i =0;i < N; i++) {
			if(isSafeInteger(board, i, col)) {
				board[i][col] = 1;
				if(solveNQueens(board, col+1)) return true;
				board[i][col] = 0;
			}
		}
		
		return false;
	}

	private static boolean isSafeInteger(int[][] board, int x, int y) {
		for(int i =0;i < y; i++) {
			if(board[x][i] == 1) return false;
		}
		
		for(int i =x, j = y; i >=0 && j >= 0; i--,j--) {
			if(board[i][j] == 1) return false;
		}
		
		for(int i =x, j = y; i < N && j >=0; i++, j--) {
			if(board[i][j] == 1) return false;
		}
		return true;
	}
}
