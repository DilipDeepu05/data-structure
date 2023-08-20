package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestDistanceAcyclicGraph {
	int v;
	List<Graph> []ls;
	class Graph
	{
		private int v;
		private int weight;
		Graph(int _v, int _w) { v = _v;  weight = _w; }
		int getV() { return v; }
		int getWeight()  { return weight; }
	}

	ShortestDistanceAcyclicGraph(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0 ;i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String args[])
	{
		// Create a graph given in the above diagram.  Here vertex
		// numbers are 0, 1, 2, 3, 4, 5 with following mappings:
		// 0=r, 1=s, 2=t, 3=x, 4=y, 5=z
		ShortestDistanceAcyclicGraph t = new ShortestDistanceAcyclicGraph(6);
		ShortestDistanceAcyclicGraph g = t.newGraph(6);
		g.addEdge(0, 1, 5);
		g.addEdge(0, 2, 3);
		g.addEdge(1, 3, 6);
		g.addEdge(1, 2, 2);
		g.addEdge(2, 4, 4);
		g.addEdge(2, 5, 2);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 4, -1);
		g.addEdge(4, 5, -2);

		int s = 1;
		System.out.println("Following are shortest distances "+
				"from source " + s );
		g.shortestPath(s);
	}

	private void shortestPath(int src) {
		Stack<Integer> s = new Stack<>();
		boolean visited[] = new boolean[v];
		for(int i =0; i < v; i++) {
			if(!visited[i]) {
				cyclicShorestPath(i, visited, s);
			}
		}

		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		while(!s.empty()) {
			int u = s.pop();
			if(dist[u] != Integer.MAX_VALUE) {
				for(Graph g: ls[u]) {

					if(dist[g.v] > g.weight + dist[u]) {
						dist[g.v] = g.weight + dist[u];
					}
				}
			}
		}

		for(int i =0 ; i < v; i++) {
			System.out.println(i+" "+ dist[i]);
		}
	}

	private void cyclicShorestPath(int i, boolean[] visited, Stack<Integer> s) {
		visited[i] = true;
		for(Graph g: ls[i]) {
			cyclicShorestPath(g.getV(), visited, s);
		}
		s.add(i);
	}

	private void addEdge(int i, int j, int k) {
		Graph g = new Graph(j, k);
		ls[i].add(g);
	}

	private ShortestDistanceAcyclicGraph newGraph(int i) {
		return new ShortestDistanceAcyclicGraph(i);
	}
}
