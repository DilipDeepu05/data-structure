package com.dsu.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleUnDirectedGrpah {

	int v;
	List<Integer> []ls;

	DetectCycleUnDirectedGrpah(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i =0; i < v; i++) {
			ls[i] = new ArrayList<Integer>();
		}
	}

	public static void main(String args[])
	{

		// Create a graph given
		// in the above diagram
		DetectCycleUnDirectedGrpah g1 = new DetectCycleUnDirectedGrpah(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		if (g1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");

		DetectCycleUnDirectedGrpah g2 = new DetectCycleUnDirectedGrpah(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		if (g2.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}

	private boolean isCyclic() {
		boolean visited[] = new boolean[v];

		for(int i =0; i < v; i++) {
			if(!visited[i]) {
				if(isCyclicUtil(i, visited, -1))
					return true;
			}
		}
		return false;
	}

	private boolean isCyclicUtil(int i, boolean[] visited, int j) {
		visited[i] = true;

		for(int d: ls[i]) {
			if(!visited[d]) {
				if(isCyclicUtil(d, visited, i)) return true;
			} else if(d != j) {
				return true;
			}
		}
		return false;
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
		ls[j].add(i);
	}
}
