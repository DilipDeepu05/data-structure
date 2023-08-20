package com.dsu.graph;

import java.util.Arrays;

public class TotalNumberOfSpanningTree {

	static final int MAX = 100;
	static final int MOD = 1000000007;

	public static void main(String[] args)
	{
		// Let us create the following graph
		// 2 <-> 3
		// |   |
		// 0 <-1-> 1
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of edges in graph
		int graph[][] = { { 0, 1, 1, 1 },
				{ 1, 0, 1, 1 },
				{ 1, 1, 0, 1 },
				{ 1, 1, 1, 0 } };
		System.out.println(numOfSpanningTree(graph, V));
	}

	private static int numOfSpanningTree(int[][] graph, int v) {
		int temp [][] = new int[MAX][MAX];
		int res[][] =new int[MAX][MAX];

		for(int i =0;i < v; i++) {
			for(int j = 0; j < v; j++) {
				temp[i][j] = graph[i][j];
			}
		}

		power(temp, v - 2, res);
		int ans = 0;
		for(int i= 0; i < v; i++) {
			for(int j =0; j < v; j++) {
				ans = (	ans + res[i][j] ) % MOD;
			}
		}
		return ans;
	}

	private static void power(int[][] a, int v, int[][] res) {
		int temp[][] = new int[MAX][MAX];

		for(int i= 0; i < MAX; i++) {
			for(int j =0; j < MAX; j++) {
				res[i][j] = (i ==j) ? 1 :0;
			}
		}

		while(v > 0) {
			if(v % 2 == 1) {
				multiply(a, res, temp);
				for(int i= 0; i < MAX; i++) {
					for(int j =0; j < MAX; j++) {
						res[i][j] = temp[i][j];
					}
				}
			} 
			v = v / 2;
			multiply(a, a, temp);
			for(int i= 0; i < MAX; i++) {
				for(int j =0; j < MAX; j++) {
					a[i][j] = temp[i][j];
				}
			}
		}
	}

	private static void multiply(int[][] a, int[][] temp, int[][] res) {
		for(int i =0; i < MAX; i++) {
			for(int j = 0; j <  MAX; j++) {
				for(int k = 0; k < MAX; k++) {
					res[i][j] = (int)((res[i][j] + (a[i][k]*temp[k][j]) % MOD) % MOD);
				}
			}
		}
	}
}
