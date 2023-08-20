package com.dsu.singlyLL;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedL {

	public static void main(String[] args) {
		/* Start with the empty list */
		LinkedList llist = new LinkedList();

		// Insert 6.  So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		int x = 6;
		System.out.println("\nSearch Linked list contains: x = "+  x);
		if (llist.search(llist.head, x))
			System.out.println("Yes");
		else
			System.out.println("No");

		int x1 = 9;
		System.out.println("\nSearch Linked list contains: x = "+  x1);
		if (llist.search(llist.head, x1))
			System.out.println("Yes");
		else
			System.out.println("No");

		System.out.println("Count of nodes is "
				+ llist.getCount());

		System.out.println("Deleting first: ");
		llist.deleteFirst();
		llist.printList();

		System.out.println("Delete from last: ");
		llist.deleteLast();
		llist.printList();

		int d = 2;
		System.out.println("Delete from position: "+ d);

		llist.deletePosition(d);
		llist.printList();
		System.out.println("Reverse: ");
		llist.reverse();
		llist.printList();

		llist.detectLoop();

		llist.append(7);
		System.out.println("Add duplicate: ");
		llist.printList();
		System.out.println("Remove duplicate: ");
		llist.removeDuplicates();
		llist.printList();

		System.out.println("Swapping nodes: ");
		llist.swapNodes(llist.head.next.next, llist.head.next);
		llist.printList();

		System.out.println("Move to front from last: ");
		llist.moveToFront();
		llist.printList();

		System.out.println("Delete Node: ");		
		llist.deleteNode(llist.head.next);
		llist.printList();

		d =2;
		System.out.println("Swap kth node: "+ d);
		llist.swapKth(d);
		llist.printList();

		System.out.println("Add duplicate: ");
		llist.append(7);
		llist.append(8);
		llist.append(7);
		llist.printList();

		System.out.println("Remove unsorted duplicates: ");
		llist.removeUnsortedDuplicate();
		llist.printList();
		System.out.println("Quick Sort: ");
		llist.quickSortStart();
		llist.printList();
	}
}

class LinkedList {

