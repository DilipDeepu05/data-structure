package com.dsu.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

class Pair {
	public Pair(int i, int j) {
		first = i;
		last = j;
	}
	int first;
	int last;
}
public class MinSwap {
		
	   public static void main(String args[])
	    {
	        int a[] = { 5, 6, 7, 8, 9, 10, 11 };
	        int n = a.length;
	         
	        Vector<Integer> v = new Vector<Integer>();
	 
	        inorder(a, v, n, 0);
	 
	        System.out.println(minSwaps(v));
	    }

	private static int minSwaps(Vector<Integer> v) {
		List<Pair> ls = new ArrayList<>();
		
		for(int i = 0; i < v.size(); i++) {
			ls.add(new Pair(v.get(i), i));
		}
		
		ls.sort(new Comparator<Pair>() {
			 @Override
	            public int compare(Pair o1, Pair o2)
	            {
	                return o1.first - o2.first;
	           }
		});
		
		Boolean vis[] = new Boolean[v.size()];
		Arrays.fill(vis, false);
		
		int count = 0;
		for(int i = 0; i < v.size(); ++i) {
			if(Boolean.TRUE.equals(vis[i])  || ls.get(i).first  == i) {
				continue;
			}
			int cycleGap = 0;
			int j = i;
			while(Boolean.FALSE.equals(vis[j])) {
				vis[j] = true;
				j = ls.get(j).last;
				cycleGap++;
			}
			
			if(cycleGap > 0) {
				count += cycleGap - 1;
			}
		}
		
		return count;
	}

	private static void inorder(int[] a, Vector<Integer> v, int end, int index) {
		if(index >= end) {
			return;
		}
		
		inorder(a, v, end, 2 * index+1);
		v.add(a[index]);
		inorder(a, v, end, 2*index+2);
	}
}
