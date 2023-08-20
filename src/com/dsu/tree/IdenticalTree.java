package com.dsu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTree {

	public static void main(String[] args)
	{
		// Create the first tree
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		// Create the second tree
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		// Check if the trees are identical or not
		if (isIdentical(root1, root2)) {
			System.out.println("The trees are identical");
		}
		else {
			System.out.println(
					"The trees are not identical");
		}
	}

	private static boolean isIdentical(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null  || root2 == null) {
			return false;
		}
		
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		q1.add(root1);
		q2.add(root2);
		
		while(!q1.isEmpty() || !q2.isEmpty()) {
			Node a = q1.poll();
			Node b = q2.poll();
			
			if(a.right == null && b.right !=null   || a.right != null && b.right == null) {
				return false;
			}
			
			if(a.left == null && b.left !=null   || a.left != null && b.left == null) {
				return false;
			}
			
			if(a.key != b.key) {
				return false;
			}
			
			if(b.left !=null && a.left != null) {
				q1.add(a.left);
				q2.add(b.left);
			}
			
			if(a.right != null && b.right != null) {
				q1.add(a.right);
				q2.add(b.right);
			}
		}
		return true;
	}
}
