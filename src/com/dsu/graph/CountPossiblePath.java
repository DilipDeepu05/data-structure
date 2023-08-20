package com.dsu.graph;

public class CountPossiblePath {

	public static void main(String[] args) throws java.lang.Exception
	{
		/* Let us create the graph shown in above diagram*/
		int graph[][] = new int[][] { { 0, 1, 1, 1 },
			{ 0, 0, 0, 1 },
			{ 0, 0, 0, 1 },
			{ 0, 0, 0, 0 } };
			int u = 0, v = 3, k = 2;
			CountPossiblePath p = new CountPossiblePath();
			System.out.println(p.countwalks(graph, u, v, k));
	}

	private int countwalks(int[][] graph, int u, int v, int k) {
		int count[][][] = new int[graph.length][graph.length][k+1];
		
		for(int e = 0; e <= k ; e++) {
			for(int i =0; i< graph.length; i++) {
				for(int j = 0; j < graph.length; j++) {
					count[i][j][e] = 0;
					if(e == 0 && i == j) {
						count[i][j][e] = 1;
					} 
					if(e == 1 && graph[i][j] !=0) {
						count[i][j][e] = 1;
					}
					
					if(e > 1) {
						for(int a =0; a< v; a++) {
							if(graph[i][a] != 0) {
								count[i][j][e] += count[i][j][e -1];
							}
						}
					}
				}
			}
		}
		return count[u][v][k];
	}
}
