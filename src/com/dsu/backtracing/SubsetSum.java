package com.dsu.backtracing;

import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {

		int[] weights = {15, 22, 14, 26, 32, 9, 16, 8};
		int target = 53;
		int size = weights.length;
		generateSubsets(weights, size, target);
		System.out.println("Nodes generated " + n);
	}

	public static int n = 0;
	
	private static void generateSubsets(int[] weights, int size, int target) {
		int t[] = new int[size];
		
		Arrays.sort(weights);
		int sum = 0;
		for(int i = 0;i < weights.length; i++) {
			sum += weights[i];
		}
		
		if(weights[0] <= sum && target >= sum) {
			subsetUtil(weights, size, t, 0, 0, 0, target);
		}
	}

	private static void subsetUtil(int[] s, int size, int[] t, int tsize, int sum, int it, int target) {
		n++;
		if(target == sum) {
			printSubset(t, tsize);
			
			if(it+1 < size && sum - s[it] + s[it+1] <= target ) {
				subsetUtil(s, size, t, tsize - 1, sum - s[it], it + 1, target);
			}
			return;
		} else {
			if(it < size &&  sum + s[it]  <= target) {
				for(int i = it; i < size; i++) {
					t[tsize] = s[i];
					if((s[i] + sum) <= target) {
						subsetUtil(s, size, t, tsize + 1, sum + s[i], i + 1, target);
					}
				}
			}
		}
			
 	}

	static void printSubset(int[] A, int size){
		for(int i = 0; i < size; i++){
			System.out.print(" " + A[i]);
		}
		System.out.println();
	} 
}
