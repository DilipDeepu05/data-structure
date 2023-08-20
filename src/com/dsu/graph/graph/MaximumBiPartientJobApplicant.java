package com.dsu.graph;

import java.util.Arrays;

public class MaximumBiPartientJobApplicant {

	static final int M = 6;
	static final int N = 6;

	public static void main (String[] args)
			throws java.lang.Exception
	{
		// Let us create a bpGraph shown
		// in the above example
		boolean bpGraph[][] = new boolean[][]{
			{false, true, true,
				false, false, false},
			{true, false, false,
					true, false, false},
			{false, false, true,
						false, false, false},
			{false, false, true,
							true, false, false},
			{false, false, false,
								false, false, false},
			{false, false, false,
									false, false, true}};
									MaximumBiPartientJobApplicant m = new MaximumBiPartientJobApplicant();
									System.out.println( "Maximum number of applicants that can get job is "+ m.maxBPM(bpGraph));
	}

	private int maxBPM(boolean[][] bpGraph) {
		int matchR[] = new int[M];
		Arrays.fill(matchR, -1);

		int res = 0;
		for(int i =0; i < M; i++) {
			boolean visited[] = new boolean[M];
			Arrays.fill(visited, false);

			if(bpm(bpGraph, matchR, i, visited)) {
				res++;
			}
		}
		return res;
	}

	private boolean bpm(boolean[][] bpGraph, int[] matchR, int i, boolean[] visited) {
		for(int j = 0;j <M; j++) {
			if(bpGraph[i][j] && !visited[j]) {
				visited[j] = true;

				if(matchR[j] < 0 || bpm(bpGraph, matchR, matchR[j], visited)) {
					matchR[j] = i;
					return true;
				}
			}
		}
		return false;
	}
}
