package com.dsu.singlyLL;

public class TwoDLl {

	public static void main(String args[])
    {
        // 2D matrix
        int arr[][] = { { 1, 2, 3, 0 },
                        { 4, 5, 6, 1 },
                        { 7, 8, 9, 2 },
                        { 7, 8, 9, 2 } };
        int m = 4, n = 4;
        // List<List<Node>> arr = new
        // ArrayList<List<Node>>();
        Node[][] visited = new Node[m][n];
        Node head = construct(arr, 0, 0, m, n, visited);
        display(head);
    }
	
	private static void display(Node head) {
		Node r;
		Node d = head;
		while( d != null) {
			r = d;
			while( r != null) {
				System.out.print(r.data+ " ");
				r= r.right;
			}
			System.out.println();
			d = d.down;
		}
		
	}

	private static Node construct(int[][] arr, int i, int j, int m, int n, Node[][] visited) {
		if( i > m -1 || j > n -1) return null;
		
		if(visited[i][j] != null) {
			return visited[i][j];
		}
		
		Node temp = new Node();
		temp.data = arr[i][j];
		visited[i][j] = temp;
		
		temp.right = construct(arr, i, j+1, m,n, visited);
		temp.down = construct(arr, i+1, j ,m, n, visited);
		
		return temp;
	}

	static class Node {
		int data;
		Node right;
		Node down;
	}
}
