package com.dsu.matrix;

public class QueryMatrix {

	public static void main(String[] args)
	{
		int m = 1234, n = 5678;

		// row[] is array for rows and cols[]
		// is array for columns
		int rows[] = new int[m], cols[] = new int[n];

		// Fill initial values in rows[] and cols[]
		preprocessMatrix(rows, cols, m, n);

		queryMatrix(rows, cols, m, n, 'R', 1, 2);
		queryMatrix(rows, cols, m, n, 'P', 1, 1);
		queryMatrix(rows, cols, m, n, 'P', 2, 1);
		queryMatrix(rows, cols, m, n, 'C', 1, 2);
		queryMatrix(rows, cols, m, n, 'P', 1, 1);
		queryMatrix(rows, cols, m, n, 'P', 2, 1);
	}

	private static void queryMatrix(int[] rows, int[] cols, int m, int n, char c, int i, int j) {
		switch(c) {
		case 'R': 
			swap(rows,  i - 1, j - 1); 
			break;
		case 'C':
			swap(cols, i - 1, j - 1);
			break;
		case 'P':
			System.out.printf("Values (%d, %d) =%d\n", i,j,rows[i-1] * n+ cols[j-1] + 1);
		}

	}

	private static void swap(int[] rows, int i, int j) {
		int t = rows[i];
		rows[i] = rows[j];
		rows[j] = t;
	}

	private static void preprocessMatrix(int[] rows, int[] cols, int m, int n) {
		for(int i =0; i < m; i++) {
			rows[i] = i;
		}

		for(int i =0 ; i < n ;i++) {
			cols[i] = i;
		}
	}
}
