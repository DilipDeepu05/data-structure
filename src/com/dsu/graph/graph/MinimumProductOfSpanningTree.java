package com.dsu.graph;

import java.util.Arrays;

public class MinimumProductOfSpanningTree {

	static int v = 5;

	public static void main(String[] args)
	{
		/* Let us create the following graph
	        2 3
	    (0)--(1)--(2)
	        | / \ |
	    6| 8/ \5 |7
	        | /     \ |
	    (3)-------(4)
	            9         */
		int graph[][] = {
				{ 0, 2, 0, 6, 0 },
				{ 2, 0, 3, 8, 5 },
				{ 0, 3, 0, 0, 7 },
				{ 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 },
		};

		// Print the solution
		minimumProductMST(graph);
	}

	private static void minimumProductMST(int[][] graph) {
		double log[][] = new double[v][v];

		for(int i =0; i < v; i++) {
			for(int j =0; j < v; j++) {
				if(graph[i][j] > 0) {
					log[i][j] = Math.log(graph[i][j]);
				} else {
					log[i][j] = 0; 
				}
			}
		}

		printMST(log, graph);
	}

	private static void printMST(double[][] log,  int[][]graph) {
		double key[]= new double[v];
		int parent [] = new int[v];
		boolean mset[]= new boolean[v];
		Arrays.fill(key, Integer.MAX_VALUE);

		key[0] = 0;
		parent[0] = -1;

		for(int i =0 ; i < v  - 1; i++) {
			int d = (int) minIndex(key, mset);
			mset[d] = true;

			mset[d] = true;
			for(int j =0; j < v; j++) {
				if( log[d][j]  != 0 && !mset[j] && log[d][j] < key[j]) {
					key[j] = log[d][j];
					parent[j] = d;
				}
			}
		}

		print(graph, parent);
	}

	private static void print(int[][] graph, int[] parent) {
		int res= 1;
		for(int i =1; i < v; i++) {

			res = res * graph[i][parent[i]];

		}
		System.out.println(res);
	}

	private static double minIndex(double[] key, boolean[] mset) {
		double min = Integer.MAX_VALUE, minIn = -1d;

		for(int i =0; i< v; i++) {
			if(!mset[i] && key[i] < min) {
				min = key[i];
				minIn = i;
			}
		}
		return minIn;
	}
}
