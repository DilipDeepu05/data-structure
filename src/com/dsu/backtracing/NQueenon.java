package com.dsu.backtracing;

public class NQueenon {
	static int max =10;
	static int arr[] = new int[max];
	public static void main(String[] args)
    {
        int n = 4;
        nQueens(1, n);
    }

	private static void nQueens(int k, int n) {
		for(int i = 1; i <= n ;i++) {
			if(canPlace(k, i)) { 
				arr[k] = i;
				if(k == n) {
					display();
				} else {
					nQueens(k+1, n);
				}
			}
		}
	}

	private static void display() {
		for(int i=1;i <= 4; i++) {
			for(int j =1;j<=4; j++) {
				if(arr[j] !=i) {
					System.out.print(" _ ");
				} else {
					System.out.print(" Q ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean canPlace(int k, int n) {
		for(int i =0;i<=k-1; i++) {
			if(arr[i] == n || Math.abs(arr[i] - n) == Math.abs(i - k)) {
				return false;
			}
		}
		return true;
	}
}
