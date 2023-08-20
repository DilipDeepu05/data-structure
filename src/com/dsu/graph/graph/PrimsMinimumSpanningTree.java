package com.dsu.graph;

import java.util.Arrays;

public class PrimsMinimumSpanningTree {

	private static final int V = 5;

	public static void main(String[] args)
	{
		PrimsMinimumSpanningTree t = new PrimsMinimumSpanningTree();
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
			{ 2, 0, 3, 8, 5 },
			{ 0, 3, 0, 0, 7 },
			{ 6, 8, 0, 0, 9 },
			{ 0, 5, 7, 9, 0 } };

			// Print the solution
			t.primMST(graph);
	}

	private void primMST(int[][] graph) {
		boolean mset[] = new boolean[V];

		int parent[] = new int[V];
		int key[] = new int[V];
		Arrays.fill(key, Integer.MAX_VALUE);
		
		key[0] = 0;
		parent[0] = -1;
		for(int i =0; i < V -1; i++) {
			int d = minDistance(key, mset);

			mset[d] = true;
			for(int j =0; j < V; j++) {
				if( graph[d][j]  != 0 && !mset[j] && graph[d][j] < key[j]) {
					key[j] = graph[d][j];
					parent[j] = d;
				}
			}	
		}

		printMST(parent, graph);
	}

	void printMST(int parent[], int graph[][])
	{
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t"
					+ graph[i][parent[i]]);
	}

	private int minDistance(int[] key, boolean[] mset) {
		int min = Integer.MAX_VALUE, minIndex = -1;
		for(int i =0; i < V; i++) {
			if(!mset[i] && key[i] < min) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
