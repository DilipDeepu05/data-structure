package com.dsu.queue;

public class LinkedQueue {

	public static void main(String[] args)
    {
        Queue1 q = new Queue1();
        q.enqueue(10);
        q.enqueue(20);
        q.dequeue();
        q.dequeue();
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
        System.out.println("Queue Front : " + ((q.front != null) ? (q.front).key : -1));
        System.out.println("Queue Rear : " + ((q.rear != null) ? (q.rear).key : -1));
    }
}

class Qnode {
	int key;
	Qnode next;
	
	Qnode(int key) {
		this.key = key;
		this.next = null;
	}
}

class Queue1 {
	Qnode front, rear;
	
	Queue1() {
		this.front = this.rear = null;
	}

	public void dequeue() {
		// TODO Auto-generated method stub
		if(front == null) {
			System.out.println("Empty");
		} 
		
		Qnode temp = this.front;
		
		this.front = this.front.next;
		
		if(front == null) {
			rear = null;
		}
	}

	public void enqueue(int i) {
		// TODO Auto-generated method stub
		Qnode newNode = new Qnode(i);
		
		if(this.rear == null) {
			this.front = this.rear = newNode;
		}
		
		this.rear.next = newNode;
		this.rear = newNode;
	}
}