package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestDistanceDijkstra {

	int v;
	List<List<Pair>> ls;

	ShortestDistanceDijkstra(int v) {
		this.v = v;
		ls = new ArrayList<>();
		for(int i =0; i < v; i++) {
			ls.add(new ArrayList<>());
		}
	}

	static class Pair {
		int first;
		int second;

		Pair(int f, int s) {
			this.first =f;
			this.second = s;
		}
	}

	public static void main(String[] args) {
		int V = 9;
		ShortestDistanceDijkstra g = new ShortestDistanceDijkstra(V);

		g.addEdge(0, 1, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(7, 8, 7);

		g.shortestPath(0);
	}

	private void shortestPath(int src) {
		int dist[] = new int[v];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.first));

		queue.add(new Pair(0, src));
		dist[src] = 0;

		while(!queue.isEmpty()) {
			int i = queue.poll().second;
			System.out.println(i);
			for(Pair p: ls.get(i)) {
				if(dist[p.first] > dist[i] + p.second) {
					dist[p.first] = dist[i] + p.second;
					queue.add(new Pair(dist[p.first], p.first));
				}
			}
		}

		for(int i =0; i < v; i++) {
			System.out.println(i+ " - "+ dist[i]);
		}
	}

	private void addEdge(int i, int j, int k) {
		ls.get(i).add(new Pair(j, k));
		ls.get(j).add(new Pair(i, k));
	}
}