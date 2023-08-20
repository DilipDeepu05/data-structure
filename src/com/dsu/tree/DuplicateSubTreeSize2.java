package com.dsu.tree;

import java.util.HashSet;
import java.util.Set;

public class DuplicateSubTreeSize2 {

	static class Node {
		int data;
		Node left,right;
		Node(int data)
		{
			this.data=data;
		}
	}

	static Node root;
	public static void main(String args[])
	{
		root = new Node('A');
		root.left = new Node('B');
		root.right = new Node('C');
		root.left.left = new Node('D');
		root.left.right = new Node('E');
		root.right.right = new Node('B');
		root.right.right.right = new Node('E');
		root.right.right.left= new Node('D');
		String str = dupSub(root);
		if(str.equals(""))
			System.out.print(" Yes ");
		else   
			System.out.print(" No ");
	}

	private static String dupSub(Node root) {
		Set<String> s = new HashSet<>();
		return duplicateSubTree(root, s);
	}

	private static String duplicateSubTree(Node root, Set<String> s) {
		if(root == null) {
			return "$";
		}
		String s1= "";
		
		String l = duplicateSubTree(root.left, s);
		if(l.equals(s1)) {
			return s1;
		}
		
		String r = duplicateSubTree(root.right, s);
		if(r.equals(s1)) return s1;
	
		s1 = s1 + root.data + "%" + l + "%" + r;

		if(s1.length() > 7 && s.contains(s1)) {
			return "";
		}
		s.add(s1);
		return s1;
	}
}
