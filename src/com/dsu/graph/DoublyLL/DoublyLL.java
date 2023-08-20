package com.dsu.DoublyLL;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

class Node {
	Node next;
	int data;
	Node prev;

	Node(int data) {
		this.data = data;
		next = prev = null;
	}
}

public class DoublyLL{

	static Node head;

	public static void main(String[] args) {
		DoublyLL dll = new DoublyLL();
		dll.append(6);
		dll.push(7);
		dll.push(1);
		dll.append(4);
		dll.insertAfter(head.next, 8);
		System.out.println("Created DLL is: ");
		dll.printlist();
		dll.insertBefore(head.next, 10);
		dll.printlist();
		System.out.println();
		System.out.println("Reverse DLL is: ");
		dll.reverse();
		dll.printlist();
		System.out.println();
		System.out.println("Reverse DLL is (stack) : ");
		dll.stackReverse();
		dll.printlist();

		System.out.println("Sort DLL: ");
		dll.sort();
		dll.printlist();
		int d = 2;
		System.out.println("rotate DLL: "+ d);
		dll.rotateByN(d);
		dll.printlist();
		System.out.println("Delete DLL node: ");
		dll.deleteNode(head.next.next);
		dll.printlist();
		System.out.println("Insert sorted ");
		dll.insertSorted(10);
		dll.insertSorted(1);
		dll.insertSorted(9);
		dll.insertSorted(5);
		dll.printlist();
	}

	private void insertSorted(int i) {
		Node n = new Node(i);
		if(head == null) {
			head = n;
		} else {
			if(head.data >= n.data) {
				n.next = head;
				n.next.prev = n;
				head = n;
			} else {
				Node curr = head;

				while(curr.next != null && curr.next.data < n.data) {
					curr = curr.next;
				}

				n.next = curr.next;

				if (curr.next != null) 
					n.next.prev = n;

				curr.next = n;
				n.prev = curr;
			}
		}

	}


	private void deleteNode(Node del) {
		if(head == null || del == null) {
			return;
		}

		if(head == del) {
			head = del.next;
		}

		if(del.next != null) {
			del.next.prev = del.prev;
		}

		if(del.prev !=null) {
			del.prev.next = del.next;
		}

	}


	public void rotateByN(int pos) {
		if (pos == 0) {
			return;
		}
		Node curr = head;
		while (pos != 0) {
			curr = curr.next;
			pos--;
		}

		curr.prev.next = null;
		curr.prev = null;
		Node newHead = curr;

		while(curr.next != null) {
			curr = curr.next;
		}

		curr.next = head;
		head.prev = curr;
		head = newHead;
	}

	private void sort() {
		if(head == null) {
			return;
		}

		Queue<Node> q = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.data - o2.data;
			}

		});

		Node newHead = null, last =null;
		Node curr = head;

		while(curr != null) {
			q.add(curr);
			curr =curr.next;
		}

		while(!q.isEmpty()) {
			if(newHead == null) {
				newHead = q.poll();
				newHead.prev = null;
				last = newHead;
			} else {
				last.next = q.peek();
				q.peek().prev = last;
				last = q.poll();
			}

			if(curr != null) {
				q.add(head);

				curr = curr.next;
			}
		}

		last.next = null;
		head = newHead;
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

	private void stackReverse() {
		Node curr = head;
		Stack<Integer> s = new Stack<>();

		while(curr != null) {
			s.push(curr.data);
			curr= curr.next;
		}

		curr = head;

		while(curr != null ) {
			curr.data = s.pop();
			curr = curr.next;
		}

	}

	private void reverse() {
		Node curr = head;
		Node temp = null;

		while(curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			curr = curr.prev;
		}

		if(temp != null) {
			head = temp.prev;
		}
	}

	private void insertBefore(Node n1, int i) {
		if(n1 == null) {
			System.out.println("Not Exist");
		} else {
			Node n = new Node(i);
			n.prev = n1.prev;
			n.prev.next = n;
			n.next = n1;
			n1.prev = n;
		}

	}

	private void printlist() {
		System.out.println("Traverse forward direction ");
		Node curr = head;
		Node last = head;

		while(curr != null) {
			last = curr;
			System.out.print(curr.data +" -> ");
			curr = curr.next;
		}
		System.out.println();
		System.out.println("Traverse reverse direction ");

		while(last != null) {
			System.out.print(last.data +" -> ");
			last = last.prev;
		}
		System.out.println();
	}

	private void insertAfter(Node n1, int i) {
		if(n1 == null) {
			System.out.println("Not found");
		} else {
			Node n = new Node(i);
			Node curr = head;

			while(curr != n1 && curr != null) {
				curr =curr.next;
			}

			if(curr != null) {
				n.next = curr.next;
				curr.next = n;
				n.prev = curr;
				n.next.prev = n;
			}
		}

	}

	private void append(int i) {
		Node n = new Node(i);
		if(head == null) {
			head = n;
		} else {
			Node last = head;

			while(last.next != null) {
				last = last.next;
			}

			last.next = n;
			n.prev = last;
		}
	}

	private void push(int i) {
		Node n = new Node(i);
		if(head == null) {
			head = n;
		} else {

			n.next = head;
			head.prev = n;
			head = n;

		}
	}
}