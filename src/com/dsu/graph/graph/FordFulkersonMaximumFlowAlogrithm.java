package com.dsu.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FordFulkersonMaximumFlowAlogrithm {

	static final int v = 6;

	public static void main(String[] args)
			throws Exception
	{
		// Let us create a graph shown in the above example
		int graph[][] = new int[][] {
			{ 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
			{ 0, 4, 0, 0, 14, 0 },  { 0, 0, 9, 0, 0, 20 },
			{ 0, 0, 0, 7, 0, 4 },   { 0, 0, 0, 0, 0, 0 }
		};
		FordFulkersonMaximumFlowAlogrithm m = new FordFulkersonMaximumFlowAlogrithm();

		System.out.println("The maximum possible flow is "
				+ m.fordFulkerson(graph, 0, 5));
	}

	private int fordFulkerson(int[][] graph, int s, int e) {
		int parent[] = new int[v];
		int red[][] = new int[v][v];

		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				red[i][j] = graph[i][j];
			}
		}

		int maxCount =0;
		int n=0;

		while(bfs(red, parent, s, e)) {
			
			int pathflow = Integer.MAX_VALUE;
			for(int i =e; i != s; i = parent[i]) {
				n = parent[i];
				pathflow = Math.min(pathflow, graph[n][i]);
			}
			
			for(int i = e; i!= s; i = parent[i]) {
				n = parent[i];
				red[n][i] -= pathflow;
				red[i][n] += pathflow;
			}
			maxCount +=pathflow;
		}

		return maxCount;
	}

	private boolean bfs(int[][] red, int[] parent, int s, int e) {
		boolean visited[] = new boolean[v];
		parent[s] = -1;
		visited[s] = true;


		Queue<Integer> q = new LinkedList<>();
		q.add(s);

		while(!q.isEmpty()) {
			int n = q.poll();


			for(int i = 0 ;i < v; i++) {
				if(!visited[i] && red[n][i] > 0) {
					parent[i] = n;

					if(i == e) {
						return true;
					}

					q.add(i);
					visited[i] = true;
				}
			}
		}
		return false;
	}
}
