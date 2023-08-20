package com.dsu.graph;

import java.util.ArrayList;

public class ArticulationPoint {

	  public static void main(String[] args)
	    {
	 
	        // Creating first example graph
	        int V = 5;
	        ArrayList<ArrayList<Integer> > adj1 =
	                         new ArrayList<ArrayList<Integer> >(V);
	        for (int i = 0; i < V; i++)
	            adj1.add(new ArrayList<Integer>());
	        addEdge(adj1, 1, 0);
	        addEdge(adj1, 0, 2);
	        addEdge(adj1, 2, 1);
	        addEdge(adj1, 0, 3);
	        addEdge(adj1, 3, 4);
	        System.out.println("Articulation points in first graph");
	        AP(adj1, V);
	 
	        // Creating second example graph
	        V = 4;
	        ArrayList<ArrayList<Integer> > adj2 =
	                         new ArrayList<ArrayList<Integer> >(V);
	        for (int i = 0; i < V; i++)
	            adj2.add(new ArrayList<Integer>());
	 
	        addEdge(adj2, 0, 1);
	        addEdge(adj2, 1, 2);
	        addEdge(adj2, 2, 3);
	 
	        System.out.println("Articulation points in second graph");
	        AP(adj2, V);
	 
	        // Creating third example graph
	        V = 7;
	        ArrayList<ArrayList<Integer> > adj3 =
	                            new ArrayList<ArrayList<Integer> >(V);
	        for (int i = 0; i < V; i++)
	            adj3.add(new ArrayList<Integer>());
	 
	        addEdge(adj3, 0, 1);
	        addEdge(adj3, 1, 2);
	        addEdge(adj3, 2, 0);
	        addEdge(adj3, 1, 3);
	        addEdge(adj3, 1, 4);
	        addEdge(adj3, 1, 6);
	        addEdge(adj3, 3, 5);
	        addEdge(adj3, 4, 5);
	 
	        System.out.println("Articulation points in third graph");
	 
	        AP(adj3, V);
	    }

	private static void AP(ArrayList<ArrayList<Integer>> adj3, int v) {
		boolean visited[] = new boolean[v];
		boolean isAP[] = new boolean[v];
		int disc[] = new int[v];
		int low[] = new int[v];
		int parent = -1;
		time =0;
		for(int i =0; i< v;i++) {
			if(!visited[i]) {
				isAPUtil(adj3, visited, i, parent, isAP, disc, low);
			}
		}
		
		for(int i =0;i< isAP.length; i++) {
			if(isAP[i]) {
				System.out.println(i);
			}
		}
	}

	  static int time;
	  
	private static void isAPUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i, int parent, boolean[] isAP, int[] disc, int[] low) {
		visited[i] = true;
		int children =0;
		low[i] = disc[i] = time++;
		for(int j : adj.get(i)) {
			if(!visited[j]) {
				children++;
				isAPUtil(adj, visited, j, i, isAP, disc, low);
				
				low[i] = Math.min(low[i], low[j]);
				
				if(parent != -1 && low[j] >= disc[i]) {
					isAP[i] = true;
				}
			} else if (parent != j) {
				 low[i] = Math.min(low[i], disc[j]);
			}
		}
		
		if(parent ==-1  && children >0) {
			isAP[i] = true;
		}
	}

	private static void addEdge(ArrayList<ArrayList<Integer>> adj1, int i, int j) {
		adj1.get(i).add(j);
		adj1.get(j).add(i);
	}
}
