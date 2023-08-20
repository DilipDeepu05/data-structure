package com.dsu.backtracing;

public class MColoring {

	static int V = 4;

	/* A utility function to print solution */
	static void printSolution(int[] color)
	{
		System.out.println(
				"Solution Exists:"
						+ " Following are the assigned colors ");
		for (int i = 0; i < V; i++)
			System.out.print("  " + color[i]);
		System.out.println();
	}

	public static void main(String[] args)
	{

		/* Create following graph and
	            test whether it is 3 colorable
	            (3)---(2)
	            | / |
	            | / |
	            | / |
	            (0)---(1)
		 */
		boolean[][] graph = {
				{ false, true, true, true },
				{ true, false, true, false },
				{ true, true, false, true },
				{ true, false, true, false },
		};
		int m = 3; // Number of colors

		// Initialize all color values as 0.
		// This initialization is needed
		// correct functioning of isSafe()
		int[] color = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = 0;

		// Function call
		if (!graphColoring(graph, m, 0, color))
			System.out.println("Solution does not exist");
	}

	private static boolean graphColoring(boolean[][] graph, int m, int d, int[] color) {
		if(d == V) {
			if(isSafeColor(graph, color)) {
				printSolution(color);
				return true;
			}
			return false;

		} else {
			for(int i =1 ;i <= m; i++) {
				color[d] = i;
				
				if(graphColoring(graph, m, d + 1, color)) return true;
				
				color[d] = 0;
			}
		}
		return false;
	}

	private static boolean isSafeColor(boolean[][] graph, int[] color) {
		for(int i = 0; i < V; i++) {
			for(int j = i + 1; j < V; j++) {
				if(graph[i][j] && color[j] == color[i]) {
					return false;
				}
			}
		}
		return true;
	}
}
