package com.dsu.search;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ExponentialSearch {

	public static void main(String[] args) {
	    ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(2, 3, 4, 10, 40));
	    int n = arr.size();
	    int x = 10;
	    int result = exponential_search(arr, x);
	     
	    if (result == -1) {
	        System.out.println("Element not found in the array");
	    }
	    else {
	        System.out.println("Element is present at index " + result);
	    }
	    
	    x = 40;
	    result = exponential_search1(arr, x);
	     
	    if (result == -1) {
	        System.out.println("Element not found in the array");
	    }
	    else {
	        System.out.println("Element is present at index " + result);
	    }
	}

	private static int exponential_search1(ArrayList<Integer> arr, int x) {
		int n = arr.size();
		if(arr.get(0) == x) {
			return 0;
		}
		int i = 1;
		while(i < n && arr.get(i) < x) {
			i *= 2;
		}
		
		return Arrays.binarySearch(arr.toArray(new Integer[arr.size()]), i/2, Math.min(i, n-1), x);
	}

	private static int exponential_search(ArrayList<Integer> arr, int x) {
		
		int n = arr.size();
		
		int i = 1;
		
		while( i < n && arr.get(i) < x) {
			i *=2;
		}
		
		int l = i/2;
		int r = Math.min(i, n -1);
		
		while( l <= r) {
			int mid = (l + r) / 2;
			
			if(arr.get(mid) == x) {
				return mid;
			} else if (arr.get(mid) > x) {
				r = mid -1;
			} else {
				l = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	
}
