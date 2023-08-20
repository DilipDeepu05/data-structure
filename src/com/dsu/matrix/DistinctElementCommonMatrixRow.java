package com.dsu.matrix;

import java.util.HashMap;
import java.util.Map;

public class DistinctElementCommonMatrixRow {

	public static void main(String[] args)
	{
		int matrix[][] = { { 2, 1, 4, 3 },
				{ 1, 2, 3, 2 },
				{ 3, 6, 2, 3 },
				{ 5, 2, 5, 3 } };
		int n = 4;
		distinct(matrix, n);
	}

	private static void distinct(int[][] matrix, int n) {
		Map<Integer, Integer> m = new HashMap<>();

		for(int i = 0; i < n; i++) {
			m.put(matrix[0][i], 1);
		}

		for(int i =1; i < n; i++) {
			for(int j = 0 ; j < n ; j++) {
				if(m.get(matrix[i][j]) != null && m.get(matrix[i][j]) == i) {
					m.put(matrix[i][j], i + 1);

					if(i == n - 1) {
						System.out.println(matrix[i][j]);
					}
				}
			}
		}
	}
}
