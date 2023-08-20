package com.dsu.dp;

public class NCrModp {

	public static void main(String args[])
	{
		int n = 10, r = 2, p = 13;
		System.out.println("Value of nCr % p is "+ nCrModp(n, r, p));
	}

	private static int nCrModp(int n, int r, int p) {
		if(r > n - r) {
			r = n -r;
		}
		
		int a[] = new int[n +1];
		a[0] = 1;
		
		for(int i = 1; i <= n ;i++) {
			for(int j = Math.min(i, r);j > 0 ; j--) {
				a[j] = (a[j] + a[j-1]) % p;
			}
		}
		return a[r];
	}
}
