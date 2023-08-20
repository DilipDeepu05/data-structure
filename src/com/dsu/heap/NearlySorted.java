package com.dsu.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NearlySorted {

	public static void main(String[] args)
	{
		List<Integer> arr = new ArrayList<>(List.of(
				3, 3, 2, 1, 6, 4, 4, 5, 9, 7, 8, 11, 12));
		int k = 3;
		int N = arr.size();

		System.out.println("Array before K sort\n");
		System.out.println(arr);
		System.out.println("\n");

		ksorter(arr, 0, N - 1, k);

		System.out.println("Array after K sort\n");
		System.out.println(arr);
	}

	private static void ksorter(List<Integer> arr, int start, int h, int end) {
		if(start < h) {
			int  p = sort(arr, start, h, end);
			sort(arr, start, p - 1, end);
			sort(arr, p + 1, h, end);
		}
	}

	private static int sort(List<Integer> arr, int start, int h, int k) {
		int m = start + (h - start)/ 2;
		int l = Math.max(start, m - k), j = l;
		int r  = Math.min((m + k), h);

		Collections.swap(arr, r, m);

		while( j < r) {
			if(arr.get(j) < arr.get(r)) {
				Collections.swap(arr, j, l++);
			}
			j++;
		}
		
		Collections.swap(arr, r, l);
		return l;
	}
}
