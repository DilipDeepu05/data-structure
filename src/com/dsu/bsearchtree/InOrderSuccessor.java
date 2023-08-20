package com.dsu.bsearchtree;


public class InOrderSuccessor {

	static class Node1 {
		int data;
		Node1 left;
		Node1 right;
		Node1 parent;
		Node1(int d) {
			data = d;
		}
	}

	public static void main(String[] args)
	{
		Node1 root = null, temp = null, suc = null, min = null;
		root = insert(root, 20);
		root = insert(root, 8);
		root = insert(root, 22);
		root = insert(root, 4);
		root = insert(root, 12);
		root = insert(root, 10);
		root = insert(root, 14);
		temp = root.left.right.right;
		suc = inOrderSuccessor(root, temp);
		if (suc != null) {
			System.out.println(
					"Inorder successor of "
							+ temp.data + " is " + suc.data);
		}
		else {
			System.out.println(
					"Inorder successor does not exist");
		}
	}

	private static Node1 inOrderSuccessor(Node1 root, Node1 temp) {
		if(root.right != null) {
			return minValue(root.right);
		}
		
		Node1 parent = temp.parent;
		while(parent != null && temp == parent.right) {
			temp = parent;
			parent = parent.parent;
		}
		return parent;
	}

	private static Node1 minValue(Node1 root) {
		Node1 curr = root;
		while(curr.left != null) {
			curr =curr.left;
		}
		return curr;
	}

	private static  Node1 insert( Node1 root, int i) {
		if(root == null) {
			return new Node1(i);
		}

		Node1 temp = null;
		if(i <= root.data) {
			temp = insert(root.left, i);
			root.left = temp;
			temp.parent = root;
		} else {
			temp = insert(root.right, i);
			root.right = temp;
			temp.parent = root;
		}

		return root;
	}

}
