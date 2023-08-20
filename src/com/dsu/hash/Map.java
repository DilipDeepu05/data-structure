package com.dsu.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class HashMap<k, v> {
	k key;
	v value;
	int hash;
	HashMap<k, v> next;

	HashMap(k key, v vvlue, int hash) {
		this.key = key;
		this.value = value;
		this.hash = hash;
	}
}

public class Map<k, v> {

	int bsize;
	int size;
	List<HashMap<k, v>> ls;

	int getHashCode(Object key) {
		return Objects.hashCode(key);
	}

	int getBucketIndex(Object key) {
		int hash = getHashCode(key);
		int index = hash % bsize;
		return index < 0 ? index * -1 : index;
	}

	int size() {
		return size;
	}

	Map() {
		bsize = 10;
		size =0;
		ls = new ArrayList<>();
		for(int i =0 ; i < bsize; i++) {
			ls.add(null);
		}
	}

	public static void main(String[] args)
	{
        Map<String, Integer> map = new Map<>();
        map.add("this", 1);
        map.add("coder", 2);
        map.add("this", 4);
        map.add("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
	}

	private void add(k key, v value) {
		int index = getBucketIndex(key);
		int hashCode = getHashCode(key);

		HashMap<k, v> head = ls.get(index);
		while(head != null) {
			if(head.key.equals(key) && head.hash == hashCode) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		size++;
		head = ls.get(index);
		
		HashMap<k,v> node = new HashMap(key, value, hashCode);
		node.next = head;
		
		ls.add(index, node);
		
		if(size * 1.0 / bsize > 0.75) {
			List<HashMap<k, v>> temp = ls;
			ls = new ArrayList<>();
			bsize *= 2;
			size = 0;
			
			for(int i =0 ;i < bsize; i++) {
				ls.add(null);
			}
			
			for(HashMap<k, v> t: temp) {
				while(t!= null) {
					add(t.key, t.value);
					t = t.next;
				}
			}
		}
	}

	private int remove(k key) {

		int index = getBucketIndex(key);
		int hashCode = getHashCode(key);

		HashMap<k, v> head = ls.get(index);
		HashMap<k, v> prev = null;
		while(head != null) {
			if(head.key.equals(key) && head.hash == hashCode) {
				break;
			}
			prev = head;
			head = head.next;
		}
		
		if(head == null) {
			return -1;
		}
		
		size--;
		
		if(prev != null) {
			prev.next = head.next;
		} else {
			ls.set(index, head.next);
		}

		return (int) head.value;
	}

	private int get(k key) {
		int index = getBucketIndex(key);
		int hashCode = getHashCode(key);

		HashMap<k, v> head = ls.get(index);

		while(head != null) {
			if(head.key.equals(key) && head.hash == hashCode) {
				return (int) head.value;
			}
			head = head.next;
		}

		return -1;
	}

	private boolean isEmpty() {
		return size == 0;
	}
}
