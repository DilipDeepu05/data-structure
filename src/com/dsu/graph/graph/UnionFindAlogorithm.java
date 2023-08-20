package com.dsu.graph;

public class UnionFindAlogorithm {

	static class Edge {
		int src;
		int dest;
	}
	
	static class Graph {
		int v;
		int e;
		Edge[] edge;
		
		Graph(int v, int e){
			this.v = v;
			this.e = e;
			this.edge = new Edge[e];
			for(int i =0;i < e; i++) {
				edge[i] = new Edge();
			}
		}
		
		public int isCycle(Graph graph) {
			Subset s[] = new Subset[v];
			for(int i =0 ; i < v; i++) {
				s[i] = new Subset();
				s[i].parent = i;
				s[i].rank = 0;
			}
			
			for(int i =0; i < v; i++) {
				int x = find(s, graph.edge[i].src);
				int y = find(s, graph.edge[i].dest);
				
				if(x == y) {
					return 1;
				}
				
				union(s, x, y);
			}
			
			return 0;
		}

		private void union(Subset[] subset, int x, int y) {
			int xr = find(subset, x);
			int yr = find(subset, y);
			
			if(subset[xr].rank > subset[yr].rank) {
				subset[yr].parent = xr;
			} else if(subset[yr].rank > subset[xr].rank) {
				subset[xr].parent = yr;
			} else {
				subset[yr].parent = xr;
				subset[yr].rank++;
			}
		}

		private int find(Subset[] s, int src) {
			if(s[src].parent != src) {
				s[src].parent = find(s, s[src].parent);
			}
			return s[src].parent;
		}
	}
	
	static class Subset{
		int parent;
		int rank;
	}
	
	public static void main(String[] args)
    {
        /* Let us create the following graph
            0
            | \
            | \
            1-----2 */
 
        int V = 3, E = 3;
        Graph graph = new Graph(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
 
        if (graph.isCycle(graph) == 1)
            System.out.println("Graph contains cycle");
        else
            System.out.println(
                "Graph doesn't contain cycle");
    }
}
