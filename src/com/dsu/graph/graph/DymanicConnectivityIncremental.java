package com.dsu.graph;

public class DymanicConnectivityIncremental {

	public static void main(String[] args)
	{
		// No.of nodes
		int n = 7;

		int []arr = new int[n];
		int []rank = new int[n];

		// initializing both array and rank
		for (int i = 0; i < n; i++)
		{
			arr[i] = i;
			rank[i] = 1;
		}

		// number of queries
		int q = 11;
		query(1, 0, 1, arr, rank);
		query(2, 0, 1, arr, rank);
		query(2, 1, 2, arr, rank);
		query(1, 0, 2, arr, rank);
		query(2, 0, 2, arr, rank);
		query(2, 2, 3, arr, rank);
		query(2, 3, 4, arr, rank);
		query(1, 0, 5, arr, rank);
		query(2, 4, 5, arr, rank);
		query(2, 5, 6, arr, rank);
		query(1, 2, 6, arr, rank);
	}

	private static void query(int i, int j, int k, int[] arr, int[] rank) {
		if(i == 1) {
			if(isSameRoot(arr, j, k)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		} else if( i == 2) {
			if(!isSameRoot(arr, j, k)) {
				weightunion(rank, arr, j , k);
			}
		}
	}

	private static void weightunion(int[] rank, int[] arr, int j, int k) {
		int a = root(arr, j);
		int b = root(arr, k);

		if(rank[a] < rank[b]) {
			arr[a] = arr[b];
			rank[b] += rank[a];
		} else {
			arr[b] = arr[a];
			rank[a] += rank[b];
		}
	}

	private static boolean isSameRoot(int[] arr, int j, int k) {
		return (root(arr, j) == root(arr, k));
	}

	private static int root(int[] arr, int k) {
		while(arr[k] != k) {
			arr[k] = arr[arr[k]];
			k = arr[k];
		}
		return k;
	}
}
