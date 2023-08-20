package com.dsu.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String args[])
	{
		int arr[] = { 12, 11, 13, 5, 6 };

		InsertionSort ob = new InsertionSort();
		ob.sort(arr);

		System.out.println(Arrays.toString(arr));
	}

	private void sort(int[] arr) {
		for(int i = 1; i < arr.length; ++i) {
			int key = arr[i];
			int j =  i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			System.out.println(Arrays.toString(arr));
			
			arr[j + 1] = key;
		}
	}
	
	
}
