package com.dsu.divideandconquer;

public class MaxMinArray {
	public static void main(String[] args)
	{
	     
	    // Defining the variables
	    int min, max;
	 
	    // Initializing the array
	    int a[] = { 70, 250, 50, 80, 140, 12, 14 };
	 
	    // Recursion - DAC_Max function called
	    max = DAC_Max(a, 0, 7);
	 
	    // Recursion - DAC_Max function called
	    min = DAC_Min(a, 0, 7);
	     
	    System.out.printf("The minimum number in " +
	                      "a given array is : %d\n", min);
	    System.out.printf("The maximum number in " +
	                      "a given array is : %d", max);
	}

	private static int DAC_Min(int[] a, int i, int j) {
		if(j - 1 == 0) {
			return a[j];
		} else if (i >= j - 2) {
			System.out.println("loop");
			if(a[i] < a[i + 1]) {
				return a[i];
			} else {
				return a[i + 1];
			}
		}
		
		int min = DAC_Min(a, i+ 1, j);
		if(a[i] < min) {
			return a[i];
		} 

		return min;
	}

	private static int DAC_Max(int[] a, int i, int j) {
		if(j - 1 == 0) {
			return a[j];
		} else if(i >= j - 2) {
			if(a[i] > a[i + 1]) {
				return a[i];
			} else {
				return a[i + 1];
			}
		}
	
		int max = DAC_Max(a, i+1, j);

		if(a[i] > max) {
			return a[i];
		} else {
			return max;
		}
	}
}
