package com.dsu.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupWordsWithSameCharSet {

	public static void main(String args[]) {
		String words[] = { "may", "student", "students", "dog",
				"studentssess", "god", "cat", "act", "tab",
				"bat", "flow", "wolf", "lambs", "amy", "yam",
				"balms", "looped", "poodle"};
		int n = words.length;
		wordsWithSameCharSet(words, n);
	}

	private static void wordsWithSameCharSet(String[] words, int n) {
		Map<String, List<Integer>> m = new HashMap<>();
		for(int i = 0; i < words.length; i++) {
			String key = getKey(words[i]);
			List<Integer> ls;
			if(m.containsKey(key)) {
				ls = m.get(key);
			} else {
				ls = new ArrayList<>();
			}
			ls.add(i);
			m.put(key, ls);
		}

		for(List<Integer> ls: m.values()) {
			for(int i: ls) {
				System.out.print(words[i]+ " ");
			}
			System.out.println();
		}
	}

	private static String getKey(String string) {
		boolean v[] = new boolean[26];
		Arrays.fill(v, false);

		for(char i: string.toCharArray()) {
			v[i - 'a'] = true;
		}

		String key ="";
		for(int i = 0; i < v.length; ++i) {
			if(v[i]) {
				key += (char)'a' + i;
			}
		}
		return key;
	}
}
