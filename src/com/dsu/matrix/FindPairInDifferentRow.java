package com.dsu.matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindPairInDifferentRow {

	public static void main (String[] args) {
		int n = 4, sum = 11; 
		int[][] mat = {{1, 3, 2, 4}, 
				{5, 8, 7, 6}, 
				{9, 10, 13, 11}, 
				{12, 0, 14, 15}}; 
		pairSum(mat, n, sum);
	}

	private static void pairSum(int[][] mat, int n, int sum) {
		Map<Integer, List<Integer>> m = new HashMap<>();

		for(int i = 0; i < n; i++) {
			for(int j =0; j < n; j++) {
				m.put(mat[i][j], List.of(i,j));
			}
		}

		for(int i =0 ;i < n; i++) {
			for(int j = 0; j < n ; j++) {
				int t = sum - mat[i][j];

				if(m.containsKey(t)) {
					if(i != m.get(t).get(0) && m.get(t).get(0) > i ) {
						System.out.println(mat[m.get(t).get(0)][m.get(t).get(1)]+ " "+ mat[i][j]);
					}
				}
			}
		}
	}
}