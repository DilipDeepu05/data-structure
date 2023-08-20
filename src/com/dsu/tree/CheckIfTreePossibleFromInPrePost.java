package com.dsu.tree;

import java.util.HashMap;
import java.util.Map;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

public class CheckIfTreePossibleFromInPrePost {

	public static void main(String[] args)
	{
		int inOrder[] = { 4, 2, 5, 1, 3 };
		int preOrder[] = { 1, 2, 4, 5, 3 };
		int postOrder[] = { 4, 5, 2, 3, 1 };

		int len = inOrder.length;

		if (checktree(preOrder, inOrder, postOrder, len))
			System.out.println("The tree is valid");
		else
			System.out.println("The tree is not valid");
	}

	private static boolean checktree(int[] preOrder, int[] inOrder, int[] postOrder, int len) {
		Map<Integer, Integer> m = new HashMap<>();
		
		for(int i =0 ;i < inOrder.length; ++i) {
			m.put(inOrder[i], i);
		}
		
		int preIndex = 0;
		boolean isPossible[] = {false};
		
		Node n= buildTreeInPreOrder(preOrder, 0, inOrder.length - 1, m, isPossible, preIndex);
		
		return checkPostOrder(n, postOrder, 0);
	}

	private static boolean checkPostOrder(Node root, int[] postOrder, int i) {
		if(root == null) {
			return true;
		}
		
		if(!checkPostOrder(root.left, postOrder, i)) return false;
		
		if(!checkPostOrder(root.right, postOrder, i)) return false;
		
		return root.data == postOrder[i++];
	}

	private static Node buildTreeInPreOrder(int[] preOrder, int start, int end, Map<Integer, Integer> inOrder,
			boolean[] isPossible, int preIndex) {
		
		if(start > end) {
			isPossible = new boolean[] {false};
			return null;
		}
		
		int data = preOrder[preIndex++];
		Node root = new Node(data);
		
		if(!inOrder.containsKey(data)) {
			isPossible = new boolean[] {false};
			return root;
		}
		
		int in = inOrder.get(data);
		
		if( ! (start <= in && in <= end)) {
			isPossible = new boolean[] {false};
			return root;
		}
		
		int leftInOrderStart = start,
			leftInOrderStop = in - 1,
			rightInOrderStart = in + 1,
			rightInOrderStop = end;
		
		root.left = buildTreeInPreOrder(preOrder, leftInOrderStart, leftInOrderStop, inOrder, isPossible, preIndex);
		
		if(!isPossible[0]) {
			return root;
		}
		
		root.right = buildTreeInPreOrder(preOrder, rightInOrderStart, rightInOrderStop, inOrder, isPossible, preIndex);
		
		return root;
	}
}
