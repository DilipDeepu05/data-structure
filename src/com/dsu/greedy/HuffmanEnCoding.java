package com.dsu.greedy;

import java.util.PriorityQueue;

public class HuffmanEnCoding {

	static class Huffman {
		char c;
		int d;
		Huffman l; 
		Huffman r;
	}

	public static void main(String[] args)
	{
		// number of characters.
		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		PriorityQueue<Huffman> q = new PriorityQueue<>(n, (o1, o2) -> (o1.d - o2.d));

		for(int  i =0; i < n; i++) {
			Huffman h = new Huffman();
			h.d = charfreq[i];
			h.c = charArray[i];

			h.l = h.r = null;

			q.add(h);
		}
		encode(q);
	}

	private static void encode(PriorityQueue<Huffman> q) {
		Huffman h = null;
		while(q.size() > 1) {
			Huffman f = q.remove();
			Huffman s = q.remove();

			Huffman d = new Huffman();
			d.d = f.d + s.d;
			d.c = '-';
			d.l = f;
			d.r = s;
			h = d;
			q.add(d);
		}

		print(h, "");
	}

	private static void print(Huffman h, String s) {
		if(h.l == null && h.r == null && Character.isLetter(h.c)) {
			System.out.println(h.c+": "+s);
			return;
		}

		print(h.l, s+"0");
		print(h.r, s+"1");

	}
}
