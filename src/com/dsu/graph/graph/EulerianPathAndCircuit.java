package com.dsu.graph;

import java.util.ArrayList;
import java.util.List;

public class EulerianPathAndCircuit {

	int v;
	List<Integer> ls[];

	EulerianPathAndCircuit(int v) {
		this.v = v;
		ls = new ArrayList[v];
		for(int i = 0; i < v; i++) {
			ls[i] = new ArrayList<>();
		}
	}

	public static void main(String args[])
	{
		EulerianPathAndCircuit g1 = new EulerianPathAndCircuit(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);
		g1.test();
	}

	private void test() {
		int c = connected();
		if(c == 0) {
			System.out.println("Not a Eulerian graph");
		} else if(c == 1) {
			System.out.println("Eulerian Path");
		} else {
			System.out.println("Eulerian cycle");
		}
	}

	private int connected() {
		boolean visited[] = new boolean[v];
		int i =0;
		for(i =0; i< v; i++) {
			if(ls[i].size() != 0) {
				break;
			}
		}

		if(v == i) {
			return 0;
		}

		dfs(visited, 0);

		for(int j =0; j< v; j++) {
			if(!visited[j] && ls[j].size() > 0) {
				return 0;
			}
		}

		int odd =0;
		for(int j = 0; j < v; j++) {
			if(ls[j].size()%2 !=0) {
				odd++;
			}
		}

		if(odd > 2) {
			return 0;
		}

		return odd == 2 ? 1: 2;
	}

	private void dfs(boolean[] visited, int src) {
		visited[src] = true;
		for(int i: ls[src]) {

			if(!visited[i]) 
				dfs(visited, i);
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
		ls[j].add(i);
	}
}
