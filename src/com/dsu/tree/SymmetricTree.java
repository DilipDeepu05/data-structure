package com.dsu.tree;

public class SymmetricTree {

	Node root;

	public static void main(String args[])
	{
		SymmetricTree tree = new SymmetricTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(4);
		tree.root.right.right = new Node(3);
		boolean output = tree.isSymmetric();
		if (output == true)
			System.out.println("Symmetric");
		else
			System.out.println("Not symmetric");
	}

	private boolean isSymmetric() {
		return isSymmetricRec(root, root);
	}

	private boolean isSymmetricRec(Node a, Node b) {
		if(a == null && b == null) {
			return true;
		}
		
		if(a == null || b == null) {
			return false;
		}
		return a.key == b.key && isSymmetricRec(a.left, b.right) && isSymmetricRec(a.right, b.left);
	}
}
