package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortingBasedOnInDegree {

	int v;
	List<Integer>[] ls;

	TopologicalSortingBasedOnInDegree(int v) {
		this.v= v;
		ls = new ArrayList[v];
		for(int i =0; i< v; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String args[])
	{
		// Create a graph given in the above diagram
		TopologicalSortingBasedOnInDegree g = new TopologicalSortingBasedOnInDegree(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological Sort");
		g.topologicalSort();

		g.maximumEdgeAddition();
	}

	private void maximumEdgeAddition() {
		List<Integer> l = topologicalSort();
		
		boolean visited[] = new boolean[v];
		for(int i =0; i < l.size(); i++) {
			int d = l.get(i);

			for(int j: ls[d]) {
				visited[j] = true;
			}

			for(int j = i + 1; j < l.size(); j++) {
				if(!visited[l.get(j)]) {
					System.out.print(d + "-" + l.get(j)+ " ");
				}
				visited[l.get(j)] = false;
			}
		}
	}

	private List<Integer> topologicalSort() {
		int[] inOrder = new int[v];
		for(int i =0; i< v; i++) {
			for(int j : ls[i]) {
				inOrder[j]++;
			}
		}

		int cnt=0;

		Queue<Integer> queue = new LinkedList<>();
		for(int i =0; i < v; i++) {
			if(inOrder[i] == 0) {
				queue.add(i);
			}
		}

		List<Integer> l = new ArrayList<>();
		while(!queue.isEmpty()) {
			int d = queue.remove();
			l.add(d);
			for(int i: ls[d]) {
				if(--inOrder[i] == 0) {
					queue.add(i);
				}
			}
			cnt++;
		}

		if(cnt != v) {
			System.out.println("Cycle exists");
		}

		System.out.println(Arrays.asList(l));
		return l;
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
