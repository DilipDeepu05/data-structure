package com.dsu.search;

public class InterpolationSearch {
	public static void main(String[] args)
    {
 
        // Array of items on which search will
        // be conducted.
        int arr[] = { 10, 12, 13, 16, 18, 19, 20, 21,
                      22, 23, 24, 33, 35, 42, 47 };
 
        int n = arr.length;
 
        // Element to be searched
        int x = 18;
        int index = interpolationSearch(arr, 0, n - 1, x);
 
        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                               + index);
        else
            System.out.println("Element not found.");
        
        x = 20;
        index = interpolationSearch1(arr, 0, n - 1, x);
 
        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                               + index);
        else
            System.out.println("Element not found.");
    }

	private static int interpolationSearch1(int[] arr, int l, int r, int x) {
		if(l <= r && x > arr[l] && x < arr[r]) {
			int pos = l + (r - l)/(arr[r] - arr[l]);
			if(arr[pos] == x) {
				return pos;
			} else if(arr[pos] > x) {
				interpolationSearch1(arr, l, pos - 1, x);
			} else {
				interpolationSearch1(arr, pos + 1, r, x);
			}
		}
		return -1;
	}

	private static int interpolationSearch(int[] arr, int l, int r, int x) {
		
		while(l <= r) {
			int pos  = l + (r -1)/(arr[r] - arr[l]);
			
			if(arr[pos] == x) {
				return pos;
			} else if(x < arr[pos]) {
				r = pos - 1;
			} else {
				l = pos + 1;
			}
		}
		return -1;
	}
}