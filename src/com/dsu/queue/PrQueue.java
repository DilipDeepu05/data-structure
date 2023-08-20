package com.dsu.queue;

class Pair {
	int value;
	int pr;
}

public class PrQueue {

	static Pair[] d = new Pair[5];
	static int size = -1;

	public static void main(String[] args) {
		// Function Call to insert elements
		// as per the priority
		enqueue(10, 2);
		enqueue(14, 4);
		enqueue(16, 4);
		enqueue(12, 3);

		// Stores the top element
		// at the moment
		int ind = peek();

		System.out.println(d[ind].value);

		// Dequeue the top element
		dequeue();

		// Check the top element
		ind = peek();
		System.out.println(d[ind].value);

		// Dequeue the top element
		dequeue();

		// Check the top element
		ind = peek();
		System.out.println(d[ind].value);
	}

	private static void dequeue() {
		// TODO Auto-generated method stub
		int id = peek();

		for(int i = id; i< size;++i) {
			d[i] = d[i+1];
		}

		size--;
	}

	private static int peek() {
		int id = -1;
		int hp = Integer.MIN_VALUE;

		for(int i = 0; i <=size; i++) {
			if(hp == d[i].pr && id > -1 && d[id].value < d[i].value) {
				hp = d[i].pr;
				id = i;
			} else if(hp < d[i].pr) {
				hp = d[i].pr;
				id = i;
			}
		}

		return id;
	}

	private static void enqueue(int i, int j) {
		// TODO Auto-generated method stub
		d[++size] = new Pair();
		d[size].value = i;
		d[size].pr = j;
	}
}
