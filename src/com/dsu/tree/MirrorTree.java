package com.dsu.tree;

public class MirrorTree {

	public static void main(String[] args)
	{
		MirrorTree tree = new MirrorTree();
		Node a = new Node(1);
		Node b = new Node(1);
		a.left = new Node(2);
		a.right = new Node(3);
		a.left.left = new Node(4);
		a.left.right = new Node(5);

		b.left = new Node(3);
		b.right = new Node(2);
		b.right.left = new Node(5);
		b.right.right = new Node(4);

		if (tree.areMirror(a, b) == true)
			System.out.println("Yes");
		else
			System.out.println("No");

	}

	private boolean areMirror(Node a, Node b) {
		if(a == null & b == null) {
			return true;
		}
		
		if(a == null || b == null) {
			return false;
		}
		return a.key == b.key && areMirror(a.left, b.right) && areMirror(a.right, b.left);
	}
}
