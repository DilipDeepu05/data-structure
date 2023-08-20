package com.dsu.search;

public class TernarySearch {

	 public static void main(String args[])
	    {
	        int l, r, p, key;
	 
	        // Get the array
	        // Sort the array if not sorted
	        int ar[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	 
	        // Starting index
	        l = 0;
	 
	        // end element index
	        r = 9;
	 
	        // Checking for 5
	 
	        // Key to be searched in the array
	        key = 5;
	 
	        // Search the key using ternarySearch
	        p = ternarySearch(l, r, key, ar);
	 
	        // Print the result
	        System.out.println("Index of " + key + " is " + p);
	 
	        // Checking for 50
	 
	        // Key to be searched in the array
	        key = 50;
	 
	        // Search the key using ternarySearch
	        p = ternarySearch1(l, r, key, ar);
	 
	        // Print the result
	        System.out.println("Index of " + key + " is " + p);
	    }

	private static int ternarySearch1(int l, int r, int key, int[] arr) {
		if(l <= r) {
			int mid1 = l + (r-l)/3;
			int mid2 = r - (r-l)/3;
			if(arr[mid1] == key) {
				return mid1;
			} else if( arr[mid2] == key) {
				return mid2;
			}
			
			if(key < arr[mid1]) {
				ternarySearch1(l, mid1 - 1, key, arr);
			} else if(key > arr[mid2]) {
				ternarySearch1(mid2 + 1, r, key, arr);
			} else {
				ternarySearch1(mid1 + 1, mid2 - 1, key, arr);
			}
		}
		return -1;
	}

	private static int ternarySearch(int l, int r, int key, int[] arr) {
		while(l <=  r) {
			int mid1 = l + (r-l) / 3;
			int mid2 = r - (r-l)/3;
			
			if(arr[mid1] == key) {
				return mid1;
			} else if(arr[mid2] == key) {
				return mid2;
			}
			
			if(key < arr[mid1]) {
				r = mid1 - 1;
			} else if(key >  arr[mid2]) {
				l = mid2 + 1;
			} else {
				l = mid1 + 1;
				r = mid2 - 1;
			}
		}
		return -1;
	}
}
