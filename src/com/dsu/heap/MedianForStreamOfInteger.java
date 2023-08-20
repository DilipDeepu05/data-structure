package com.dsu.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianForStreamOfInteger {

	public static void main(String[] args) {
		int A[] = { 5, 15, 10, 20, 3};
		int N = A.length;

		streamMed(A, N);
		System.out.println();
		printMedian(A);
	}

	private static void printMedian(int[] arr) {
		int m = arr[0];
		PriorityQueue<Integer> s = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> l = new PriorityQueue<>();

		s.add(arr[0]);

		System.out.println(m+ " ");

		for(int i = 1; i < arr.length; ++i) {
			int x = arr[i];

			if(s.size() > l.size()) {
				if(x < m) {
					l.add(s.remove());
					s.add(x);
				} else {
					l.add(x);
				}
				m = (l.peek() + s.peek())  / 2;
			} else if(s.size() == l.size()) {
				if(x < m) {
					s.add(x);
					m = s.peek();
				} else {
					l.add(x);
					m = l.peek();
				}
			} else {
				if(x > m) {
					s.add(l.remove());
					l.add(x);
				} else {
					s.add(x);
				}
				m = (l.peek() + s.peek())  / 2;
			}
			System.out.println(m+ " ");
		}
	}

	private static void streamMed(int[] a, int n) {
		PriorityQueue<Double> q1 = new PriorityQueue<>();
		PriorityQueue<Double> q2 = new PriorityQueue<>();

		for(int i: a) {
			q1.add(-1.0 * i);
			q2.add(-1.0 * q1.poll());
			if(q2.size() != q1.size()) {
				q1.add(-1.0 * q2.poll());
			}

			if(q1.size() != q2.size()) {
				System.out.println(-1.0* q1.peek());
			} else {
				System.out.println((q2.peek() - q1.peek()) / 2); 
			}
		}
	}
}
