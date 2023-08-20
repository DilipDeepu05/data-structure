package com.dsu.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

public class IsBTreeComplete {

	public static void main(String[] args)
	{

		/* Let us construct the following Binary Tree which
	          is not a complete Binary Tree
	                1
	              /   \
	             2     3
	            / \     \
	           4   5     6
		 */

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		if(isCompleteBT(root))
			System.out.println("Complete Binary Tree");
		else
			System.out.println("NOT Complete Binary Tree");
	}

	private static boolean isCompleteBT(Node root) {
		if(root == null) {
			return true;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			if(curr.left != null) {
				q.add(curr.left);
			}
			
			if(curr.right != null) {
				q.add(curr.right);
			}
				System.out.println(curr.data);
			if((curr.left == null && curr.right != null) || (curr.left !=null && curr.right == null)) {
				return false;
			}
		}
		return true;
	}
}
