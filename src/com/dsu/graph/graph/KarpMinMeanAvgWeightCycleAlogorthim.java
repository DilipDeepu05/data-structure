package com.dsu.graph;

import java.util.Arrays;
import java.util.Vector;

public class KarpMinMeanAvgWeightCycleAlogorthim {

	static int V = 4;

	// a struct to represent edges
	static class Edge
	{
		int from, weight;

		Edge(int from, int weight)
		{
			this.from = from;
			this.weight = weight;
		}
	}

	// vector to store edges
	//@SuppressWarnings("unchecked")
	static Vector<Edge>[] edges = new Vector[V];
	static
	{
		for (int i = 0; i < V; i++)
			edges[i] = new Vector<>();
	}

	public static void main(String[] args)
	{
		addedge(0, 1, 1);
		addedge(0, 2, 10);
		addedge(1, 2, 3);
		addedge(2, 3, 2);
		addedge(3, 1, 0);
		addedge(3, 0, 8);

		System.out.printf("%.5f", minAvgWeight());
	}

	private static Object minAvgWeight() {
		int dp[][]= new int[V + 1][V];
		shortestPath(dp);

		double avg[] = new double[V];
		Arrays.fill(avg, -1);

		for(int i =0;i < V; i++) {
			if(dp[V][i] != -1) {
				for(int j =0; j < V; j++) {
					if(dp[j][i] != -1) {
						avg[i] = Math.max(avg[i], ((dp[V][i] - dp[j][i]) / (V-j)));
					}
				}
			}
		}
		
		double result = avg[0];
		for (int i = 0; i < V; i++)
			if (avg[i] != -1 && avg[i] < result)
				result = avg[i];

		return result;
	}

	private static void shortestPath(int[][] dp) {

		for (int i = 0; i <= V; i++)
			for (int j = 0; j < V; j++)
				dp[i][j] = -1;

		dp[0][0] = 0;

		for(int i = 1; i <=V; i++) {
			for(int j = 0; j < V; j++) {
				for(int k =0; k< edges[j].size(); k++) {
					if(dp[i-1][edges[j].elementAt(k).from] != -1) {
						int curr = dp[i-1][edges[j].elementAt(k).from] + edges[j].elementAt(k).weight;
						if(dp[i][j] == -1) {
							dp[i][j] = curr;
						} else {
							dp[i][j] = Math.min(dp[i][j], curr);
						}
					}
				}
			}
		}
	}

	private static void addedge(int i, int j, int k) {
		edges[i].add(new Edge(i, k));
	}
}
