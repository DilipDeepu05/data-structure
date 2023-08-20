package com.dsu.dp;

import java.util.Arrays;

public class UniquePathWithObstale {

	public static void main(String[] args)
	{
		int[][] A
		= { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(A));
	}

	private static int uniquePathsWithObstacles(int[][] a) {
		int r = a.length;
		int c = a[0].length;
		
		int[][]  path= new int[r][c];
		for(int i =0; i < r; i++) {
			Arrays.fill(path[i], -1);
		}
		
		return pathHelper(0, 0, r, c, a, path);
	}

	private static int pathHelper(int i, int j, int r, int c, int[][] a, int[][] path) {
		if(i == r || j == c) {
			return 0;
		} else if(a[i][j] == 1) {
			return 0;
		} else if( i == r - 1 && j == c -1) {
			return 1;
		} else if(path[i][j] != -1){
			return path[i][j];
		}else {
			return  path[i][j] = pathHelper(i + 1, j, r, c, a, path) + pathHelper(i, j + 1, r, c, a, path);
		}
	}
}
 