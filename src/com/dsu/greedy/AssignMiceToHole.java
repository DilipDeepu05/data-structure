package com.dsu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignMiceToHole {

	public static void main(String[] args)
	{
		AssignMiceToHole gfg = new AssignMiceToHole();
		List<Integer> mice = new ArrayList<Integer>();
		mice.add(4);
		mice.add(-4);
		mice.add(2);
		List<Integer> holes= new ArrayList<Integer>();
		holes.add(4);
		holes.add(0);
		holes.add(5);
		System.out.println("The last mouse gets into "+
				"the hole in time: "+gfg.assignHole(mice, holes));
	}

	private int assignHole(List<Integer> mice, List<Integer> holes) {
		Collections.sort(mice);
		Collections.sort(holes);
		
		int max = 0;
		for(int i =0; i < mice.size(); i++) {
			if(max < Math.abs(mice.get(i) - holes.get(i))) {
				max = Math.abs(mice.get(i) - holes.get(i));
			}
		}
		return Math.abs(max);
	}
}
