package com.dsu.circularLL;

public class JosephusCirclle {

    static class Node
    {
        public int data ;
        public Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

	public static void main(String args[]) {
		int n = 14, m = 2;
		getJosephusPosition(m, n);
	}

	private static void getJosephusPosition(int m, int n) {
		Node prev = new Node(0);
		Node head = prev;
		for(int i = 1; i < n; i++) {
			prev.next = new Node(i);
			prev = prev.next;
		}
		
		prev.next = head;
		
		Node prev1 = head; 
		Node prev2 = head;
		
		while(prev1.next != prev1) {
			int c = 1;
			while(c != m) {
				prev2 = prev1;
				prev1 = prev1.next;
				c++;
			}
			
			prev2.next = prev1.next;
			prev1 = prev2.next;
		}
		System.out.println(prev1.data);
	}
}
