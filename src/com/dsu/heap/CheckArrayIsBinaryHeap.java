package com.dsu.heap;

public class CheckArrayIsBinaryHeap {

	public static void main(String[] args) {
		int arr[] = {90, 15, 10, 7, 12, 2, 7, 3};
		int n = arr.length;
		
		if (isHeap(arr, n)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private static boolean isHeap(int[] arr, int n) {
		
		for(int i = 0; i < (n - 2)/2; i++) {
			
			if( (2 * i + 1) < n && arr[2 * i + 1] > arr[i]) {
				return false;
			}
			
			if((2 * i + 2 < n) && arr[2 * i + 2] > arr[i]) {
				return false;
			}
		}
		
		return true;
	}
}
