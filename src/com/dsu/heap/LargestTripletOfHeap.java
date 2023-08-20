package com.dsu.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LargestTripletOfHeap {

	public static void main(String[] args)
	{
		int arr[] = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		LargestTripletMultiplication(arr, n);
	}

	private static void LargestTripletMultiplication(int[] arr, int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = 0 ; i < arr.length ; ++i) {
			q.add(arr[i]);
			if(q.size() < 3) {
				System.out.print("-1 ");
			} else {
				int x = q.poll();
				int y = q.poll();
				int z = q.poll();
				System.out.print(x*y*z+" ");
				q.add(x);
				q.add(y);
				q.add(z);
			}
		}
	}
}
