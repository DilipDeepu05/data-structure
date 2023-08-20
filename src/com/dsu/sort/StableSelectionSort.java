package com.dsu.sort;

import java.util.Arrays;

public class StableSelectionSort {

	public static void main (String[] args)
    {
        int[] a = { 4, 5, 3, 2, 4, 1 };
        int n = a.length;
        stableSelectionSort(a, n);
        System.out.println(Arrays.toString(a));
    }

	private static void stableSelectionSort(int[] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			
			int key = arr[min];
			while(min > i) {
				System.out.println(min + " "+ (min - 1));
				arr[min] = arr[min - 1];
				min--;
			}
			arr[i] = key;
		}
		
	}
}
