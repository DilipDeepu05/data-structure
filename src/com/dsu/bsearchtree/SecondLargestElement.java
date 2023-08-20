package com.dsu.bsearchtree;

public class SecondLargestElement {

	public static void main(String[] args) {

		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		// find the second largest element
		int secondLargest = findSecondLargest(root);
		System.out.println("Second largest value: " + secondLargest);
		
		 System.out.println(maximumElement(root, 7, 1));
	}

	private static int maximumElement(Node root, int i, int j) {
		if(root == null) {
			return 0;
		}
		while((root.data > i && root.data > j) || (root.data < i && root.data < j)) {
			if(i < root.data && j < root.data) {
				root = root.left;
			} else if(i > root.data && j > root.data) {
				root = root.right;
			}
		}
		return Math.max(max(root, i) , max(root, j));
	}

	private static int max(Node root, int n) {
		Node curr = root;
		int max = -1;
		while(curr.data != n) {
			if(curr.data > n) {
				max = Math.max(max, curr.data);
				curr = curr.left;
			} else {
				max = Math.max(max, curr.data);
				curr = curr.right;
			}
		}
		return Math.max(max, n);
	}

	private static int findSecondLargest(Node root) {
		Node parent = null;
		Node curr = root.right;

		while(curr.right != null) {
			parent = curr;
			curr = curr.right;
		}

		if(curr.left != null) {
			curr = curr.left;

			while(curr.right != null) {
				curr =curr.right;
			}
			return curr.data;
		} else {
			return parent.data;
		}
	}
}
