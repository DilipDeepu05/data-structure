package com.dsu.circularLL;

public class CircularLL {
	public static void main(String[] args)	{
		/* Start with the empty list */
		CircularList llist = new CircularList();

		llist.start(1);
		llist.end(6);
		llist.start(7);
		llist.end(4);
		llist.start(2);
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		llist.exchangeNodes();
		System.out.println("Exchange First and last ciruclar list");
		llist.printList();

		System.out.println("Split the ciruclar list");
		llist.splitTwoHalf();

		System.out.println("Is it Circular linked list: "+ llist.isCircular());

	}
}

class CircularList {
	Node head;
	Node h1;
	Node h2;

	static class Node {
		int data;
		Node next;
		Node(int data) {
			this.data= data;
			this.next = null;
		}
	}

	public void start(int i) {
		Node n = new Node(i);
		if(head == null) {
			head = n;
			head.next = head;
		} else {
			Node curr = head;

			while(curr.next != head) {
				curr = curr.next;
			}

			n.next = head;
			curr.next = n;
			head = n;
		}
	}

	public void exchangeNodes() {
		if (head == null || head.next == null) {
			return;
		}
		Node tail = head;

		// Find pointer to the last node
		while (tail.next != head) {
			tail = tail.next;
		}
		/* Exchange first and last nodes using
		       head and p */

		// temporary variable to store
		// head data
		int temp = tail.data;
		tail.data = head.data;
		head.data = temp;

	}

	public boolean isCircular() {
		Node curr = head.next;

		while( curr != null && curr != head) {
			curr =curr.next;
		}

		return curr == head;
	}


	public void splitTwoHalf() {
		Node f = head;
		Node s = head;

		while(f.next != head && f.next.next != head) {
			s= s.next;
			f = f.next.next;
		}

		if(f.next.next == head) {
			f = f.next;
		}

		h1 = head;
		h2 = s.next;

		f.next = s.next;
		s.next = head;

		System.out.println("First half: ");
		printList(h1);
		System.out.println("Second half: ");
		printList(h2);
	}


	public void printList(Node node) {
		if(node == null) return;
		Node temp = node;

		do {
			System.out.print(temp.data+ " -> ");
			temp = temp.next;
		} while(temp != node);	

		System.out.println();
	}

	public void printList() {
		if(head == null) {
			System.out.println("Empty");
		} else {
			Node temp = head;
			do {
				System.out.printf("%d ", temp.data);
				temp = temp.next;
			} while (temp != head);
			System.out.println();
		}
	}

	public void insertAfter(Node n1, int i) {
		Node n = new Node(i);
		if(n1 == null) {
		} else {
			Node curr = head;
			while(curr.next != n1) {
				curr = curr.next;
			}

			n.next = curr.next;
			curr.next = n;
		}
	}

	public void end(int i) {
		Node n = new Node(i);
		if(head == null) {
			head = n;
			head.next = head;
		} else {
			Node curr = head;
			while(curr.next != head) {
				curr = curr.next;
			}

			curr.next = n;
			n.next = head;
		}

	}
}