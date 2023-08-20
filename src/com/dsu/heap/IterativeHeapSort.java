package com.dsu.heap;

public class IterativeHeapSort {

	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver program
	public static void main(String args[]) {
		int arr[] = {10, 20, 15, 17, 9, 21};
		int n = arr.length;

		System.out.print("Given array: ");
		printArray(arr);

		heapSort(arr, n);

		System.out.print("Sorted array: ");
		printArray(arr);
	}

	private static void heapSort(int[] arr, int n) {
		buildHeap(arr, n);

		for(int i = n - 1 ; i > 0 ; i--) {
			swap(arr, i, 0);

			int j = 0 , index;

			do {
				index = 2 * j + 1;

				if(index < i - 1 && arr[index] < arr[index - 1]) 
					index++;

				if(index < i && arr[j]  < arr[index]) {
					swap(arr, j, index);
				}

				j = index;
			} while (index < i);
		}
	}

	private static void buildHeap(int[] arr, int n) {
		for(int i = 1 ; i <n; ++i) {
			if(arr[i] > arr[(i - 1) /2]) {
				int j = i;
				while(arr[j] > arr[(j - 1) /2]) {
					swap(arr, j, (j - 1)/2);
					j = (j - 1) /2;
				}
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
}
