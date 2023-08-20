package com.dsu.tree;

import java.util.Stack;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

class PR {
	Node node;
	String path;
	PR(Node n, String p) {
		node = n;
		path = p;
	}
}

public class FromRootToLeafPath {

	public static void main(String[] args)
	{
		// create a tree
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);

		printRootToLeaf(root);
	}

	private static void printRootToLeaf(Node root) {
		String p = "";
		Stack<PR> s = new Stack<>();
		s.push(new PR(root, p));
		
		while(!s.isEmpty()) {
			PR pr = s.pop();
			
			root = pr.node;
			p = pr.path;
			
			p += root.data + " ";
			
			if(root.left == null && root.right == null) {
				System.out.println(p);
			}
			
			if(root.right != null) {
				s.push(new PR(root.right, p));
			}
			
			if(root.left != null) {
				s.push(new PR(root.left, p));
			}
		}
	}
}
