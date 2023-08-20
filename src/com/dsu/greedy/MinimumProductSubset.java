package com.dsu.greedy;

public class MinimumProductSubset {

	public static void main(String[] args) {

		int[] a = { -1, -1, -2, 4, 3 };
		int n = 5;

		System.out.println(minProductSubset(a, n));
	}

	private static int minProductSubset(int[] a, int n) {
		int pmin = Integer.MAX_VALUE;
		int nmin = Integer.MIN_VALUE;
		int zc =0, nv = 0, p =1;
		
		for(int i =0; i < n ; i++) {
			if(a[i] == 0) {
				zc++;
				continue;
			}
			
			if(a[i] < 0)  {
				nv++;
				nmin = Math.max(nmin, a[i]);
			}
			
			if(a[i] > 0 && a[i] < pmin) {
				pmin = a[i];
			}
	 
			p *= a[i];
		}
		
		if(nv == 0 || zc == n) {
			return 0;
		}
		
		if(nv == 0) {
			return pmin;
		}
		
		if(nv!=0 && nv %2 == 0) {
			p /= nmin;
		}
		
		return p;
	}
}
