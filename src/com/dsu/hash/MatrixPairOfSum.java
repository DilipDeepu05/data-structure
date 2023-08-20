package com.dsu.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrixPairOfSum {

	public static void main(String[] args) {
		int n = 4, sum = 11; 
		int[][] mat = {{1, 3, 2, 4}, 
				{5, 8, 7, 6}, 
				{9, 10, 13, 11}, 
				{12, 0, 14, 15}}; 
		pairSum(mat, n, sum);
		System.out.println();
		pairSum1(mat, n, sum);
	}


	private static void pairSum1(int[][] mat, int n, int sum) {
	    for (int i = 0; i < n; i++)
	        Arrays.sort(mat[i]);
	    
		for(int i = 0; i < n - 1; ++i) {
			for(int j = i+ 1; j < n; j++) {
				int left = 0; int right = n -1;
				while(left < n && right >=0) {
					if(mat[i][left] + mat[j][right] == sum) {
						System.out.print(" (" + mat[i][left] + "  " +mat[j][right]+ ") ");
						left++;
						right--;
					} else {
						if(mat[i][left] + mat[j][right] < sum) {
							left++;
						} else {
							right--;
						}
					}
				}
			}
		}
	}


	private static void pairSum(int[][] mat, int n, int sum) {
		Map<Integer, List<Integer>> m = new HashMap<>();

		for(int i = 0 ;i < mat.length; i++) {
			for(int j = 0 ; j < mat.length; j++) {
				m.put(mat[i][j], new ArrayList<>(Arrays.asList(i, j)));
			}
		}

		for(int i = 0 ;i < mat.length; i++) {
			for(int j = 0 ; j < mat.length; j++) {
				int d = sum - mat[i][j];
				if(m.containsKey(d)) {

					List<Integer> p = m.get(d);
					int row = p.get(0), col = p.get(1);


					if (row != i && row > i) 
					{
						System.out.print("(" + mat[i][j] + "," + mat[row][col] + "), ");
					}
				}
			}
		}
	}
}