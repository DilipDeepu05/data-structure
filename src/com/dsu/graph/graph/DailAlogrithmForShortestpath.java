package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DailAlogrithmForShortestpath {
	int v;
	List<Tuple> ls[];

	class Tuple {
		int v;
		int w;
		Tuple(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}
	
	DailAlogrithmForShortestpath(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String[] args)
	{
		// create the graph given in above figure
		int V = 9;
		DailAlogrithmForShortestpath g = new DailAlogrithmForShortestpath(V);

		// making above shown graph
		g.AddEdge(0, 1, 4);
		g.AddEdge(0, 7, 8);
		g.AddEdge(1, 2, 8);
		g.AddEdge(1, 7, 11);
		g.AddEdge(2, 3, 7);
		g.AddEdge(2, 8, 2);
		g.AddEdge(2, 5, 4);
		g.AddEdge(3, 4, 9);
		g.AddEdge(3, 5, 14);
		g.AddEdge(4, 5, 10);
		g.AddEdge(5, 6, 2);
		g.AddEdge(6, 7, 1);
		g.AddEdge(6, 8, 6);
		g.AddEdge(7, 8, 7);

		// maximum weighted edge - 14
		g.shortestPath(0, 14);
	}

	private void shortestPath(int src, int w) {
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		List<Integer> []b = new ArrayList[w* v+1];
		Arrays.fill(b, new ArrayList<>());
		
		b[0].add(src);
		dist[src] = 0;
		int i =0;
		
		while(true) {
			while(b[i].size() == 0 && i < w * v) {
				i++;
			}
			
			if( i == w*v) break;
			
			int u = b[i].get(0);
			b[i].remove(0);
			
			for(Tuple t: ls[u]) {
				if(dist[t.v] > t.w + dist[u]) {
					dist[t.v] =  t.w + dist[u];
					b[dist[t.v]].add(0, t.v);
				}
			}
		}
		
		for(int j =0; j < v; j++) {
			System.out.println(j+ " "+ dist[j]);
		}
	}

	private void AddEdge(int i, int j, int k) {
		ls[i].add(new Tuple(j, k));
		ls[j].add(new Tuple(i, k));
	}
}
