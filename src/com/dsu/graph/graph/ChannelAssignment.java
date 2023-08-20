package com.dsu.graph;

import java.util.Arrays;

public class ChannelAssignment {
	static int v =3;
	
	public static void main(String[] args)
	{
		int table[][] = {{0, 2, 0},
				{3, 0, 1},
				{2, 4, 0}};

		maxBPM(table);
	}

	private static void maxBPM(int[][] table) {
		int match[] = new int[v];
		Arrays.fill(match, -1);
		
		int res=0;
		for(int i =0; i < v; i++) {
			
			boolean[] visited = new boolean[v];
			Arrays.fill(visited, false);
			
			if(bpm(table, match, i, visited)) {
				res++;
			}
		}
		
		 System.out.println("The number of maximum packets" +
                  " sent in the time slot is " + res);
		 
		 for(int i = 0; i < v; i++) {
			 if(match[i]+1 != 0) {
				 System.out.println("t"+ (match[i]+1)+" - r"+(i+1));
			 }
		 }
	}

	private static boolean bpm(int[][] bpGraph, int[] matchR, int i, boolean[] visited) {
		for(int j = 0;j <v; j++) {
			if(bpGraph[i][j] > 0 && !visited[j]) {
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
