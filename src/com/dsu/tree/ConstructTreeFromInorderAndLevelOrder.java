package com.dsu.tree;

public class ConstructTreeFromInorderAndLevelOrder {

	class Node {
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

	public static void main(String args[])
	{
		ConstructTreeFromInorderAndLevelOrder tree = new ConstructTreeFromInorderAndLevelOrder();
		int[] in = new int[] { 4, 8, 10, 12, 14, 20, 22 };
		int[] level = new int[] { 20, 8, 22, 4, 12, 10, 14 };
		Node node = tree.buildTree(in, level);

		System.out.print("Inorder traversal of the constructed tree is ");
		tree.printInOrder(node);
	}

	private void printInOrder(Node root) {
		if(root != null) {
			printInOrder(root.left);
			System.out.print(root.key+" ");
			printInOrder(root.right);
		}
	}

	private Node buildTree(int[] in, int[] level) {
		Node startNode = null;
		return constructTree(startNode, in, level, 0, in.length - 1);
	}

	private Node constructTree(Node startNode, int[] in, int[] level, int start, int end) {
		if(start > end) 
			return null;
		if(start == end) {
			return new Node(in[start]);
		}
		
		int index = 0;
		boolean found = false;
		int data = 0;
		
		for(int i = 0; i < level.length; ++i) {
			data = level[i];
			for(int j = start; j < end; ++j) {
				if(in[j] == data) {
					index = j;
					startNode = new Node(data);
					found = true;
					break;
				}
			}
			
			if(found) 
				break;
		}
		
		startNode.setLeft(constructTree(startNode, in , level, start, index - 1));
		startNode.setRight(constructTree(startNode, in, level, index + 1, end));
		
		return startNode;
	}
}
