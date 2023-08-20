package com.dsu.search;

public class JumpSearch {

    public static void main(String [ ] args)
    {
        int arr[] = { 0, 1, 1, 2, 3, 5, 8, 13, 21,
                    34, 55, 89, 144, 233, 377, 610};
        int x = 610;
 
        // Find the index of 'x' using Jump Search
        int index = jumpSearch(arr, x);
 
        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                            " is at index " + index);
    }

	private static int jumpSearch(int[] arr, int x) {
		int n = arr.length;
		int step = (int) Math.floor(Math.sqrt(n));
		int prev = 0;
		for(int i = step - 1; arr[i] < x; i = step - 1) {
			prev = step;
			step += Math.floor(Math.sqrt(n));
			
			if(step > n) {
				return -1;
			}
		}
		
		while(arr[prev] < x) {
			prev++;
		}
		
		if(arr[prev] == x) {
			return prev;
		}
		return -1;
	}
}
