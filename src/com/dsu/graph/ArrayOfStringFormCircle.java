package com.dsu.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfStringFormCircle {
	
	int v;
	List<Integer> ls[];
	int[] in;
	
	ArrayOfStringFormCircle(int v) {
		this.v = v;
		in = new int[v];
		ls = new ArrayList[v];
		Arrays.fill(ls, new ArrayList<>());
	}
	
	public static void main(String[] args) throws Exception
	{
	    String[] arr1 = { "for", "geek",
	                      "rig", "kaf" };
	    int n1 = arr1.length;
	     
	    System.out.println((canBeChained(arr1, n1) ?
	                       "Can be chained " :
	                       "Can't be chained "));
	 
	    String[] arr2 = { "aab", "abb" };
	    int n2 = arr2.length;
	     
	    System.out.println((canBeChained(arr2, n2) ?
	                       "Can be chained " :
	                       "Can't be chained "));
	}

	private static boolean canBeChained(String[] arr, int n1) {
		ArrayOfStringFormCircle g = new ArrayOfStringFormCircle(26);
		
		for(int i=0; i < n1; i++) {
			String s = arr[i];
			g.addEdge(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
			
		}
		
		return g.isEuclerCircle();
	}

	private boolean isEuclerCircle() {
		if(!sc()) {
			return false;
		}

		for(int i =0; i < v; i++) {
			if(ls[i].size() != in[i]) {
				return false;
			}
		}
		return true;
	}

	private  boolean sc() {
		boolean visited[] = new boolean[v];
		int i =0;
		for(i = 0; i < v; i++) {
			if(ls[i].size() > 0) {
				break;
			}
		}
		
		dfsUtil(visited, i);

		for(int j = 0; j < v; j++) {
			if(ls[j].size() > 0 && !visited[j]) return false;
		}
		System.out.println("aa");
		ArrayOfStringFormCircle a = getTranspose();
		
		Arrays.fill(visited, false);
		
		dfsUtil(visited, i);
		
		for(int j = 0; j < visited.length; j++) {
			if(!ls[j].isEmpty() && !visited[j]) return false;
		}
		
		return true;
	}

	private  ArrayOfStringFormCircle getTranspose() {
		ArrayOfStringFormCircle a = new ArrayOfStringFormCircle(v);
		for(int i =0; i < v; i++) {
			for(int j: ls[i]) {
				a.ls[j].add(i);
				a.in[i]++;
			}
		}
		return a;
	}

	private  void dfsUtil(boolean[] visited, int i) {
		visited[i] = true;
		for(int d: ls[i]) {
			if(!visited[d]) {
				dfsUtil(visited, d);
			}
		}
	}

	private void addEdge(int i, int j) {
		ls[i].add(j);
		in[j]++;
	}
}
