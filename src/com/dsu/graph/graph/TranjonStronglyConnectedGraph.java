package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TranjonStronglyConnectedGraph {

	int v;
	List<Integer> ls[];

	TranjonStronglyConnectedGraph(int v) {
		this.v  = v;
		ls = new ArrayList[v];
		Arrays.fill(ls, new ArrayList<>());
	}

	public static void main(String args[])
	{

		// Create a graph given in the above diagram
		TranjonStronglyConnectedGraph g1 = new TranjonStronglyConnectedGraph(5);

		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		System.out.println("SSC in first graph ");
		g1.SCC();
	}

	private void SCC() {
		int disc[] = new int[v];
		int low[] = new int[v];
		Arrays.fill(disc, -1);
		Arrays.fill(low, -1);

		boolean visited[] = new boolean[v];
		Stack<Integer> s = new Stack<>();

		for(int i =0; i< v;i++) {
			if(disc[i] == -1) {
				dfsUtil(visited, disc, low, i, s);
			}
		}
	}
	static int time =0;
	private void dfsUtil(boolean[] visited, int[] disc, int[] low, int i, Stack<Integer> s) {
		visited[i] = true;

		disc[i] = low[i] = time++;
		s.add(i);

		for(int j: ls[i]) {
			if(disc[j] == -1) {
				dfsUtil(visited, disc, low, j, s);

				low[i] = Math.min(low[i], low[j]);
			} else if(visited[j]) {
				low[i] = Math.min(low[i], disc[j]);
			}
		}

		int w = -1;
		if (low[i] == disc[i]) {
			while (w != i) {
				w = (int)s.pop();
				System.out.print(w + " ");
				visited[w] = false;
			}
			System.out.println();
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
	}
}
