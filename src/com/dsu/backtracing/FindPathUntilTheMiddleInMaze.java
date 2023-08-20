package com.dsu.backtracing;

public class FindPathUntilTheMiddleInMaze {

	public static void main (String[] args) {

		// Creating the maze
		int[][] maze = {
				{ 3, 5, 4, 4, 7, 3, 4, 6, 3 },
				{ 6, 7, 5, 6, 6, 2, 6, 6, 2 },
				{ 3, 3, 4, 3, 2, 5, 4, 7, 2 },
				{ 6, 5, 5, 1, 2, 3, 6, 5, 6 },
				{ 3, 3, 4, 3, 0, 1, 4, 3, 4 },
				{ 3, 5, 4, 3, 2, 2, 3, 3, 5 },
				{ 3, 5, 4, 3, 2, 6, 4, 4, 3 },
				{ 3, 5, 1, 3, 7, 5, 3, 6, 4 },
				{ 6, 2, 4, 3, 4, 5, 4, 5, 1 }
		};

		// Calling the printPath function
		printPath(maze,0,0,"");
	}

	private static void printPath(int[][] maze, int i, int j, String string) {
		if(i == maze.length/2 && j == maze.length/2) {
			string += "("+i +" - "+ j+ ") -> MID";
			System.out.println(string);
			return;
		}
		
		if(maze[i][j] == 0) {
			return;
		}
		
		int k = maze[i][j];
		maze[i][j] = 0;
		
		if(j+k<maze.length) {
			printPath(maze, i, j + k, string+"("+i +" - "+ j+ ") -> ");
		}
		
		if(i+k<maze.length) {
			printPath(maze, i + k, j, string+"("+i +" - "+ j+ ") -> ");
		}
		
		if(j-k>0) {
			printPath(maze, i, j - k, string+"("+i +" - "+ j+ ") -> ");
		}
		
		if(i - k>0) {
			printPath(maze, i - k, j, string+"("+i +" - "+ j+ ") -> ");
		}
		
		maze[i][j] = k;
	}
}
