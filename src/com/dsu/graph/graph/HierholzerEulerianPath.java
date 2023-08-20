package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class HierholzerEulerianPath {

	public static void main(String[] args)
	{
		List<List<Integer> > adj1
		= new ArrayList<List<Integer> >();

		// Input Graph 1
		adj1.add(new ArrayList<Integer>());
		adj1.add(new ArrayList<Integer>());
		adj1.add(new ArrayList<Integer>());

		// Build the edges
		adj1.get(0).add(1);
		adj1.get(1).add(2);
		adj1.get(2).add(0);
		PrintCircuit(adj1);
		System.out.println();
	}

	private static void PrintCircuit(List<List<Integer>> adj1) {
		Map<Integer, Integer> m = new HashMap<>();
		
		for(int i =0; i < adj1.size(); i++) {
			m.put(i, adj1.get(i).size());
		}
		
		if(adj1.size() == 0) {
			return;
		}
		
		List<Integer> ls = new ArrayList<>();
		Stack<Integer> s = new Stack<>();
		
		s.push(0);
		int curr = 0;
		while(!s.isEmpty()) {
			if(m.get(curr) != 0) {
				s.add(curr);
				int next = adj1.get(curr).get(adj1.get(curr).size() - 1);
				m.put(curr, m.get(curr) - 1);
				adj1.get(curr).remove(adj1.get(curr).size() - 1);
				curr = next;
			} else {
				ls.add(curr);
				curr = s.pop();
			}
		}
		
		System.out.println(Arrays.asList(ls, Collections.reverseOrder()));
	}
}
