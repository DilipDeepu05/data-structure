package com.dsu.tree;

public class SumTree {

	static class Node {
		int key;
		Node left;
		Node right;
		Node(int key) {
			this.key = key;
		}

		void setLeft(Node n) {
			this.left = n;
		}

		void setRight(Node n) {
			this.right = n;
		}
	}

	Node root = null;
	
	public static void main(String args[])
	{
		SumTree tree = new SumTree();
		tree.root = new Node(26);
		tree.root.left = new Node(10);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(3);

		if (tree.isSumTree(tree.root) != 0)
			System.out.println("The given tree is a SumTree");
		else
			System.out.println("The given tree is not a SumTree");
	}

	private int isLeaf(Node root) {
		if(root == null) {
			return 0;
		} 
		
		if(root.left == null && root.right == null) {
			return 1;
		}
		
		return 0;
	}
	private int isSumTree(Node root) {
//		if(root == null || isLeaf(root) == 1) {
//			return 1;
//		}
//		
//		int l = 0;
//		int r = 0;
//		if(isSumTree(root.left) != 0 && isSumTree(root.right) != 0) {
//			if(root.left == null) {
//				l = 0;
//			} else if(isLeaf(root.left) != 0) {
//				l = root.left.key;
//			} else {
//				l = 2 * (int)root.left.key;
//			}
//			
//			if(root.right == null) {
//				r = 0;
//			} else if(isLeaf(root.right) != 0) {
//				r = root.right.key;
//			} else {
//				r = 2 * root.right.key;
//			}
//			
//			if(root.key == r + l) {
//				return 1;
//			} else {
//				return 0;
//			}
//		}
		
		
		if(root == null || isLeaf(root) == 1) {
			return 1;
		}
		
		int l = isSumTree(root.left);
		if(l == -1) {
			return -1;
		}
		
		int r = isSumTree(root.right);
		if(r == -1) return -1;
		
		if(isLeaf(root) == 1 || root.key == l + r) {
			return l + r + root.key;
		} else {
			return -1;
		}
	}
}
