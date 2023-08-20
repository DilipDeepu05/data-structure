package com.dsu.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInStream {

    public static void main(String[] args)
    {
        int n = 6;
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        int k = 4;
 
        // Function call
        int[] v = kthLargest(k, arr, n);
        for (int it : v)
            System.out.print(it + " ");
    }

	private static int[] kthLargest(int k, int[] arr, int n) {
		Queue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
		
		for(int i = 0 ; i < arr.length; ++i) {
			if(q.size() < k) {
				q.add(arr[i]);
			} else {
				if(arr[i] > q.peek()) {
					q.remove();
					q.add(arr[i]);
				}
			}
			
			if(i < k) {
				arr[i] = -1;
			} else {
				arr[i] = q.peek();
			}
		}
		return arr;
	}
}
