package com.dsu.greedy;

public class FittingShelves {

	public static void main(String[] args)
	{
		int wall = 24, m = 3, n = 5;
		minSpacePreferLarge(wall, m, n);

		wall = 24;
		m = 4;
		n = 7;
		minSpacePreferLarge(wall, m, n);
	}

	private static void minSpacePreferLarge(int wall, int m, int n) {
		int nm =0,nn=0,min = wall;
		
		int p = wall/m, q =0, rem = wall%m;
		
		nm = p;
		nn = q;
		min = rem;
		q++;
		wall = wall - n;
		
		while(wall >= n) {
			
			p = wall / m;
			rem = wall % m;
			
			if(rem <= min) {
				nm = p;
				nn = q;
				min = rem;		
			}
			
			q++;
			wall = wall -n;
		}
		System.out.println(nm+ " "+ nn+ " "+ min);
	}
}
