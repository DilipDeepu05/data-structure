package com.dsu.tree;

public class BTreeSize {

	static Node root;
	public static void main(String args[])
	{
		/* creating a binary tree and entering the nodes */
		BTreeSize tree = new BTreeSize();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("The size of binary tree is : "
				+ tree.size(root));
	}
	
	private int size(Node root) {
		if(root == null) {
			return 0;
		}
		return size(root.left) + 1 + size(root.right);
	}
}
