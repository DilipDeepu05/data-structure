package com.dsu.CircularDoublyLL;

public class CircularDLL {
	static Node head = null;

	static class Node {
		Node next, prev;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		/* Start with the empty list */

		// Insert 5. So linked list becomes 5.null
		insertEnd(5);

		// Insert 4 at the beginning. So linked
		// list becomes 4.5
		insertBegin(4);

		// Insert 7 at the end. So linked list
		// becomes 4.5.7
		insertEnd(7);

		// Insert 8 at the end. So linked list
		// becomes 4.5.7.8
		insertEnd(8);

		// Insert 6, after 5. So linked list
		// becomes 4.5.6.7.8
		insertAfter(6, 5);

		System.out.println("Created circular doubly linked list is: ");
		display();
	}

	private static void display() {
		Node curr = head;

		System.out.println("Traverse forward: ");

		while(curr.next != head) {
			System.out.print(curr.data+" -> ");
			curr = curr.next;
		}
		System.out.print(curr.data);
		System.out.println();
		System.out.println("Traverse reverse: ");
		Node last = head.prev;
		curr = last;

		while(curr.prev != last) {
			System.out.print(curr.data+" <- ");
			curr = curr.prev;
		}
		System.out.print(curr.data+" <- ");
		System.out.println();
	}

	private static void insertAfter(int i, int j) {
		Node n = new Node(i);

		Node curr = head;
		while(curr.data != j) {
			curr = curr.next;
		}

		n.next = curr.next;
		curr.next.prev = n;
		n.prev = curr;
		curr.next = n;
	}

	private static void insertEnd(int i) {
		Node n = new Node(i);

		if(head == null) {
			insertBegin(i);
			return;
		}

		Node last = head.prev;
		last.next = n;
		n.prev = last;
		n.next = head;
		head.prev = n;
	}

	private static void insertBegin(int i) {
		Node n = new Node(i);

		if(head == null) {
			n.prev = n.next = n;
			head = n;
			return;
		}

		Node last = head.prev;
		n.next = head;
		n.prev = last;
		head.prev = last.next = n;
		head = n;
	}
}
