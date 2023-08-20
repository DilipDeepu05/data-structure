package com.dsu.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLevelOfGraph {

	public static void main(String[] args)
	{
		int V = 5;
		int[][] edges
		= { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 } };
		int X = 3;

		// Function call
		int level = findLevel(V, edges, X);
		System.out.println(level);
	}

	private static int findLevel(int v, int[][] edges, int x) {
		int max = 0;
		for(int i[]: edges) {
			max= Math.max(max, Math.max(i[0], i[1]));
		}

		List<Integer>[] ls = new ArrayList[max+1];

		for(int i =0;i <= max; i++) {
			ls[i] = new ArrayList<>(); 
		}

		for(int i =0; i < edges.length; i++) {
			ls[edges[i][0]].add(edges[i][1]);
			ls[edges[i][1]].add(edges[i][0]);
		}

		if(x > max || ls[x].size() == 0)
			return -1;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		int level = 0;
		
		boolean visited[] = new boolean[max+1];
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int s  = queue.size();
			while(s-- > 0) {
				int d = queue.poll();
				
				if(x == d)
					return level;
				
				for(int i: ls[d]) {
					if(!visited[d]) {
						visited[d] = true;
						queue.add(d);
					}
				}
			}
			level++;
		}
		return -1;
	}
}
