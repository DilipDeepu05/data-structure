package com.dsu.greedy;

import java.util.PriorityQueue;

public class MinimumIncrementOrDecrementToMakeArrayNonIncreasing {

	public static void main(String[] args) {

		int[] a = {3, 1, 2, 1};
		int n = a.length;

		System.out.println(DecreasingArray(a, n));
	}

	private static int DecreasingArray(int[] a, int n) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int sum =0;
		for(int i =0 ; i < a.length; i++) {
			if(!q.isEmpty() &&  q.peek() < a[i]) {
				int diff = a[i] - q.peek();
				sum += diff;
				System.out.println(q.remove());
				q.add(a[i]);
			}
			q.add(a[i]);
		}
		return sum;
	}
}
