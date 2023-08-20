package com.dsu.tree;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

public class TreeIsASubTree {

	public static void main(String[] args) {
		/*Creating the root tree*/
		Node root = new Node(3);
		root.left = new Node(4);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(2);

		/*Creating the subroot tree */
		Node subRoot = new Node(4);
		subRoot.left = new Node(1);
		subRoot.right = new Node(2);

		// creating one instance of obj
		TreeIsASubTree myObj = new TreeIsASubTree();

		System.out.println("Our Tree1 and Tree2 Looks like:\n");
		System.out.print("\nTree1: ");
		myObj.inOrderTraversal(root);
		System.out.print("\nTree2: ");
		myObj.inOrderTraversal(subRoot);
		// Calling the isSubtree function
		if (myObj.isSubtree(root, subRoot))
			System.out.println("\nYes Tree2 is subroot of Tree1\n");
		else
			System.out.println("\nNo  Tree2 is not Subtree of Tree1\n");
	}

	private boolean isSubtree(Node root, Node subRoot) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		isPreOrder(root, sb1);
		isPreOrder(subRoot, sb2);

		if(sb1.indexOf(sb2.toString()) >= 0) return true;
		return false;
	}

	private void isPreOrder(Node root, StringBuilder sb) {
		if(root == null) {
			sb.append(",#");
			return;
		}

		sb.append(","+root.data);
		isPreOrder(root.left, sb);
		isPreOrder(root.right, sb);
	}

	private void inOrderTraversal(Node root) {
		if(root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data+ " ");
			inOrderTraversal(root.right);
		}
	}
}
