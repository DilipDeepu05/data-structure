package com.dsu.bsearchtree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderToBST {

	static class NodeRange {
		Node node;
		int min;
		int max;
		NodeRange(Node node, int min, int max)
		{
			this.node = node;
			this.min = min;
			this.max = max;
		}
	}
	public static void inorderTraversal(Node root)
	{
		if (root == null)
			return;
		inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args)
	{
		int[] arr = { 7, 4, 12, 3, 6, 8, 1, 5, 10 };
		Node root = constructBst(arr);

		System.out.print("Inorder Traversal: ");
		inorderTraversal(root);
	}

	private static Node constructBst(int[] arr) {
		Node root = new Node(arr[0]);
		Node head = root;
		Queue<NodeRange> q = new LinkedList<>();
		q.add(new NodeRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		int i = 1;
		while(i != arr.length && !q.isEmpty()) {
			NodeRange nr = q.poll();

			if(arr[i] > nr.min && arr[i] < nr.max) {
				if (i < arr.length &&  arr[i] < nr.node.data) {
					nr.node.left = new Node(arr[i++]);
					q.add(new NodeRange(nr.node.left, nr.min, nr.node.data));
				} 
				if(i < arr.length && arr[i] > nr.node.data) {
					nr.node.right = new Node(arr[i++]);
					q.add(new NodeRange(nr.node.right, nr.node.data , nr.max));
				}
			}

		}
		return head;
	}
}
