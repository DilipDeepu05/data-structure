package com.dsu.greedy;

public class MinCircularLock {

	public static void main (String[] args) {
		int input = 28756;
		int unlock_code = 98234;
		System.out.println("Minimum Rotation = "+ minRotation(input, unlock_code));
	}

	private static int minRotation(int input, int unlock_code) {
		int res = 0;
		int i = 0, u =0;
		
		while(input > 0 || unlock_code > 0) {
			i = input % 10;
			u = unlock_code % 10;
			
			res += Math.min(Math.abs(i - u), 10 - Math.abs(i - u));
			
			input /= 10;
			unlock_code /= 10;
		}
		return res;
	}
}
