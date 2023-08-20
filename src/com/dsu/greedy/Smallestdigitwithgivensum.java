package com.dsu.greedy;

public class Smallestdigitwithgivensum {

	public static void main (String[] args)
	{
		int s = 9, m = 2;
		findSmallest(m, s);
	}

	private static void findSmallest(int m, int s) {
		if(s == 0) {
			System.out.println( m == 1 ? "not possible" : " nope");
			return;
		}
		
		if(s > m*9) {
			System.out.println("not possible");
			return;
		}
		
		int a[] = new int[m];
		s -= 1;
		
		for(int i = m -1; i > 0 ; i--) {
			if(s > 9) {
				a[i] = s;
				s -= 9;
			} else {
				a[i] = s;
				s =0;
			}
		}
		a[0] = s+1;
		
		 System.out.print("Smallest number is ");
	        for (int i=0; i<m; i++)
	            System.out.print(a[i]);
	}
}
