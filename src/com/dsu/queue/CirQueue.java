package com.dsu.queue;

import java.util.ArrayList;
import java.util.List;

public class CirQueue {

	public static void main(String[] args) {
	      
	    // Initialising new object of
	    // CircularQueue class.
	    CircularQueue q = new CircularQueue(5);
	      
	    q.enQueue(14);
	    q.enQueue(22);
	    q.enQueue(13);
	    q.enQueue(-6);
	      
	    q.displayQueue();
	    System.out.println();
	    int x = q.deQueue();
	  
	    // Checking for empty queue.
	    if(x != -1) {
	        System.out.print("Deleted value = ");
	        System.out.println(x);
	    }
	  
	    x = q.deQueue();
	    System.out.println();
	    // Checking for empty queue.
	    if(x != -1) {
	        System.out.print("Deleted value = ");
	        System.out.println(x);
	    }
	  
	    q.displayQueue();
	      
	    q.enQueue(9);
	    q.enQueue(20);
	    q.enQueue(5);
	      
	    q.displayQueue();
	      
	    q.enQueue(20);
	}
}

class CircularQueue {
	List<Integer> ls = new ArrayList<>();
	
	private int size, front,  rear;
	
	CircularQueue(int cap) {
		size = cap;
		front = -1;
		rear = -1;
	}

	public void displayQueue() {
		// TODO Auto-generated method stub
		if(front == -1) {
			System.out.println("Empty");
			
		}
		System.out.println("Elements in Circular Queue are: ");
		if(front <= rear) {
			for(int i = front; i <= rear; ++i) {
				System.out.print(ls.get(i)+ " ");
			}
		} else {
			for(int i = front; i < size; ++i) {
				System.out.print(ls.get(i)+ " ");
			}
			
			for(int i = 0; i <= rear; ++i) {
				System.out.print(ls.get(i)+ " ");
			}
		}
	}

	public int deQueue() {
		if(front == -1) {
			System.out.println("empty");
			return -1;
		}
		
		int temp = ls.get(front);
		
		if(front == rear) {
			front = -1;
			rear = -1;
		} else if(front == size -1) {
			front = 0;
		} else {
			front++;
		}
		return temp;
	}

	public void enQueue(int i) {
		if((front == 0 && rear == size -1)  || (rear == (front -1) % (size - 1))) {
			System.out.println("full");
		}
		
		if(front == -1) {
			rear = 0;
			front = 0;
			ls.add(rear, i);
		} else if(rear == size -1 && front != 0) {
			rear = 0;
			ls.set(rear, i);
		} else {
			rear++;
			
			if(front <= rear) {
				ls.add(rear, i);
			} else {
				ls.set(rear, i);
			}
		}
	}
}