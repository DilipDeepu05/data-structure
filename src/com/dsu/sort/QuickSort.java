package com.dsu.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args)
	{
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int N = arr.length;

		// Function call
		quickSort(arr, 0, N - 1);
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int l, int r) {
		if(l < r) {
			int n = partitation(arr, l , r);

			quickSort(arr, l, n - 1);
			quickSort(arr, n + 1, r);
		}
	}

	private static int partitation(int[] arr, int l, int r) {
		int pivot = arr[r];
		int i = l - 1;
		
		for(int j = l; j < r; ++j) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		
		swap(arr, i+1, r);
		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}
