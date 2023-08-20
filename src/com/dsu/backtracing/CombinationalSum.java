package com.dsu.backtracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationalSum {
	
	public static void main(String[] args)
	{
		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(2);
		arr.add(4);
		arr.add(6);
		arr.add(8);

		int sum = 8;

		ArrayList<ArrayList<Integer> > ans = combinationSum(arr, sum);

		// If result is empty, then
		if (ans.size() == 0) {
			System.out.println("Empty");
			return;
		}

		// print all combinations stored in ans

		for (int i = 0; i < ans.size(); i++) {

			System.out.print("(");
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.print(") ");
		}
	}

	private static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int sum) {
		ArrayList<ArrayList<Integer>> ls = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		
		Set<Integer> s = new HashSet<>(arr);
		arr.clear();
		arr.addAll(s);
		Collections.sort(l);
		combineSumUtil(ls, arr, l, sum, 0);
		return ls;
	}

	private static void combineSumUtil(ArrayList<ArrayList<Integer>> ls, ArrayList<Integer> arr, List<Integer> l,
			int sum, int i) {
		if(sum == 0) {
			ls.add(new ArrayList<>(l));
			return;
		}
		
		for(int j = i; j < arr.size(); j++) {
			if(sum - arr.get(j) >= 0) {
				l.add(arr.get(j));
				combineSumUtil(ls, arr, l, sum - arr.get(j), j);
				l.remove(arr.get(j));
			}
		}
	}

}
