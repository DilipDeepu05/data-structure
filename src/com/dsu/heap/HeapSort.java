package com.dsu.heap;

public class HeapSort {

	static void printArray(int arr[]) {
		int N = arr.length;

		for (int i = 0; i < N; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver's code
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int N = arr.length;

		// Function call
		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}

	private void sort(int[] arr) {
		int n = arr.length;

		for(int i = n / 2 -1; i >= 0; i--) {
			heapify(arr, n, i);
		}

		for(int i = n -1; i > 0; i--) {
			int t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;

			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i  + 2;

		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}

		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}

		if(largest != i) {
			int t = arr[largest];
			arr[largest] = arr[i];
			arr[i] = t;

			heapify(arr, n, largest);
		}
	}
}