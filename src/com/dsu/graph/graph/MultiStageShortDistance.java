package com.dsu.graph;

public class MultiStageShortDistance {

    static int N = 8;
    static int INF = Integer.MAX_VALUE;
    
	public static void main(String[] args)
	{
		// Graph stored in the form of an
		// adjacency Matrix
		int[][] graph = new int[][] {
			{ INF, 1, 2, 5, INF, INF, INF, INF },
			{ INF, INF, INF, INF, 4, 11, INF, INF },
			{ INF, INF, INF, INF, 9, 5, 16, INF },
			{ INF, INF, INF, INF, INF, INF, 2, INF },
			{ INF, INF, INF, INF, INF, INF, INF, 18 },
			{ INF, INF, INF, INF, INF, INF, INF, 13 },
			{ INF, INF, INF, INF, INF, INF, INF, 2 }
		};

		System.out.println(shortestDist(graph));
	}

	private static int shortestDist(int[][] graph) {
		int dist[] = new int[N];
		dist[N-1] = 0;
		
		for(int i = N-2; i>=0; i--) {
			dist[i] = INF;
			
			for(int j = 0; j < N ; j++) {
				if(graph[i][j] == INF) {
					continue;
				}
				
				dist[i] = Math.min(dist[i], graph[i][j]+dist[j]);
			}
		}
		return dist[0];
	}
}
