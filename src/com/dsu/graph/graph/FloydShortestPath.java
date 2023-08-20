package com.dsu.graph;

public class FloydShortestPath {
	final static int INF = 99999, v = 4;

	public static void main(String[] args)
	{
		/* Let us create the following weighted graph
	           10
	        (0)------->(3)
	        |         /|\
	        5 |          |
	        |          | 1
	        \|/         |
	        (1)------->(2)
	           3           */
		int graph[][] = { { 0, 5, INF, 10 },
				{ INF, 0, 3, INF },
				{ INF, INF, 0, 1 },
				{ INF, INF, INF, 0 } };
		FloydShortestPath a = new FloydShortestPath();

		// Function call
		a.floydWarshall(graph);
	}

	private void floydWarshall(int[][] dist) {

		for(int k =0; k < v; k++) {
			for(int i =0; i < v ;i++) {
				for(int j =0; j < v; j++) {
					if(dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		print(dist);
	}

	private void print(int[][] dist) {
		for(int i =0; i < v ;i++) {
			for(int j =0; j < v; j++) {
				System.out.println(dist[i][j] + " ");
			}
		}
	}
}
