package com.dsu.heap;

public class ConvertMinHeapToMaxHeap {

	public static void main(String[] args)
	{
		// array representing Min Heap
		int arr[] = { 3, 5, 9, 6, 8, 20, 10, 12, 18, 9 };
		int N = arr.length;

		System.out.print("Min Heap array : ");
		printArray(arr, N);

		// Function call
		convertMaxHeap(arr, N);

		System.out.print("\nMax Heap array : ");
		printArray(arr, N);
	}

	private static void convertMaxHeap(int[] arr, int n) {
		for(int i = n -2 / 2; i >= 0; --i) {
			maxHeapify(arr, n, i);
		}
	}

	private static void maxHeapify(int[] arr, int n, int i) {
		int l = 2 * i +1;
		int r =  2 * i + 2;
		int largest = i;
		if(l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		
		if(r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		
		if(largest != i) {
			int t = arr[i];
			arr[i] = arr[largest];
			arr[largest] = t;
			maxHeapify(arr, n, largest);
		}
		
	}

	private static void printArray(int[] arr, int n) {
		for(int i: arr) {
			System.out.print(i+ " ");
		}
	}
}
