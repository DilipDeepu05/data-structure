package com.dsu.backtracing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParthentsis {

	public static void main(String[] args)
	{
		String expression = "()())()";
		removeInvalidParenthesis(expression);

		expression = "()v)";
		removeInvalidParenthesis(expression);
	}

	private static void removeInvalidParenthesis(String str) {
		Set<String> s = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		
		s.add(str);
		q.add(str);
		boolean level = false;
		String d  = "";
		while(!q.isEmpty()) {
			d = q.remove();
			if(isValidString(d)) {
				System.out.println(d);
				level = true;
			}
			if(level) {
				continue;
			}
			
			for(int i = 0; i < d.length(); i++) {
				if(!parthensis(d.charAt(i))) {
					continue;
				}

				String temp = d.substring(0, i) + d.substring(i+1);
				if(!s.contains(temp)) {
					s.add(temp);
					q.add(temp);
				}
			}
		}
	}

	private static boolean parthensis(char c) {
		return c == '(' || c == ')';
	}

	private static boolean isValidString(String d) {
		int c = 0;
		for(char i : d.toCharArray()) {
			if(i == '(') c++;
			else if(i == ')') c--;
			
			if(c < 0) return false;
		}
		return c ==0;
	}
}
