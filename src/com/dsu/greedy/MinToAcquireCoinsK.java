package com.dsu.greedy;

import java.util.Arrays;

public class MinToAcquireCoinsK {

	public static void main(String arg[])
	{
		int coin[] = { 8, 5, 3, 10,
				2, 1, 15, 25 };
		int n = coin.length;
		int k = 3;

		System.out.print(minCost(coin, n, k));
	}

	private static int minCost(int[] coin, int n, int k) {
		Arrays.sort(coin);

		int c = (int) Math.ceil(1.0 * (n/(k+1)));
		int res =0;
		
		for(int i =0 ; i < c; i++) {
			res+= coin[i];
		}
		
		return res;
	}
}
