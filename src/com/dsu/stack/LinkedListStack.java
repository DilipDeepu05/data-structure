package com.dsu.stack;

public class LinkedListStack {

	public static void main(String[] args) {

		StackAsLinkedList sll = new StackAsLinkedList();

		sll.push(10);
		sll.push(20);
		sll.push(30);
		sll.push(40);
		sll.push(50);
		System.out.println(sll.pop()
				+ " popped from stack");

		System.out.println("Top element is " + sll.peek());
		sll.display();
	}
}

class StackAsLinkedList {

	StackNode root;

	static class StackNode {
		StackNode next;
		int data;

		StackNode(int data) {
			this.data = data;
		}
	}

	void push(int x) {
		StackNode newNode = new StackNode(x);

		if(root == null) {
			root = newNode;
		} else {
			StackNode temp = root;
			root = newNode;
			root.next = temp;
		}
	}

	int pop() {
		if(root == null) {
			return Integer.MIN_VALUE;
		} else {
			StackNode temp = root;
			root = root.next;
			return temp.data;
		}
	}

	int peek() {
		if(root == null) {
			return Integer.MIN_VALUE;
		} else {
			return root.data;
		}
	} 

	boolean isEmpty() {
		return root == null;
	}

	void display() {
		StackNode top = root;
		while(top != null) {
			System.out.println(top.data+ " -> ");
			top = top.next;
		}
	}
}