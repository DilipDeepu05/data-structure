package com.dsu.greedy;

import java.util.Arrays;

public class MinimumDiffBetweenTwoGroup {

	public static void main(String[] args) {
        int[] a = { 2, 6, 4, 3 };
        int n = a.length;
 
        System.out.print(calculate(a, n));
    }

	private static int calculate(int[] a, int n) {
		Arrays.sort(a);
		int max = a[0] + a[n -1];
		int min = a[0] + a[n -1];
		
		for(int i =0, j = n-1;i < n && j >= 0; i++, j--) {
			if(a[i] + a[j] > max) {
				max = a[i] + a[j];
			} else if(a[i] + a[j] < min) {
				min = a[i] + a[j];
			}
		}
		return Math.abs(max - min);
	}
}
