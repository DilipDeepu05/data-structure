package com.dsu.bsearchtree;

import java.util.HashSet;
import java.util.Set;

public class PairOfTwo {

	public static void main(String[] args){
	    Node root = new Node(15);
	    root.left = new Node(10);
	    root.right = new Node(20);
	    root.left.left = new Node(8);
	    root.left.right = new Node(12);
	    root.right.left = new Node(16);
	    root.right.right = new Node(25);

		int sum = 33;
		findPair(root, sum);
	}

	private static void findPair(Node root, int sum) {
		Set<Integer> s =new HashSet<>();
		
		if(!find(root, sum, s)) {
			System.out.println("not found");
		}
	}

	private static boolean find(Node root, int sum, Set<Integer> s) {
		if(root == null) {
			return false;
		}
		
		if(find(root.left, sum, s)) return true;
		
		if(s.contains(sum - root.data)) {
			System.out.println("pair found: "+ root.data+ " " + (sum -root.data));
			return true;
		} else {
			s.add(root.data);
		}
		
		return find(root.right, sum, s);
	}

	private static Node insert(Node root, int i) {
		if(root == null) {
			return new Node(i);
		}
		
		if(i < root.data) {
			root.left = insert(root.left, i);
		} else {
			root.right = insert(root.right, i);
		}
		
		return root;
	}
}
