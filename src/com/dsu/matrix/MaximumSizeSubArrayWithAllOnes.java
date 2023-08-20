package com.dsu.matrix;

public class MaximumSizeSubArrayWithAllOnes {

	static int R = 6;
	static int C = 5;

	public static void main(String[] args)
	{
		int M[][]
				= { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 },
						{ 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 },
						{ 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 } };

		printMaxSubSquare(M);
	}

	private static void printMaxSubSquare(int[][] m) {
		int s[][] = new int[2][C];
		int max =0;
		for(int i =0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				int e = m[i][j];
				if(e != 0) {
					if( j!=0) {
						e = 1 + Math.min(s[1][j-1],Math.min(s[0][j-1], s[1][j]));
					} 
				}

				s[0][j] = s[1][j];
				s[1][j] = e;

				max = Math.max(max,e);
			}
		}
		System.out.println(max);
	}
}
