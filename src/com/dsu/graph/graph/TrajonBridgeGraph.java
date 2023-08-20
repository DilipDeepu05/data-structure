package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrajonBridgeGraph {
	int v;
	List<Integer> [] ls;

	TrajonBridgeGraph(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String args[])
	{
		// Create graphs given in above diagrams
		System.out.println("Bridges in first graph ");
		TrajonBridgeGraph g1 = new TrajonBridgeGraph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.bridge();
		System.out.println();
	}

	static int time = 0;
	private void bridge() {
		boolean visited[] = new boolean[v];
		int disc[] = new int[v];
		int parent[] = new int[v];
		int low[] = new int[v];

		Arrays.fill(parent, -1);

		for(int i =0; i < v; i++) {
			if(!visited[i]) {
				isBridgeUtil(visited, disc, parent, low, i);
			}
		}
	}

	private void isBridgeUtil(boolean[] visited, int[] disc, int[] parent, int[] low, int src) {
		visited[src] = true;
		disc[src] = low[src] = time++;

		for(int i : ls[src]) {
			if(!visited[i]) {
				parent[i] = src;
				isBridgeUtil(visited, disc, parent, low, i);

				low[src] = Math.min(low[i], low[src]);

				if(low[i] > disc[src]) {
					System.out.println(src+ " "+i);
				}
			} else if(parent[src] != i) {
				low[src] = Math.min(low[src], disc[i]);
			}
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
		ls[j].add(i); 
	}
}
