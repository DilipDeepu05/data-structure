package com.dsu.sort;

import java.util.Arrays;

public class SelectionSort {
	
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(arr));
    }

	private void sort(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			int min=i;
			for(int j = i +1 ; j < arr.length; ++j) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		
	}
}
