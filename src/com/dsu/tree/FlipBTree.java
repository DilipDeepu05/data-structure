package com.dsu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlipBTree {

	public static void main(String args[])
	{
	    Node root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.right.left = new Node(4);
	    root.right.right = new Node(5);
	 
	    System.out.print("Level order traversal " +
	                            "of given tree\n");
	    printLevelOrder(root);
	 
	    root = flipBinaryTree(root);
	 
	    System.out.print("\nLevel order traversal " +
	                        "of the flipped tree\n");
	    printLevelOrder(root);
	}

	private static Node flipBinaryTree(Node root) {
		if(root == null) {
			return null;
		}
		Node temp = null;
		Node prev = null;
		Node next = null;
		Node curr = root;
		
		while(curr != null) {
			next = curr.left;
			
			curr.left = temp;
			
			temp = curr.right;
			
			curr.right = prev;
			
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static void printLevelOrder(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			System.out.print(curr.key+ " ");
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
	}
}
