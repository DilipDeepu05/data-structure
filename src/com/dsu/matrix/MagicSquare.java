package com.dsu.matrix;

public class MagicSquare {

	public static void main(String[] args)
	{
		// Works only when n is odd
		int n = 7;
		generateSquare(n);
	}

	private static void generateSquare(int n) {
		int i = n /2;
		int j = n - 1;

		int res [][] = new int [n][n];
		for(int num = 1; num <= n * n; ) {
			if(i == -1 && j == n) {
				i = 0;
				j = n - 2;
			} else {
				if(j == n) {
					j = 0;
				} 

				if(i < 0) {
					i = n - 1;
				}
			}

			if(res[i][j] != 0) {
				j -= 2;
				i++;
				continue;
			} else {
				res[i][j] = num++;
			}

			j++;
			i--;
		}

		System.out.println((n * (n *n + 1))/ 2);

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
}
