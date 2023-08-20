package com.dsu.queue;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LruCache {

	public static void main(String[] args) {
		LRUCache1 cache = new LRUCache1(4);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(1);
		cache.refer(4);
		cache.refer(5);
		cache.display();
	}
}

class LRUCache1 {
	Deque<Integer> d;
	Set<Integer> s;
	int cap;

	LRUCache1(int cap) {
		this.cap = cap;
		d = new LinkedList<>();
		s = new HashSet<>();
	}

	public void display() {

		for(int i: d) {
			System.out.println(i);
		}
	}

	public void refer(int i) {
		if(!s.contains(i)) {
			if(d.size() == cap) {
				int last = d.removeLast();
				s.remove(last);
			}
		} else {
			d.remove(i);
		}
		d.push(i);
		s.add(i);
	}
}