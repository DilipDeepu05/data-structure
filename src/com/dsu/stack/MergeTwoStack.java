package com.dsu.stack;

public class MergeTwoStack {

	public static void main (String[] args)
	{
	    Stack1 ms1 = new Stack1();
	    Stack1 ms2 = new Stack1();
	     
	    ms1.push(6);
	    ms1.push(5);
	    ms1.push(4);
	    ms2.push(9);
	    ms2.push(8);
	    ms2.push(7);
	     
	    ms1.merge(ms2);
	    ms1.display();
	}
}

class Node {
	Node prev;
	Node next;
	int data;
	
	Node(int data) {
		this.data= data;
		prev = null;
		next = null;
	}
}
class Stack1 {
	Node head;
	Node tail;
	
	Stack1() {
		head = null;
		tail = null;
	}
	
	public void display() {
		if(tail != null ) {
			Node n = tail;
			while(n !=null) {
				System.out.println(n.data);
				n = n.prev;
			}
		}
	}
	
	void push(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			
			head = newNode;
			tail = newNode;
		} else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
	}
	
	void pop() {
		if(head == tail) {
			head = null;
			tail = null;
		} else {
			Node temp = tail;
			tail = tail.prev;
			temp.prev = null;
		}
	}
	
	
	public void merge(Stack1 s) {
		head.prev = s.tail;
		s.tail.next = head;
		head = s.head;
		s.head = null;
		s.tail = null;
	}
}