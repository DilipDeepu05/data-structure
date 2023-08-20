package com.dsu.hash;

public class FrequentElementArray {

	public static void main (String[] args) {
	    int arr[] = {40,50,30,40,50,30,60, 10, 20, 30, 10};
	    int n = arr.length;
	    int freq =  maxFreq(arr , n);
	    int count = 0;
	    for(int i = 0; i < n; i++) {
	        if(arr[i] == freq) {
	            count++;
	        }
	    }
	    System.out.println("Element " +maxFreq(arr , n) +" occurs "  +count +" times" ); 
	}

	private static int maxFreq(int[] arr, int n) {
		int res = 0;
		int count = 1;
		for(int i = 1 ; i < n; ++i) {
			if(arr[i] == arr[res]) {
				count++;
			} else {
				count--;
			}
			
			if(count == 0) {
				res = i;
				count = 1;
			}
		}
		return arr[res];
	}
}
