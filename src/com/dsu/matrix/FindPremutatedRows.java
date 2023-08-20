package com.dsu.matrix;

import java.util.Arrays;

public class FindPremutatedRows {

	public static void main(String[] args) {
		int m = 4, n = 4, r = 3;
		int[][] mat = { { 3, 1, 4, 2 },
				{ 1, 6, 9, 3 },
				{ 1, 2, 3, 4 },
				{ 4, 3, 2, 1 } };
		permutatedRows(mat, m, n, r);
	}

	private static void permutatedRows(int[][] mat, int m, int n, int r) {
		for(int i =0; i < m && i !=r; i++) {
			if(isPremutated(mat[i], mat[r])) {
				System.out.print(i+ " ");
			}
		}
	}

	private static boolean isPremutated(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);
		System.out.println(Arrays.toString(a)+ " "+ Arrays.toString(b));
		for(int i =0; i < b.length; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
}
