package com.dsu.backtracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BackTrackingFindAllSubSet {

	public static void main(String[] args)
	{

		// Main List for storing all subsets
		List<List<Integer> > subset = new ArrayList<>();

		// Input ArrayList
		ArrayList<Integer> input = new ArrayList<>();
		input.add(1);
		input.add(2);
		input.add(3);

		findSubsets(subset, input, new ArrayList<>(), 0);

		// Comparator is used so that all subset get
		// sorted in ascending order of values
		Collections.sort(subset, (o1, o2) -> {
			int n = Math.min(o1.size(), o2.size());
			for (int i = 0; i < n; i++) {
				if (o1.get(i) == o2.get(i)) {
					continue;
				}
				else {
					// sort based on the unequal elements value
					return o1.get(i) - o2.get(i);
				}
			}
			// sort based on size
			return o1.size() - o2.size();
		});

		// Printing Subset
		for (int i = 0; i < subset.size(); i++) {
			for (int j = 0; j < subset.get(i).size(); j++) {
				System.out.print(subset.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	private static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> input, ArrayList arrayList, int i) {
		if(i == input.size()) {
			subset.add(arrayList);
			return;
		}
		
		findSubsets(subset, input, new ArrayList<>(arrayList), i+1);
		arrayList.add(input.get(i));
		findSubsets(subset, input, new ArrayList<>(arrayList), i+1);
	}

}
