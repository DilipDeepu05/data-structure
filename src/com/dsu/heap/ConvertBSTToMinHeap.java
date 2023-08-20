package com.dsu.heap;

import java.util.ArrayList;
import java.util.List;

import com.dsu.heap.CheckIfBinaryHeap.Node;

public class ConvertBSTToMinHeap {

	public static void main(String[] args)
	{

		// BST formation
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);

		System.out.print(
				"Preorder Traversal Before Conversion :"
						+ "\n");
		preOrder(root);

//		// Function call
//		convertToMinHeap(root);
//
//		System.out.print("\nPreorder Traversal After Conversion min heap:"
//				+ "\n");
//		preOrder(root);

		convertToMaxHeap(root);

		System.out.print("\nPreorder Traversal After Conversion max heap:"
				+ "\n");
		postorderTraversal(root);
	}

	private static void convertToMaxHeap(Node root) {
		if(root == null) {
			return;
		}

		List<Integer> ls = new ArrayList<>();
		bstToArray(root, ls);

		maxHeap(root, ls);
	}
	
	static void postorderTraversal(Node root)
	{
	    if (root == null)
	        return;
	 
	    // recur on left subtree
	    postorderTraversal(root.left);
	 
	    // then recur on right subtree
	    postorderTraversal(root.right);
	 
	    // print the root's data
	    System.out.print(root.data + " ");
	}

	static int j;
	private static void maxHeap(Node root, List<Integer> ls) {
		if(root == null) {
			return; 
		}

		maxHeap(root.left, ls);
		maxHeap(root.right, ls);
		root.data = ls.get(j++);
	}

	private static void convertToMinHeap(Node root) {
		if(root == null) {
			return;
		}

		List<Integer> ls = new ArrayList<>();
		bstToArray(root, ls);

		minHeap(root, ls);
	}

	static int i;
	private static void minHeap(Node root, List<Integer> ls) {
		if(root == null) {
			return;
		}

		root.data = ls.get(i++);
		minHeap(root.left, ls);
		minHeap(root.right, ls);
	}

	private static void bstToArray(Node root, List<Integer> ls) {
		if(root != null) {
			bstToArray(root.left, ls);
			ls.add(root.data);
			bstToArray(root.right, ls);
		}
	}

	private static void preOrder(Node root) {
		if(root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
