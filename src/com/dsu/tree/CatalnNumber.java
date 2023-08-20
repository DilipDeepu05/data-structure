package com.dsu.tree;

public class CatalnNumber {

	 public static void main(String[] args)
	    {
	        CatalnNumber cn = new CatalnNumber();
	        for (int i = 0; i < 10; i++) {
	            System.out.println(cn.catalan(i) + " ");
	        }
	    }

	private int catalan(int i) {
		int res = 0 ;
		if(i <= 1) {
			return 1;
		}
		
		for(int j = 0; j < i ; ++j) {
			res += catalan(j) * catalan( i - j  - 1);
		}
		return res;
	}
}
