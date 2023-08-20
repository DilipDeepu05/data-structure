package com.dsu.stack;

import java.util.Arrays;

public class Histogram {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };

		System.out.println("Maximum area is "
				+ getMaxArea(hist, hist.length));
	}

	private static int getMaxArea(int[] hist, int n) {
		java.util.Stack<Integer> s = new java.util.Stack<>();
		
		s.push(-1);
		int l[] = new int[n];
		int r[] = new int[n];
		

		for(int i = 0; i < n; i++) {
			l[i] = -1;
			r[i] = n;
		}
		
		int i = 0;
		while(i < n) {
			while(!s.isEmpty() && s.peek() != -1 && hist[s.peek()] > hist[i]) {
				r[s.pop()] = i;
			}
			
			if(i > 0 && hist[i] == hist[i - 1]) {
				l[i] = l[i - 1];
			} else {
				l[i] = s.peek();
			}
			
			s.push(i);
			i++;
		}
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(r));
		int max = 0;
		for(i =0; i < n; i++) {
			max = Math.max(max, (r[i] - l[i] - 1) * hist[i]);
		}
		return max;
	}
}
