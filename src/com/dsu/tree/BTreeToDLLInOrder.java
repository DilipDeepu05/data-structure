package com.dsu.tree;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

public class BTreeToDLLInOrder {

	Node root;
	public static void main(String[] args) 
	{
		BTreeToDLLInOrder tree = new BTreeToDLLInOrder();

		// Let us create the tree shown in above diagram
		tree.root = new Node(10);
		tree.root.left = new Node(12);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(25);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(36);

		// Convert to DLL
		Node head = tree.bintree2list(tree.root);

		// Print the converted list
		tree.printList(head);
	}

	private Node bintree2list(Node root) {
		if(root == null) {
			return root;
		}

		Node n = binTree2DLL(root);

		while(n.left != null) {
			n = n.left;
		}
		
		return n;
	}

	private Node binTree2DLL(Node root) {
		if(root == null) {
			return root;
		}
		
		if(root.left != null) {
			Node l = binTree2DLL(root.left);
			System.out.println(l.data);
			for(;l.right != null; l = l.right);
			System.out.println(l.data);
			l.right = root;
			
			root.left = l;
		}
		
		if(root.right != null) {
			Node r = binTree2DLL(root.right);
			
			for(;r.left != null; r = r.left);
			
			r.left = root;
			
			root.right = r;
		}
		
		return root;
	}

	private void printList(Node head) {
		while(head != null) {
			System.out.print(head.data+ " ");
			head = head.right;
		}
	}
}