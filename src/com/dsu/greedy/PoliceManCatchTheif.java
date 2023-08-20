package com.dsu.greedy;

import java.util.ArrayList;
import java.util.List;

public class PoliceManCatchTheif {

	public static void main(String args[])
	{
		int k, n;
		char arr1[]
				= new char[] { 'P', 'T', 'T', 'P', 'T' };
		k = 2;
		n = arr1.length;
		System.out.println("Maximum thieves caught: "
				+ policeThief(arr1, n, k));

		char arr2[]
				= new char[] { 'T', 'T', 'P', 'P', 'T', 'P' };
		k = 2;
		n = arr2.length;
		System.out.println("Maximum thieves caught: "
				+ policeThief(arr2, n, k));

		char arr3[]
				= new char[] { 'P', 'T', 'P', 'T', 'T', 'P' };
		k = 3;
		n = arr3.length;
		System.out.println("Maximum thieves caught: "
				+ policeThief(arr3, n, k));
	}

	private static int policeThief(char[] arr, int n, int k) {
		List<Integer> p = new ArrayList<>();
		List<Integer> t = new ArrayList<>();
		for(int i =0; i<arr.length; i++) {
			if(arr[i] == 'P') {
				p.add(i);
			} else {
				t.add(i);
			}
		}
		
		int res =0, l =0, r=0;
		while(l < p.size() && r < t.size()) {
			if(Math.abs( p.get(l) - t.get(r)) <= k) {
				l++;
				r++;
				res++;
			} else if(p.get(l) < t.get(r)) {
				l++;
			} else {
				r++;
			}
		}
		return res;
	}
}
