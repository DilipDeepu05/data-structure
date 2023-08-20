package com.dsu.heap;

public class MaxHeap {

	int arr[];
	int hsize;
	int size;

	MaxHeap(int i) {
		this.size = i;
		arr = new int[i];
		hsize = 0;
	}

	int getMax() {
		return arr[0];
	}

	int parent(int i) {
		return (i -1) / 2;
	}

	int lChild(int i) {
		return 2 * i + 1;
	}

	int rChild(int i) {
		return 2 * i + 2;
	}

	int curSize() {
		return hsize;
	}


	public static void main(String[] args) {
		// Assuming the maximum size of the heap to be 15.
		MaxHeap h = new MaxHeap(15);

		// Asking the user to input the keys:
		int k, i, n = 6;
		System.out.println("Entered 6 keys:- 3, 10, 12, 8, 2, 14 \n");
		h.insertKey(3);
		h.insertKey(10);
		h.insertKey(12);
		h.insertKey(8);
		h.insertKey(2);
		h.insertKey(14);

		// Printing the current size
		// of the heap.
		System.out.println("The current size of the heap is "
				+ h.curSize() + "\n");

		// Printing the root element which is
		// actually the maximum element.
		System.out.println("The current maximum element is " + h.getMax()
		+ "\n");

		// Deleting key at index 2.
		h.deleteKey(2);

		// Printing the size of the heap
		// after deletion.
		System.out.println("The current size of the heap is "
				+ h.curSize() + "\n");

		// Inserting 2 new keys into the heap.
		h.insertKey(15);
		h.insertKey(5);
		System.out.println("The current size of the heap is "
				+ h.curSize() + "\n");
		System.out.println("The current maximum element is " + h.getMax()
		+ "\n");

		int x = 17;
		h.printSmallerThan(x, 0);
	}

	private void printSmallerThan(int k, int i) {
		if(i >= hsize) {
			return;
		}

		if(arr[i] >= k) {
			return;
		}

		System.out.print(arr[i]+ " ");
		printSmallerThan(k, lChild(i));
		printSmallerThan(k, rChild(i));	
	}

	private void deleteKey(int i) {
		if(hsize == 0) {
			System.out.println("NO value");
			return;
		}

		if(hsize == 1) {
			hsize--;
			return;
		}

		incresingKey(i, Integer.MAX_VALUE);
		removeMax();
	}

	private void removeMax() {
		if(hsize == 0) {
			System.out.println("NO value");
			return ;
		}

		if(hsize == 1) {
			hsize--;
			return;
		}

		int i = arr[0];
		arr[0] = arr[hsize--];
		maxheapify(0);
	}

	private void maxheapify(int i) {
		int l = lChild(i);
		int r = rChild(i);
		int largest = i;
		if(l < hsize && arr[l] > arr[i]) 
			largest = l;
		if(r < hsize && arr[r] > arr[largest])
			largest = r;

		if(largest != i) {
			int t = arr[largest];
			arr[largest] = arr[i];
			arr[i] = t;
			maxheapify(largest);
		}
	}

	private void incresingKey(int i, int maxValue) {
		arr[i] = maxValue;
		while(i!= 0 && arr[parent(i)] < arr[i]) {
			int t = arr[parent(i)];
			arr[parent(i)] = arr[i];
			arr[i] = t;
			i = parent(i);
		}
	}

	private void insertKey(int data) {
		if(hsize == size) {
			System.out.println("No space");
			return;
		}

		int i = hsize;
		arr[hsize++] = data;

		while(i!= 0 && arr[parent(i)] < arr[i]) {
			int t = arr[parent(i)];
			arr[parent(i)] = arr[i];
			arr[i] = t;
			i = parent(i);
		}	
	}
}
