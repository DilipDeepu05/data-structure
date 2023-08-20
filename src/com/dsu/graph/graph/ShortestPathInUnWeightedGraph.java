package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUnWeightedGraph {

	public static void main(String args[])
	{
		// No of vertices
		int v = 8;

		// Adjacency list for storing which vertices are connected
		ArrayList<ArrayList<Integer>> adj =
				new ArrayList<ArrayList<Integer>>(v);
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}

		// Creating graph given in the above diagram.
		// add_edge function takes adjacency list, source
		// and destination vertex as argument and forms
		// an edge between them.
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 7);
		addEdge(adj, 4, 5);
		addEdge(adj, 4, 6);
		addEdge(adj, 4, 7);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 7);
		int source = 0, dest = 7;
		printShortestDistance(adj, source, dest, v);
	}

	private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int source, int dest, int v) {
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);

		int pred[] = new int[v];
		Arrays.fill(pred, -1);

		if(!bfs(adj,source, dest, v, dist, pred)) {
			System.out.println("No path");
			return;
		}
		
		List<Integer> ls = new LinkedList<>();
		int c= dest;
		ls.add(c);
		while(pred[c] != -1) {
			ls.add(pred[c]);
			c = pred[c];
		}
		  System.out.println("Shortest path length is: " + dist[dest]);
		System.out.println(Arrays.asList(ls));
	}

	private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int source, int dest, int v, int[] dist, int[] pred) {
		Queue<Integer> queue = new LinkedList<>();

		boolean visited[] = new boolean[v];
		dist[source] = 0;
		queue.add(source);
		visited[source] = true;
		
		while(!queue.isEmpty()) {
			int i = queue.poll();

			for(int d: adj.get(i)) {
				if(!visited[d]) {
					dist[d] = dist[i] + 1;
					visited[d] = true;
					queue.add(d);
					pred[d] = i;
					if(d == dest) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) {
		adj.get(i).add(j);
		adj.get(j).add(i);
	}
}
