package com.dsu.matrix;

public class SearchInSortedMatrix {

	public static void main(String args[]) {
		int n = 4; // no. of rows
		int m = 5; // no. of columns

		int a[][] = { { 0, 6, 8, 9, 11 },
				{ 20, 22, 28, 29, 31 },
				{ 36, 38, 50, 61, 63 },
				{ 64, 66, 100, 122, 128 } };

		int k = 31; // element to search

		findRow(a, n, m, k);
	}

	private static void findRow(int[][] a, int n, int m, int k) {
		int l =0, r = n - 1, mid = 0;
		
		while(l <= r) {
			mid = (l + r)  / 2;
			
			if(k == a[mid][0]) {
				System.out.println("found at "+mid + " - 0");
				return;
			}
			if(k == a[mid][m - 1]) {
				System.out.println("found at "+mid + " - "+(m - 1));
				return;
			}
			
			if(k > a[mid][0] && k < a[mid][m - 1]) {
				binarySearch(a, n, m, k, mid);
				return;
			}
			
			if(k > a[mid][0]) {
				l = mid + 1;
			} else if(k < a[mid][m - 1]) {
				r = mid - 1;
			}
		}
	}

	private static void binarySearch(int[][] a, int n, int m, int k, int x) {
		int l =0, r = m - 1, mid = 0;
		
		while(l <= r) {
			mid = (l + r) / 2;
			
			if(k == a[x][mid]) {
				System.out.println("found at "+x + " - "+ mid);
			} else if( k > a[x][mid]) {
				l= mid + 1;
			} else {
				r = mid + 1;
			}
		}
	}
}
