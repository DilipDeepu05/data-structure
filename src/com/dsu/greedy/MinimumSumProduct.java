package com.dsu.greedy;

public class MinimumSumProduct {

	public static void main(String[] args)
	{
		int a[] = { 2, 3, 4, 5, 4 };
		int b[] = { 3, 4, 2, 3, 2 };
		int n = 5, k = 3;
		System.out.println(minproduct(a, b, n, k));
	}

	private static int minproduct(int[] a, int[] b, int n, int k) {
		int diff = 0, res =0, temp = 0;
		
		for(int i =0;i < n; i++) {
			int pro = a[i] * b[i];
			res +=pro;
			
			if(pro < 0 && b[i] < 0) {
				temp = (a[i] + 2 * k) * b[i];
			} else if(pro < 0 && a[i] < 0) {
				temp = (a[i] - 2 * k) * b[i];
			} else if(pro > 0  && a[i] < 0) {
				temp = (a[i]  + 2 * k) * b[i];
			} else if(pro > 0 && a[i] >0) {
				temp = (a[i] - 2 * k) * b[i];
			}
			
			int d = Math.abs(pro - temp);
			if(diff < d) {
				diff = d;
			}
		}
		return res - diff;
	}
}
