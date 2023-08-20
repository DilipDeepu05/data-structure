package com.dsu.tree;

public class CheckPerfectBTree {

	static class Node
	{
	    int key;
	    Node left, right;
	}
	
	static Node newNode(int k)
	{
	    Node node = new Node();
	    node.key = k;
	    node.right = null;
	    node.left = null;
	    return node;
	}
	
	public static void main(String args[])
	{
	    Node root = null;
	    root = newNode(10);
	    root.left = newNode(20);
	    root.right = newNode(30);
	 
	    root.left.left = newNode(40);
	    root.left.right = newNode(50);
	    root.right.left = newNode(60);
	    root.right.right = newNode(70);
	 
	    if (isPerfect(root) == true)
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}

	private static boolean isPerfect(Node root) {
		if(root == null) {
			return false;
		}
		
		int d = depth(root);
		return isPerfectRec(root, d, 0);
	}

	private static boolean isPerfectRec(Node root, int d, int level) {
		if(root == null) {
			return true;
		}
		
		if(root.left == null && root.right == null) {
			return d == level + 1;
		}
		
		if(root.left == null || root.right == null) {
			return false;
		}

		return isPerfectRec(root.left, d, level + 1) && isPerfectRec(root.right, d, level + 1);
	}

	private static int depth(Node root) {
		int d = 0;
		while(root != null) {
			d++;
			root = root.left;
		}
		return d;
	}
}


