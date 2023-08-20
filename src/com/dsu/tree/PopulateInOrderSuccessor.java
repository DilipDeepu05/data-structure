package com.dsu.tree;

class Node1 {
	int data;
	Node1 left, right, next;
	Node1(int key) {
		data = key;
	}
}

public class PopulateInOrderSuccessor {

	Node1 root, next;

	public static void main(String args[])
	{
		/* Constructed binary tree is
	            10
	           /   \
	          8      12
	         /
	        3    */
		PopulateInOrderSuccessor tree = new PopulateInOrderSuccessor();
		tree.root = new Node1(10);
		tree.root.left = new Node1(8);
		tree.root.right = new Node1(12);
		tree.root.left.left = new Node1(3);

		// Populates nextRight pointer in all nodes
		tree.populateNext(tree.root);

		// Let us see the populated values
		Node1 ptr = tree.root.left.left;
		while (ptr != null) {
			// -1 is printed if there is no successor
			int print
			= ptr.next != null ? ptr.next.data : -1;
			System.out.println("Next of " + ptr.data
					+ " is: " + print);
			ptr = ptr.next;
		}
	}

	private void populateNext(Node1 root) {
		if(root != null) {
			populateNext(root.right);
			
			root.next = next;
			
			next = root;
			
			populateNext(root.left);
		}
	}
}