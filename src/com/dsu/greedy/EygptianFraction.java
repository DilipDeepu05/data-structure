package com.dsu.greedy;

public class EygptianFraction {

	public static void main(String[] args)
	{
		int nr = 2, dr = 3;

		// Calling the function and printing  the
		// corresponding Egyptian Fraction Representation
		System.out.print(
				"Egyptian Fraction Representation of " + nr
				+ "/" + dr + " is\n ");
		printEgyptian(nr, dr);
	}

	private static void printEgyptian(int nr, int dr) {
		if(nr == 0 || dr == 0) {
			return;
		}
		
		if(nr % dr ==0) {
			System.out.println(nr/dr);
			return;
		}
		
		if(dr% nr == 0) {
			System.out.println("1/ "+ dr/nr);
			return;
		}
		
		if(nr > dr) {
			System.out.println(nr/dr);
			printEgyptian(nr % dr, dr);
		}
		
		int n = dr / nr + 1;
		System.out.println("1/ "+ n);
		printEgyptian( nr * n - dr, n * dr);
	}
}
