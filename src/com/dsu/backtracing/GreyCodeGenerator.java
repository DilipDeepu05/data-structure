package com.dsu.backtracing;

import java.util.Vector;

public class GreyCodeGenerator {

	static int num;
	
	static Vector<Integer> grayCodes(int n)
	{
		Vector<Integer> res = new Vector<Integer>();

		// num is passed by reference to keep
		// track of current code.
		num = 0;
		grayCodeUtil(res, n);

		return res;
	}

	private static void grayCodeUtil(Vector<Integer> res, int n) {
		if(n == 0) {
			res.add(num);
			return;
		}
		
		grayCodeUtil(res, n-1);
		
		num = num ^ ( 1 << n-1);
		System.out.println(num);
		grayCodeUtil(res, n - 1);
	}

	// Driver function.
	public static void main(String[] args)
	{
		int n = 3;
		Vector<Integer> code = grayCodes(n);
		for (int i = 0; i < code.size(); i++)
			System.out.print(code.get(i) +"\n");
	}
}
