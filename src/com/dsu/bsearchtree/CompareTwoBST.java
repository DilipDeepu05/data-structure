package com.dsu.bsearchtree;

import java.util.HashSet;
import java.util.Set;

public class CompareTwoBST {

	public static void main(String[] args)
	{
		// First BST
		Node root1 = new Node(15);
		root1.left = new Node(10);
		root1.right = new Node(20);
		root1.left.left = new Node(5);
		root1.left.right = new Node(12);
		root1.right.right = new Node(25);

		// Second BST
		Node root2 = new Node(15);
		root2.left = new Node(12);
		root2.right = new Node(20);
		root2.left.left = new Node(5);
		root2.left.left.right = new Node(10);
		root2.right.right = new Node(25);

		// check if two BSTs have same set of elements
		if (checkBSTs(root1, root2))
			System.out.print("YES");
		else
			System.out.print("NO");
	}

	private static boolean checkBSTs(Node root1, Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null && root2 != null || root1 != null &&  root2 == null) {
			return false;
		}

		Set<Integer> s1 = new HashSet<>();
		Set<Integer> s2 = new HashSet<>();
		insertToSet(root1, s1);
		insertToSet(root2, s2);

		return s1.equals(s2);
	}    


	private static void insertToSet(Node root, Set<Integer> s) {
		if(root != null) {
			insertToSet(root.left, s);
			s.add(root.data);
			insertToSet(root.right, s);
		}
	}
}