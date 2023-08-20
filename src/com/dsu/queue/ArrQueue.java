package com.dsu.queue;

public class ArrQueue {

	public static void main(String[] args)  {
		Queue queue = new Queue(1000);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);

		System.out.println(queue.dequeue()
				+ " dequeued from queue");

		System.out.println("Front item is "
				+ queue.front());

		System.out.println("Rear item is " + queue.rear());
	}
}

class Queue {
	int arr[];
	int front;
	int rear;
	int cap;
	int size;

	Queue(int cap) {
		System.out.println("Creating arr of: "+ cap);
		this.arr = new int[cap];
		this.cap = cap;
		this.front = 0;
		this.rear = cap -1;
		this.size = 0;
	}

	public int rear() {
		if(isEmpty()) return -1;
		return this.arr[this.rear];
	}

	public int front() {
		if(isEmpty()) {
			return -1;
		}
		return this.arr[this.front];
	}

	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int item = this.arr[this.front];
		this.front = (this.front + 1) % this.cap;
		this.size--;
		return item;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.cap;
	}

	public void enqueue(int i) {
		if(isFull()) {
			return;
		} else {
			this.rear = (this.rear +1 ) % this.cap;
			this.arr[this.rear] = i;
			System.out.println("inserting value: "+ i + " rear: "+ this.rear);
			this.size++;
		}
	}
}