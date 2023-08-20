package com.dsu.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuyIStockOnIDay {

	static class Pair {
		int first;
		int second;
		Pair(int f, int s) {
			this.first = f;
			this.second = s;
		}
	}
	
	public static void main(String[] args)
    {
        int[] price = { 10, 7, 19 };
        int K = 45;

        System.out.println(buyMaximumProducts(price, K, price.length));
    }
	
	private static int buyMaximumProducts(int[] price, int k, int length) {
		List<Pair> ls = new ArrayList<>();
		for(int i = 0;i < price.length; i++) {
			ls.add(new Pair(price[i], i+1));
		}
		
		Collections.sort(ls, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.first - o2.first;
			}
		});
		
		int ans =0;
		for(Pair p: ls) {
			ans += Math.min(p.second, k/p.first);
			k -= p.first * Math.min(p.second, k/p.first);
		}
		
		return ans;
	}
}
