package com.dsu.search;

public class BinarySearch {
	
	  public static void main(String args[])
	    {
	        BinarySearch ob = new BinarySearch();
	        int arr[] = { 2, 3, 4, 10, 40 };
	        int n = arr.length;
	        int x = 10;
	        int result = ob.binarySearch(arr, x);
	        if (result == -1)
	            System.out.println(
	                "Element is not present in array");
	        else
	            System.out.println("Element is present at "
	                               + "index " + result);
	    }

	private int binarySearch(int[] arr, int x) {
		int l = 0;
		int r = arr.length;
		int mid = 0;
		while(l <= r) {
			mid = l + (r-l) / 2;
			
			if(arr[mid] == x) {
				return mid;
			} else if(arr[mid] < x) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}
}
