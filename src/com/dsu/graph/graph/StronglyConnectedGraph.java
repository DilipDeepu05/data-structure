package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedGraph {
	
	int v ;
	List<Integer> ls[];
	
	StronglyConnectedGraph(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0;i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}
	
	 public static void main(String args[])
	    {
	        // Create a graph given in the above diagram
		 StronglyConnectedGraph g = new StronglyConnectedGraph(5);
	        g.addEdge(1, 0);
	        g.addEdge(0, 2);
	        g.addEdge(2, 1);
	        g.addEdge(0, 3);
	        g.addEdge(3, 4);
	 
	        System.out.println("Following are strongly connected components "+
	                           "in given graph ");
	        g.printSCCs();
	    }

	private void printSCCs() {
		boolean[] visited = new boolean[v];
		
		Stack<Integer> s = new Stack<>();
		
		for(int i =0; i < v; i++) {
			if(!visited[i]) {
				fillOrder(s, visited, i);
			}
		}
		
		StronglyConnectedGraph g = getTranspose();
		
		Arrays.fill(visited, false);
		
		while(!s.isEmpty()) {
			int x = s.pop();
			if(!visited[x]) {
				dfs(visited, x, g.ls);
				System.out.println();
			}
 		}
	}

	private void dfs(boolean[] visited, int x, List<Integer>[] ls2) {
		visited[x] = true;
		System.out.print(x+ " ");
		
		for(int i : ls2[x]) {
			if(!visited[i]) {
				dfs(visited, i, ls2);
			}
		}
	}

	private StronglyConnectedGraph getTranspose() {
		StronglyConnectedGraph s = new StronglyConnectedGraph(v);
		for(int i =0; i < v; i++) {
			for(int j : ls[i]) {
				s.ls[j].add(i);
			}
		}
		return s;
	}

	private void fillOrder(Stack<Integer> s, boolean[] visited, int i) {
		visited[i] = true;
		
		for(int d: ls[i]) {
			if(!visited[d]) {
				fillOrder(s, visited, d);
			}
		}
		s.push(i);
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
