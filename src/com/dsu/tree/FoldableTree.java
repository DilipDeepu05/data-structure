package com.dsu.tree;

public class FoldableTree {

	Node root;
	public static void main(String args[])
	{
		FoldableTree tree = new FoldableTree();

		/* The constructed binary tree is
	             1
	           /   \
	          2     3
	           \    /
	            4  5
		 */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(4);
		tree.root.left.right = new Node(5);

		if (tree.IsFoldable(tree.root))
			System.out.println("tree is foldable");
		else
			System.out.println("Tree is not foldable");
	}
	
	private boolean IsFoldable(Node root) {
		return isFoldableRec(root.left, root.right);
	}

	private boolean isFoldableRec(Node a, Node b) {
		if(a == null && b == null) {
			return  true;
		}
		
		if(a == null || b ==null) {
			return false;
		}
		return isFoldableRec(a.left, b.right) && isFoldableRec(a.right, b.left);
	}
}
