package com.dsu.graph;

import java.util.ArrayList;
import java.util.List;

public class TransposeGraph {

	private static int vertices = 5;

	private static List<Integer>[] adj = new ArrayList[vertices];

	private static List<Integer>[] tr = new ArrayList[vertices];

	public static void main (String[] args) throws Exception
	{
		for(int i = 0; i < vertices; i++)
		{
			adj[i] = new ArrayList<Integer>();
			tr[i] = new ArrayList<Integer>();
		}
		addedge(0, 1, false);
		addedge(0, 4, false);
		addedge(0, 3, false);
		addedge(2, 0, false);
		addedge(3, 2, false);
		addedge(4, 1, false);
		addedge(4, 3, false);

		System.out.println("Original");
		printGraph(adj);
		// Finding transpose of the graph
		getTranspose();

		System.out.println("Transpose");
		// Printing the graph representation
		printGraph(tr);
	}

	private static void getTranspose() {
		for(int i =0 ;i < adj.length; i++) {
			for(int j =0; j < adj[i].size(); j++) {
				addedge(adj[i].get(j), i, true);
			}
		}
	}

	private static void addedge(int i, int j, boolean b) {
		if(!b) {
			adj[i].add(j);
		} else {
			tr[i].add(j);
		}
	}

	private static void printGraph(List<Integer>[] res) {
		for(int i =0 ;i < res.length; i++) {
			System.out.print(i + "--> ");
            for(int j = 0; j < res[i].size(); j++)
                System.out.print(res[i].get(j) + " ");
            System.out.println();
			System.out.println();
		}
	}
}
