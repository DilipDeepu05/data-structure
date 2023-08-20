package com.dsu.heap;


public class CheckIfBinaryHeap {

	static class Node {
		int data;
		Node left;
		Node right;
		Node(int d) {
			data = d;
		}
	}

	public static void main(String args[])
	{
		CheckIfBinaryHeap bt
		= new CheckIfBinaryHeap();

		Node root = new Node(10);
		root.left = new Node(9);
		root.right = new Node(8);
		root.left.left = new Node(7);
		root.left.right = new Node(6);
		root.right.left = new Node(5);
		root.right.right = new Node(4);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(2);
		root.left.right.left = new Node(1);

		if (bt.isHeap(root) == true)
			System.out.println(
					"Given binary tree is a Heap");
		else
			System.out.println(
					"Given binary tree is not a Heap");
	}

	private boolean isHeap(Node root) {
		boolean res = true;

		if(root != null &&(root.left != null && root.data < root.left.data )) {
			return false;
		}

		if(root != null &&(root.right != null && root.data < root.right.data)) {
			return false;
		}


		if(root.left != null && (root.left.left != null || root.left.right != null) && root.right == null) {
			return false;
		}

		if(root.right != null && (root.right.left != null || root.right.right != null) && root.left == null) {
			return false;
		}

		if(root.left != null && (root.left.left == null && root.left.right == null)) {
			if(root.right != null && root.right.left != null && root.right.right != null) {
				return false;
			}
		}

		if(root != null && root.left != null) {
			boolean r = isHeap(root.left);
			res &= r;
		}

		if(root != null && root.right != null) {
			boolean l = isHeap(root.right);
			res &= l;
		}

		return res;
	}
}
