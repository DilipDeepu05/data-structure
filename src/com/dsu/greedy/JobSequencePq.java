package com.dsu.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class JobSequencePq {

	static class Job {
		char job;
		int deadline;
		int profit;

		Job(char s, int a, int b){
			job = s;
			deadline = a;
			profit = b;
		}
	}

	public static void main(String[] args)
	{
		ArrayList<Job> arr = new ArrayList<Job>();

		arr.add(new Job('a', 2, 100));
		arr.add(new Job('b', 1, 19));
		arr.add(new Job('c', 2, 27));
		arr.add(new Job('d', 1, 25));
		arr.add(new Job('e', 3, 15));

		System.out.println("Following is maximum "
				+ "profit sequence of jobs");

		printJobScheduling(arr);
	}

	private static void printJobScheduling(ArrayList<Job> arr) {
		Collections.sort(arr, (o1, o2) -> {return o1.deadline - o2.deadline;});

		PriorityQueue<Job> p = new PriorityQueue<>((o1,o2) -> {return o2.profit - o1.profit; });
		List<Job> ls = new ArrayList<>();

		for(int i = arr.size() - 1; i >= 0; i--) {
			int slot;

			if(i ==0) {
				slot = arr.get(i).deadline;
			} else {
				slot = arr.get(i).deadline - arr.get(i - 1).deadline;
			}
			p.add(arr.get(i));
			while(!p.isEmpty() && slot > 0) {
				Job j = p.remove();
				slot--;
				ls.add(j);
			}
		}

		Collections.sort(ls, (o1, o2) -> {return o1.deadline - o2.deadline;});
		for (Job job : ls) {
			System.out.print(job.job + " ");
		}

	}
}
