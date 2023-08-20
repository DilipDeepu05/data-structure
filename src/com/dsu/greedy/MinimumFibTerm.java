package com.dsu.greedy;

import java.util.ArrayList;
import java.util.List;

public class MinimumFibTerm {

	public static void main (String[] args) {

		int k = 17;
		System.out.println(fibMinTerms(k));
	}

	private static int  fibMinTerms(int k) {
		List<Integer> ls = new ArrayList<>();
		fibSeries(ls, k);
		
		int i = ls.size() -1;
		int count =0;
		
		while(k >0) {
			count += k / ls.get(i);
			k = k % ls.get(i);
			i--;
		}
		
		return count;
	}

	private static void fibSeries(List<Integer> ls, int k) {
		int i = 3, d =0;
		ls.add(0);
		ls.add(1);
		ls.add(1);
		
		while(true) {
			d = ls.get(i -1 )+  ls.get(i -2);
			if(d > k) {
				return;
			}
			ls.add(d);
			i++;
		}
	}
}
