package com.dsu.graph;

public class DetectNegativeCycle {
	static class Edge {
		int src;
		int dest;
		int weight;
	}

	static class Graph {
		int v;
		int e;
		Edge edge[];
	}

	public static void main(String[] args) {
		int V = 5, E = 8;
		Graph graph = createGraph(V, E);

		// add edge 0-1 (or A-B in above figure)
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = -1;

		// add edge 0-2 (or A-C in above figure)
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;

		// add edge 1-2 (or B-C in above figure)
		graph.edge[2].src = 1;
		graph.edge[2].dest = 2;
		graph.edge[2].weight = 3;

		// add edge 1-3 (or B-D in above figure)
		graph.edge[3].src = 1;
		graph.edge[3].dest = 3;
		graph.edge[3].weight = 2;

		// add edge 1-4 (or A-E in above figure)
		graph.edge[4].src = 1;
		graph.edge[4].dest = 4;
		graph.edge[4].weight = 2;

		// add edge 3-2 (or D-C in above figure)
		graph.edge[5].src = 3;
		graph.edge[5].dest = 2;
		graph.edge[5].weight = 5;

		// add edge 3-1 (or D-B in above figure)
		graph.edge[6].src = 3;
		graph.edge[6].dest = 1;
		graph.edge[6].weight = 1;

		// add edge 4-3 (or E-D in above figure)
		graph.edge[7].src = 4;
		graph.edge[7].dest = 3;
		graph.edge[7].weight = -3;

		if (isNegCycleBellmanFord(graph, 0))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	private static boolean isNegCycleBellmanFord(Graph graph, int d) {
		int dist[] = new int[graph.v];
		for(int i=0; i < graph.v; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[d] = 0;
		
		for(int i = 1; i <= graph.v - 1; i++) {
			for(int j = 0; j < graph.e; j++) {
				int v = graph.edge[j].src;
				int u = graph.edge[j].dest;
				int w = graph.edge[j].weight;
				if(dist[v] != Integer.MAX_VALUE && dist[v] + w < dist[u]) {
					dist[u] = dist[v] + w;
				}
			}
		}
		
		for(int i =0 ;i < graph.e; i++) {
			int v = graph.edge[i].src;
			int u = graph.edge[i].dest;
			int w = graph.edge[i].weight;
			if(dist[v] != Integer.MAX_VALUE && dist[v] + w < dist[u]) {
				return true;
			}
		}
		return false;
	}

	private static Graph createGraph(int v, int e) {
		Graph g = new Graph();
		g.v = v;
		g.e = e;
		g.edge = new Edge[e];
		
		for(int i =0; i < e; i++) {
			g.edge[i] = new Edge();
		}
		
		return g;
	}
}
