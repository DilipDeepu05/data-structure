package com.dsu.tree;

import java.util.LinkedList;
import java.util.Queue;

class ListNode
{
	int data;
	ListNode next;
	ListNode(int d)
	{
		data = d;
		next = null;
	}
}

public class BTreeFromLinkedList {

	ListNode head;
	Node root;

	void push(int new_data)
	{
		// allocate node and assign data
		ListNode new_node = new ListNode(new_data);

		// link the old list of the new node
		new_node.next = head;

		// move the head to point to the new node
		head = new_node;
	}


	public static void main(String[] args)
	{
		BTreeFromLinkedList tree = new BTreeFromLinkedList();
		tree.push(36); /* Last node of Linked List */
		tree.push(30);
		tree.push(25);
		tree.push(15);
		tree.push(12);
		tree.push(10); /* First node of Linked List */
		Node node = tree.convertList2Binary(tree.root);

		System.out.println("Inorder Traversal of the"+
				" constructed Binary Tree is:");
		tree.inorderTraversal(node);
	}


	private Node convertList2Binary(Node root) {
		if(head == null) {
			root= null;
			return null;
		}

		root = new Node(head.data);
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		head = head.next;

		while(!q.isEmpty()) {
			Node curr = q.poll();

			Node left = null, right = null;
			
			if(head != null) {
				left = new Node(this.head.data);
				q.add(left);
				head = head.next;
			}
			
			if(head != null) {
				right = new Node(head.data);
				q.add(right);
				head  = head.next;
			}

			curr.left = left;
			curr.right = right;
		}
		return root;
	}

	private void inorderTraversal(Node node) {
		if(node != null) {
			inorderTraversal(node.left);
			System.out.print(node.key+ " ");
			inorderTraversal(node.right);
		}
	}
}
