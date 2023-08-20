package com.dsu.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderlength {

	public static void main(String[] args)
	{
		// make dictionary
		Set<String> D = new HashSet<String>();
		D.add("poon");
		D.add("plee");
		D.add("same");
		D.add("poie");
		D.add("plie");
		D.add("poin");
		D.add("plea");
		String start = "toon";
		String target = "plea";
		System.out.print("Length of shortest chain is: "
				+ shortestChainLen(start, target, D));
	}

	private static int shortestChainLen(String start, String target, Set<String> d) {
		if(!d.contains(target)) {
			return -1;
		}

		if(start.equals(target)) return 0;

		int wordLength = start.length(), level = 0;
		Queue<String> q =new LinkedList<>();
		q.add(start);

		while(!q.isEmpty()) {
			level++;
			int size = q.size();

			for(int i =0; i < size; i++) {
				char[] c = q.remove().toCharArray();

				for(int j =0; j < c.length; j++) {

					char org = c[j];

					for(char k = 'a'; k <= 'z'; k++) {
						c[j] = k;

						if(String.valueOf(c).equals(target)) return ++level;

						if(!d.contains(String.valueOf(c))) {
							continue;
						}

						d.remove(String.valueOf(c));
						q.add(String.valueOf(c));
					}

					c[j] = org;
				}
			}
		}
		return -1;
	}
}
