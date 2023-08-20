package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {

	int v = 0;
	List<Integer>[] ls;

	int tc[][];

	GraphTraversal(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<Integer>();
		}
		tc = new int[v][v];
	}

	public static void main(String args[])
	{
		GraphTraversal g = new GraphTraversal(5);

		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 4);

		System.out.println(
				"Following is Breadth First Traversal "
						+ "(starting from vertex 2)");

		g.BFS(0);
		System.out.println();
		g.DFS(0);
		System.out.println();
		g.DFSIterative(0);

		GraphTraversal g1 = new GraphTraversal(5);
		g1.addEdge(0, 4);
		g1.addEdge(1, 2);
		g1.addEdge(1, 3);
		g1.addEdge(1, 4);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		System.out.println("Disconnected graph: ");
		g1.bfsDisconnected(5);

		GraphTraversal g2 = new GraphTraversal(4);
		g2.addEdge(0, 1);
		g2.addEdge(0, 2);
		g2.addEdge(1, 2);
		g2.addEdge(2, 0);
		g2.addEdge(2, 3);
		g2.addEdge(3, 3);
		System.out.println("Transitive closure " +
				"matrix is");

		g2.transitiveClosure();
	}

	private void transitiveClosure() {
		for(int i=0; i< v; i++) {
			dfsUtilTC(i, i);
		} 

		for(int i = 0; i < v; i++) {
			System.out.print(Arrays.toString(tc[i]) +" ");
		}
	}

	private void dfsUtilTC(int i1, int i2) {
		tc[i1][i2] = 1;
		
		for(int i: ls[i2]) {
			if(tc[i1][i] == 0) {
				dfsUtilTC(i1, i);
			}
		}
	}

	private void bfsDisconnected(int v) {
		boolean[] visited = new boolean[v];
		for(int i =0; i < v;i++) {
			if(!visited[i])
				bfsUtil(i, visited);
		}
	}

	private void bfsUtil(int i, boolean[] visited) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;

		while(!queue.isEmpty()) {
			int data = queue.poll();
			System.out.print(data+ " ");

			for(int d: ls[data]) {
				if(!visited[d]) {
					visited[d] = true;
					queue.add(d);
				}
			}
		}
	}

	private void DFSIterative(int i) {
		boolean visited[] = new boolean[v];
		visited[i] = true;
		Stack<Integer> s = new Stack<>();
		s.add(i);

		while(!s.empty()) {
			int data = s.pop();
			System.out.print(data+ " ");

			for(int d: ls[data]) {
				if(!visited[d]) {
					visited[d] = true;
					s.push(d);
				}
			}
		}

	}

	private void DFS(int i) {
		boolean visited[] = new boolean[v];
		visited[i] = true;
		DFSUtil(visited, i);
	}

	private void DFSUtil(boolean[] visited, int i) {
		System.out.print(i+" ");
		for(int d: ls[i]) {
			if(!visited[d]) {
				visited[d]  = true;
				DFSUtil(visited, d);
			}
		}
	}

	private void BFS(int vex) {
		boolean visited[] = new boolean[v];
		Queue<Integer> queue = new LinkedList<>();

		visited[vex] = true;
		queue.add(vex);

		while(!queue.isEmpty()) {
			int data = queue.poll();
			System.out.print(data+" ");

			for(int i: ls[data]) {
				if(!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
