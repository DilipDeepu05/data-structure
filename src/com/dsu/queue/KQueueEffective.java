package com.dsu.queue;

public class KQueueEffective {

	public static void main(String[] args) {
		// Let us create 3 queue in an array of size 10
		int k = 3, n = 10;
		KQueues ks=  new KQueues(k, n);


		// Let us put some items in queue number 2
		ks.enqueue(15, 2);
		ks.enqueue(45, 2);

		// Let us put some items in queue number 1
		ks.enqueue(17, 1);
		ks.enqueue(49, 1);
		ks.enqueue(39, 1);

		// Let us put some items in queue number 0
		ks.enqueue(11, 0);
		ks.enqueue(9, 0);
		ks.enqueue(7, 0);

		System.out.println("Dequeued element from queue 2 is " +
				ks.dequeue(2));
		System.out.println("Dequeued element from queue 1 is " +
				ks.dequeue(1));
		System.out.println("Dequeued element from queue 0 is " +
				ks.dequeue(0) );

	}
}

class KQueues {
	int k;
	int n;
	int f[];
	int r[];
	int nx[];
	int arr[];
	int free = 0;

	KQueues(int k, int n) {
		this.k = k;
		this.n =n;
		this.f = new int[this.k];
		this.r = new  int[this.k];
		this.arr = new int[this.n];
		this.nx = new int[this.n];

		for(int i = 0; i < k; i++) {
			this.f[i] = this.r[i] = -1;
		}

		free = 0;

		for(int i = 0; i < n -1; ++i) {
			this.nx[i] = i+1;
		}

		this.nx[n-1] = -1;

	}

	public int dequeue(int i) {
		if(isEmpty(i)) {
			System.out.println("Empty: "+ i);
			return Integer.MIN_VALUE;
		}

		int nexIndex = f[i];
		f[i] = nx[nexIndex];
		nx[i] = nexIndex;

		free = nexIndex;

		return this.arr[nexIndex];
	}

	private boolean isEmpty(int j) {
		return this.f[j] == -1;
	}

	private boolean isFull(int j) {
		return this.free == -1;
	}
	public void enqueue(int i, int j) {
		// TODO Auto-generated method stub
		if(isFull(j)) {
			System.out.println("Empty to push: "+ j);
			return;
		}

		int nextFree = this.nx[free];

		if(isEmpty(j)) {
			f[j]= r[j] = free;
		} else {
			nx[r[j]] = free;
			r[j] = free;
		}

		nx[free] = -1;
		arr[free] = i;
		free = nextFree;
	}
}