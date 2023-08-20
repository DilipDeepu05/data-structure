package com.dsu.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {

	static int WHITE = 0, GRAY = 1, BLACK = 2;
	int v;
	List<Integer> []ls;

	DetectCycle(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<Integer>();
		}
	}

	public static void main(String[] args)
	{
		DetectCycle graph = new DetectCycle(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		// Function call
		if(graph.isDirectedCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
					+ "contain cycle");

		if(graph.isDirectedColorCyclic())
			System.out.println("Color Graph contains cycle");
		else
			System.out.println("Color Graph doesn't "
					+ "contain cycle");
	}

	private boolean isDirectedColorCyclic() {
		int color[] = new int[v];
		
		for(int i =0; i < v; i++) {
			color[i] = WHITE;
		}
		
		for(int i =0; i < v; i++) {
			if(color[i] == WHITE) {
				if(cyclicColorUtil(color, i)) return true;
			}
		}
		return false;
	}

	private boolean cyclicColorUtil(int[] color, int i) {
		color[i] = GRAY;
		
		for(int d: ls[i]) {
			if(color[i] == GRAY) return true;
			
			if(color[i] == WHITE && cyclicColorUtil(color, d)) {
				return true;
			}
		}
		
		color[i] = BLACK;
		return false;
	}

	private boolean isDirectedCyclic() {

		boolean visited[] = new boolean[v];
		boolean reStack[] = new boolean[v];

		for(int i =0; i < v; i++) {
			if(isCyclicUtil(visited, reStack, i))
				return true;
		}
		return false;
	}

	private boolean isCyclicUtil(boolean[] visited, boolean[] reStack, int i) {
		if(reStack[i]) return true;

		if(visited[i]) return false;

		visited[i] = true;
		reStack[i] = true;

		for(int d: ls[i]) {
			if(isCyclicUtil(visited, reStack, d))
				return true;
		}

		reStack[i] = false;

		return false;
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
