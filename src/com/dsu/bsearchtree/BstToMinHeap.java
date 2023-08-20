package com.dsu.bsearchtree;

import java.util.ArrayList;
import java.util.List;

public class BstToMinHeap {

	public static void main(String[] args)
	{
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		System.out.print("Preorder Traversal Before Conversion :"
				+ "\n");
		preOrder(root);

		convertToMinHeap(root);

		System.out.print("\nPreorder Traversal After Conversion :"
				+ "\n");
		preOrder(root);
	}

	private static void convertToMinHeap(Node root) {
		List<Integer> ls = new ArrayList<>();

		treeToArr(root, ls);
		bstToMinHeap(root, ls);
	}

	private static void treeToArr(Node root, List<Integer> ls) {
		if(root != null) {

			treeToArr(root.left, ls);
			ls.add(root.data);
			treeToArr(root.right, ls);
		}
	}

	static int index;
	private static Node bstToMinHeap(Node root, List<Integer> ls) {
		if(root == null) {
			return null;
		}

		root.data  = ls.get(index++);

		bstToMinHeap(root.left, ls);
		bstToMinHeap(root.right, ls);

		return root;
	}

	private static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
