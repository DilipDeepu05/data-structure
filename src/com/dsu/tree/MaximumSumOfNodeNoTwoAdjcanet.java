package com.dsu.tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumSumOfNodeNoTwoAdjcanet {

	public static void main(String args[])
	{
		Node root = new Node(10);
		root.left = new Node(1);
		root.left.left = new Node(2);
		root.left.left.left = new Node(1);
		root.left.right = new Node(3);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(5);
		System.out.println(maxSum(root));
	}

	static Map<Node, Integer> m = new HashMap<>();
	private static int maxSum(Node root) {
		if(root == null) {
			return 0;
		}

		if(m.containsKey(root)) {
			return m.get(root);
		}

		int in = root.key;

		if(root.left != null) {
			in += maxSum(root.left.left) + maxSum(root.left.right);
		}

		if(root.right != null) {
			in += maxSum(root.right.left) + maxSum(root.right.right);
		}

		int ex = maxSum(root.left) + maxSum(root.right);

		m.put(root, Math.max(ex, in));

		return Math.max(ex, in);
	}
}
