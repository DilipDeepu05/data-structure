package com.dsu.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryGraph {

	static class Node {
		int to;
		int w;
		Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	private static final int numVertex = 9;
	List<Node>[] ls;

	ShortestPathInBinaryGraph() {
		ls = new ArrayList[numVertex];
		for(int i =0; i < ls.length; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String[] args) {
		ShortestPathInBinaryGraph graph = new ShortestPathInBinaryGraph();
		graph.addEdge(0, 1, 0);
		graph.addEdge(0, 7, 1);
		graph.addEdge(1, 7, 1);
		graph.addEdge(1, 2, 1);
		graph.addEdge(2, 3, 0);
		graph.addEdge(2, 5, 0);
		graph.addEdge(2, 8, 1);
		graph.addEdge(3, 4, 1);
		graph.addEdge(3, 5, 1);
		graph.addEdge(4, 5, 1);
		graph.addEdge(5, 6, 1);
		graph.addEdge(6, 7, 1);
		graph.addEdge(7, 8, 1);
		int src = 0;//source node
		graph.zeroOneBFS(src);
		return;
	}

	private void zeroOneBFS(int src) {
		int dist[] = new int[numVertex];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		Deque<Integer> queue = new ArrayDeque<>();
		queue.addLast(src);
		dist[src] = 0;
		while(!queue.isEmpty()) {
			int d = queue.removeFirst();
			
			for(Node i: ls[d]) {
				if(dist[i.to] > i.w + dist[d]) {
					dist[i.to] = i.w + dist[d];
					
					if(i.w == 0) {
						queue.addFirst(i.to);
					} else {
						queue.addLast(i.to);
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(dist));
	}

	private void addEdge(int i, int j, int k) {
		ls[i].add(ls[i].size(), new Node(j, k));
		ls[j].add(ls[j].size(), new Node(i, k));
	}
}
