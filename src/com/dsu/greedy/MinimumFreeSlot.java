package com.dsu.greedy;

public class MinimumFreeSlot {

	public static void main(String args[])
	{
		int n = 3, m = 7;
		String slots[] = { "0101011",
				"0011001",
		"0110111" };
		System.out.println( findMinRooms(slots, n, m));
	}

	private static int findMinRooms(String[] slots, int n, int m) {
		int count[] =new int[m];
		
		for(int i =0; i < n; i++) {
			for(int j =0; j < m; j++) {
				if(slots[i].charAt(j) == '1') {
					count[j]++;
				}
			}
		}
		
		int max = 0;
		for(int i: count) {
			if(max < i) {
				max = i;
			}
		}
		return max;
	}
}
