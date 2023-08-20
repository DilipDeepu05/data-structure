package com.dsu.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divide1toNgroupsMiniumSum {

	public static void main (String[] args)
	{
		int n = 5;
		findTwoGroup(n);
	}

	private static void findTwoGroup(int n) {
		int s = n * (n + 1) / 2;
		s = s / 2;
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		for(int i = n; i > 0; i--) {
			if(s - i >= 0) {
				l1.add(i);
				s -=i;
			} else {
				l2.add(i);
			}
		}
		
		System.out.println(Arrays.asList(l1));
		System.out.println(Arrays.asList(l2));
	}
}
