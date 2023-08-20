package com.dsu.greedy;

public class DivideCuboidCubesSum {

	public static void main(String[] args)
	{
		int l = 2, b = 4, h = 6;
		maximizecube(l, b, h);
	}

	private static void maximizecube(int l, int b, int h) {
		int side = gcd(l , gcd(b, h));
		
		int num = l / side;
		num = num * b/side;
		num = num * h/side;
		System.out.println(side +" "+ num);
	}

	private static int gcd(int m, int n) {
		if( n == 0) {
			return m; 
		} else if(n > m) {
			return gcd(n , m);
		}
		return gcd(n , m % n);
	}
}
