package com.dsu.bsearchtree;

public class PreOrderToBST {

	public static void main(String[] args)
	{
		PreOrderToBST tree = new PreOrderToBST();
		int pre[] = new int[] { 10, 5, 1, 7, 40, 50 };
		int size = pre.length;

		Node root = tree.constructTree(pre, size);
		tree.printInorder(root);
	}

	private Node constructTree(int[] pre, int size) {	
		return construct(pre, size, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	static int i;
	private Node construct(int[] pre, int size, int key, int min, int max) {
		if(i >= size) {
			return null;
		}

		Node root = null;

		if(key > min && key < max) {
			root = new Node(key);
			i++;
			if(i < size) {
				root.left = construct(pre, size, pre[i], min, key);
			}

			if(i < size) {
				root.right = construct(pre, size, pre[i], key, max);
			}
		}
		return root;
	}

	private void printInorder(Node root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data+ " ");
			printInorder(root.right);
		}
	}
}
