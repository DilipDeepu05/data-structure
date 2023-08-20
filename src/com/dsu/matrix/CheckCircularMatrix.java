package com.dsu.matrix;

public class CheckCircularMatrix {

	public static void main(String[] args) {
		int n = 4;
		int mat[][] = {{1, 2, 3, 4},
				{4, 1, 2, 3},
				{3, 4, 1, 2},
				{2, 3, 4, 1}
		};
		
		if (isPermutedMatrix(mat, n)) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}

	private static boolean isPermutedMatrix(int[][] mat, int n) {
		String str ="";
		for(int i=0; i < mat.length; i++) {
			str+= "-"+String.valueOf(mat[0][i]);
		}

		str = str+ str;
		String cur ="";
		for(int i =1 ; i < mat.length; i++) {
			cur ="";
			for(int j = 0; j < mat[i].length; j++) {
				cur += "-"+ String.valueOf(mat[i][j]);
			}
			System.out.println(str+ " "+ cur);
			if(cur.contains(str)) {
				return false;
			}
		}
		return true;
	}
}
