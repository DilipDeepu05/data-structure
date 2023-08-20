package com.dsu.graph;

import java.util.ArrayList;
import java.util.List;

public class AllTopologicalSorting {

	int v;
	List<Integer> ls[];

	AllTopologicalSorting(int v) {
		this.v = v;
		ls = new ArrayList[v];

		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {

		AllTopologicalSorting graph = new AllTopologicalSorting(6);
		graph.addEdge(5, 2);
		graph.addEdge(5, 0);
		graph.addEdge(4, 0);
		graph.addEdge(4, 1);
		graph.addEdge(2, 3);
		graph.addEdge(3, 1);

		System.out.println("All Topological sorts");
		graph.allTopologicalSorts();
	}

	private void allTopologicalSorts() {
		boolean visited[] = new boolean[v];
		int inOrder[] = new int[v];
		
		for(int i =0; i< v; i++) {
			for(int j : ls[i]) {
				inOrder[j]++;
			}
		}
		
		List<Integer> l = new ArrayList<>();
		allTopologicalUtil(visited, inOrder, l);
	}

	private void allTopologicalUtil(boolean[] visited, int[] inOrder, List<Integer> l) {
		boolean flag = false;
		for(int i =0; i < v; i++) {
			if(!visited[i] && inOrder[i] == 0) {
				visited[i] = true;
				
				l.add(i);
			
				for(int j : ls[i]) {
					inOrder[j]--;
				}
	
				allTopologicalUtil(visited, inOrder, l);
				
				visited[i] = false;
				l.remove(l.size() - 1);
				
				for(int j : ls[i]) {
					inOrder[j]++;
				}
				flag = true;
			}
		}
		
		if(!flag) {
			System.out.println(l);
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
