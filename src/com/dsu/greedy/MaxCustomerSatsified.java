package com.dsu.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxCustomerSatsified {

	static class Pair {
		int f;
		int s;
		Pair(int f, int s) {
			this.f = f;
			this.s = s;
		}
	}
	
	public static void main(String[] args)
	{
		int n = 5;
		long d = 5;
		int a = 1, b = 1;
		int arr[][] = { { 2, 0 },
				{ 3, 2 },
				{ 4, 4 },
				{ 10, 0 },
				{ 0, 1 } };

		solve(n, d, a, b, arr);
	}

	private static void solve(int n, long d, int a, int b, int[][] arr) {
		List<Pair> ls = new ArrayList<>();
		
		for(int i =0; i < arr.length; i++) {
			ls.add(new Pair((a * arr[i][0] + b * arr[i][1]), i+1));
		}
		
		Collections.sort(ls, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.f - o2.f;
			}
		});
		
		List<Integer> l = new ArrayList<>();
		for(Pair p: ls) {
			if(p.f <= d) {
				l.add(p.s);
				d -= p.f;
			}
		}
		
		System.out.println(Arrays.asList(l));
	}
}