	Node head;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			next  = null;
		}
	}


	private int length() {
		int count = 0;
		Node curr = head;
		while(curr != null) {
			count++;
			curr =curr.next;
		}
		return count;
	}

	public void quickSortStart() {
		Node curr = head;
		while( curr.next != null) {
			curr = curr.next;
		}

		quickSort(head, curr);
	}

	private void quickSort(Node start, Node end) {

		if(start == end || start == null || start == end.next)
			return;

		Node prev = parititation(start, end);
		quickSort(start, prev);

		if( prev == start) {
			quickSort(prev.next, end);
		}

		else if ( prev.next != null) {
			quickSort(prev.next.next, end);
		}
	}

	private Node parititation(Node start, Node end) {
		if(start == null || start == end || end == null)
			return start;

		Node prev = start;
		Node curr = start;
		int pivot = end.data;

		while( start != end) {
			if(start.data < pivot) {
				prev = curr;
				int temp = curr.data;
				curr.data =  start.data;
				start.data = temp;
				curr = curr.next;
			}

			start = start.next;
		}

		int temp = curr.data;
		curr.data = end.data;
		end.data = temp;

		return prev;
	}

	public void removeUnsortedDuplicate() {
		if(head == null) {
			return;
		}

		Set<Integer> s = new HashSet<>(); 
		Node curr = head;
		Node prev = null;

		while(curr != null) {
			int val = curr.data;

			if(s.contains(val)) {
				prev.next = curr.next;
			} else {
				prev = curr;
				s.add(val);
			}
			curr = curr.next;
		}
	}

	public void swapKth(int k) {
		int n = length();

		if(n < k) {
			return;
		}

		if(2 * k - 1 == n ) {
			return;
		}

		Node x = head;
		Node x_prev = null;

		for(int i = 1; i < k; ++i) {
			x_prev = x;
			x = x.next;
		}

		Node y = head;
		Node y_prev = null;
		for(int i = 1; i < n - k + 1; ++i) {
			y_prev = y;
			y = y.next;
		}

		if(x_prev != null) {
			x_prev.next = y;
		}

		if(y_prev != null) {
			y_prev.next = x;
		}

		Node temp = x.next;
		x.next = y.next;
		y.next = temp;

		if(k == 0) {
			head = y;
		}

		if(k == n) {
			head = x;
		}
	}

	public void push(int i) {
		Node n = new Node(i);

		n.next = head;
		head = n;
	}

	public void moveToFront() {
		if(head == null || head.next == null) {
			return;
		}

		Node prevLast = null;
		Node last  = head;

		while(last.next !=null) {
			prevLast = last;
			last = last.next;
		}

		prevLast.next = null;

		last.next = head;
		head = last;

	}

	public void swapNodes(Node n1, Node n2) {
		if(n1 == n2) return;

		Node p1 = null;
		Node curr = head;
		while(curr !=null  && curr!= n1) {
			p1 = curr;
			curr = curr.next;
		}

		curr = head;
		Node p2 = null;

		while(curr != null && curr != n2) {
			p2 = curr;
			curr =curr.next;
		}

		if(p1 == null) {
			head = n2;
		} else {
			p1.next = n2;
		}

		if(p2 == null) {
			head = n1;
		} else {
			p2.next = n1;
		}

		Node temp = n1.next;
		n1.next = n2.next;
		n2.next = temp;
	}

	public void deleteNode(Node node) {
		Node temp = node.next;
		node.data = temp.data;
		node.next = temp.next;
		temp = null;
	}

	void removeDuplicates() {
		/*Another reference to head*/
		Node curr = head;

		/* Traverse list till the last node */
		while (curr != null) {
			Node temp = curr;
			/*Compare current node with the next node and
            keep on deleting them until it matches the
            current node data */
			while (temp != null && temp.data == curr.data) {
				temp = temp.next;
			}
			/*Set current node next to the next different
            element denoted by temp*/
			curr.next = temp;
			curr = curr.next;
		}
	}

	public void detectLoop() {
		Node slow =head;
		Node fast = head;
		boolean flag = false;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) {
				flag = true;
				break;
			}
		}

		if(flag) {
			System.out.println("Loop");
			removeLoop(slow);
		} else {
			System.out.println("No Loop");
		}

	}

	private void removeLoop(Node slow) {
		Node ptr1 = slow;
		Node ptr2 = slow;
		Node prevNode = null;
		while(ptr1.next != ptr2) {
			prevNode = ptr1;
			ptr1 = ptr1.next;
		}
		prevNode.next = null;
	}

	public void reverse() {
		Node prev = null;
		Node curr = head;
		Node next= null;

		while(curr != null) {
			next =  curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head = prev;
	}

	public int getCount() {
		int count = 0;
		Node temp = head;
		while(temp != null) {
			count++;
			temp =temp.next;
		}
		return count;
	}

	public boolean search(Node head1, int x) {	

		Node s  = head1;
		while(s != null) {
			if(s.data == x) return true;
			s = s.next;
		}

		return false;
	}

	public void printList() {
		Node h = head;
		while( h != null) {
			System.out.println(h.data);
			h = h.next;
		}
	}

	public void append(int i) {
		Node n =  new Node(i);
		if(head == null) {
			head = n;
			return;
		}

		Node l= this.head;
		while(l.next != null) {
			l = l.next;
		}

		l.next = n;
	}

	public void insertAfter(Node next, int i) {
		if( next == null) {
			System.out.println("Is Empty");
			return;
		}

		Node n = new Node(i);

		n.next = next.next;
		next.next = n;	
	}

	public void deleteFirst() {
		if(head == null) {
			System.out.println("Empty ");
			return;
		}

		head = head.next;
	}

	public void deleteLast() {
		if(head == null) {
			System.out.println("Empty ");
			return;
		}
		Node l = head;

		while(l.next.next != null) {
			l = l.next;
		}

		l.next = null;
	}

	public void deletePosition(int p) {
		if(head == null) {
			System.out.println("Empty ");
			return;
		}

		if(p == 0) {
			head = head.next;
			return;
		}

		Node temp = head;

		for(int i = 0; temp.next.next !=null &&   i < p - 1; i++) {
			temp = temp.next;
		}

		if(temp == null || temp.next == null) return;


		temp.next = temp.next.next;
	}
}
