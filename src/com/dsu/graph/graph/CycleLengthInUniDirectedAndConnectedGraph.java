package com.dsu.graph;

public class CycleLengthInUniDirectedAndConnectedGraph {

	public static final int V = 5;
	static int count = 0;
	
	public static void main(String[] args) {
		int graph[][] = {{0, 1, 0, 1, 0},
				{1, 0, 1, 0, 1},
				{0, 1, 0, 1, 0},
				{1, 0, 1, 0, 1},
				{0, 1, 0, 1, 0}};

		int n = 4;

		System.out.println("Total cycles of length "+
				n + " are "+
				countCycles(graph, n));
	}

	private static int countCycles(int[][] graph, int n) {
		boolean visited[] = new boolean[V];
		
		for(int i = 0 ; i < V - (n - 1) ; i++) {
			dfs(graph, visited, n-1, i, i);
			visited[i] = true;
 		}
		return count /2;
	}

	private static void dfs(int[][] graph, boolean[] visited, int n, int v, int start) {
		visited[v] = true;
		
		if(n ==0) {
			visited[v] = false;
			if(graph[v][start]== 1) {
				count++;
				return;
			} else {
				return;
			}
		}
		
		for(int i=0; i < V; i++) {
			if(!visited[i] && graph[v][i] == 1) {
				dfs(graph, visited, n - 1, i, start);
			}
		}
		
		visited[v] = false; 
	}
}
