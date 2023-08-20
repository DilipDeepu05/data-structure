package com.dsu.bsearchtree;

public class ShortestDistanceBetweenTwoNodes {

	public static void main(String[] args)
	{
	    Node root = null;
	    root = insert(root, 20);
	    insert(root, 10);
	    insert(root, 5);
	    insert(root, 15);
	    insert(root, 30);
	    insert(root, 25);
	    insert(root, 35);
	    System.out.println(findDistWrapper(root, 5, 35));
	}

	private static Node insert(Node root, int data) {
		Node n = new Node(data);
		if(root == null) {
			root = n;
			return root;
		}

		if(root.data > data ) {
			root.left = insert(root.left, data);
		}

		if(root.data < data) {
			root.right = insert(root.right, data);
		}

		return root;
	}
	
	public static int findDistWrapper(Node root, int n1, int n2) {
		if(root == null) {
			return 0;
		}
		
		int temp = 0;
		if(n1 > n2) {
			temp = n1;
			n1 = n2;
			n2 = temp;
		}
		
		return findDistUtil(root, n1, n2);
	}

	private static int findDistUtil(Node root, int n1, int n2) {
		if(root == null) {
			return 0;
		}
		
		if(root.data > n1 && root.data > n2) {
			return findDistUtil(root.left, n1, n2);
		} 
		
		if(root.data < n1 && root.data < n2) {
			return findDistUtil(root.right, n1, n2);
		}
		
		if(root.data >= n1 && root.data <= n2) {
			System.out.println(distance(root, n1));
			return distance(root, n1) + distance(root, n2);
		}
		
		return 0;
	}
	
	public static int distance(Node root, int n) {
		if(root.data == n) {
			return 0;
		}
		
		if(root.data > n) {
			return 1 + distance(root.left, n);
		}
		return 1 + distance(root.right, n);
	}
}
