package com.dsu.dp;

public class BinomicalCoEfficient {

	public static void main(String[] args) {
		int n = 5, k = 2;
		System.out.printf("Value of C(%d, %d) is %d ", n, k, binomialCoeff(n, k));
		System.out.printf("Value of C(%d, %d) is %d ", n, k, binomialCoeffDp(n, k));
	}

	private static int binomialCoeffDp(int n, int k) {
		int a[] = new int[n + 1];
		a[0] = 1;
		for(int i = 1;i <= n; i++) {
			for(int j = Math.min(k, i); j >0; j--) {
				a[j] = a[j] + a[j-1];
			}
		}
		return a[k];
	}

	private static int binomialCoeff(int n, int k) {
		if(k > n) return 0;
		
		if(k == 0 || k == n) return 1;
		
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}
}
