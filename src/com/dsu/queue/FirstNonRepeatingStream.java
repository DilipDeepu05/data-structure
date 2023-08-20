package com.dsu.queue;

import java.util.ArrayList;
import java.util.List;

public class FirstNonRepeatingStream {

	public static void main(String[] args) {
		findFirstNonRepeating();
	}

	private static void findFirstNonRepeating() {
		boolean b[] = new boolean[256];
		String stream = "geeksforgeeksandgeeksquizfor";
		String res  = "";
		List<Character> ls = new ArrayList<>();
		for(char i: stream.toCharArray()) {
			if(!b[i]) {

				if(!ls.contains(i)) {
					ls.add(i);
				} else {
					ls.remove(i);
					b[i] = true;
				}
			}

			if(!ls.isEmpty()) {
				res+=ls.get(0);
			}
		}

		System.out.println(res);
	}
}
