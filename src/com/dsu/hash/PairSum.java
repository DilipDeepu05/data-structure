package com.dsu.hash;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

	public static void main(String[] args)
	{
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}

	private static void printpairs(int[] arr, int n) {
		Set<Integer> s = new HashSet<>();
		
		for(int i: arr) {
			int a = n - i;
			
			if(s.contains(a)) {
				System.out.println("yes");
				return;
			} else {
				s.add(i);
			}
		}
		System.out.println("no");
	}
}
