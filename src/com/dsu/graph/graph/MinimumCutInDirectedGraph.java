package com.dsu.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumCutInDirectedGraph {

	public static void main(String args[]) {

		int graph[][] = { {0, 16, 13, 0, 0, 0},
				{0, 0, 10, 12, 0, 0},
				{0, 4, 0, 0, 14, 0},
				{0, 0, 9, 0, 0, 20},
				{0, 0, 0, 7, 0, 4},
				{0, 0, 0, 0, 0, 0}
		};
		minCut(graph, 0, 5);
	}

	private static void minCut(int[][] graph, int s, int e) {
		int[][] red = new int[graph.length][graph.length];
		int parent[] = new int[graph.length];

		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph.length; j++) {
				red[i][j] = graph[i][j];
			}
		}

		int n =0;
		int max = 0;
		while(bfs(red, s, e, parent)) {

			int path = Integer.MAX_VALUE;
			for(int i = e ;i != s; i = parent[i]) {
				n = parent[i];
				path = Math.min(path, red[n][i]);
			}

			for(int i = e ;i != s; i = parent[i]) {
				n = parent[i];
				red[n][i] -= path;
				red[i][n] += path;
			}
			max+=path;
		}

		boolean[] isVisited = new boolean[graph.length];    
		dfs(red, s, isVisited);

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] > 0 && isVisited[i] && !isVisited[j]) {
					System.out.println(i + " - " + j);
				}
			}
		}

	}

	private static void dfs(int[][] rGraph, int s,
			boolean[] visited) {
		visited[s] = true;
		for (int i = 0; i < rGraph.length; i++) {
			if (rGraph[s][i] > 0 && !visited[i]) {
				dfs(rGraph, i, visited);
			}
		}
	}

	private static boolean bfs(int[][] rGraph, int s,
			int t, int[] parent) {

		// Create a visited array and mark
		// all vertices as not visited    
		boolean[] visited = new boolean[rGraph.length];

		// Create a queue, enqueue source vertex
		// and mark source vertex as visited    
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop    
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int i = 0; i < rGraph.length; i++) {
				if (rGraph[v][i] > 0 && !visited[i]) {
					q.offer(i);
					visited[i] = true;
					parent[i] = v;
				}
			}
		}

		// If we reached sink in BFS starting
		// from source, then return true, else false    
		return (visited[t] == true);
	}
}
