package com.dsu.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String args[])
	{
		BubbleSort ob = new BubbleSort();
		int arr[] = { 5, 1, 4, 2, 8 };
		ob.bubbleSort1(arr, arr.length);
		System.out.println("Sorted array");
		System.out.println(Arrays.toString(arr));
	}

	private void bubbleSort1(int[] arr, int n) {
		boolean sorted = false;
		for(int i = 0; i < n - 1; i++) {
			if(arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				sorted = true;
			}
		}
		
		if(sorted) {
			bubbleSort1(arr, n);
		}
		
	}

	private void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length - 1; ++i) {
			for(int j = 0; j < arr.length - i - 1; ++j) {
				if(arr[j] > arr[j + 1]) {
					int temp = arr[j+1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
}
