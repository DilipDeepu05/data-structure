package com.dsu.hash;

public class FindRepeating {

	static int findRepeating(int arr[], int N) {

		// res is going to store value of
		// 1 ^ 2 ^ 3 .. ^ (N-1) ^ arr[0] ^
		// arr[1] ^ .... arr[n-1]
		int res = 0;
		for (int i = 0; i < N - 1; i++) {
			res = res ^ (i + 1) ^ arr[i];
		}	        	
		res = res ^ arr[N - 1];
		System.out.print(res+ " ");
		return res;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 9, 8, 26, 6, 26, 1, 25, 3, 4, 27 };
		int N = arr.length;

		// Function call
		System.out.println(findRepeating(arr, N));
		System.out.println(findRepeating1(arr, N));
	}

	private static int findRepeating1(int[] arr, int n) {
		for(int i = 0 ; i < arr.length; i++) {
			int in = Math.abs(arr[i]);
			int ele = arr[in];
			if(ele < 0) {
				System.out.print("found");
				return in;
			}
			arr[ele] = -arr[ele];
		}
		return -1;
	}
}
