package com.dsu.greedy;

public class MinimumSwapForBracketBalance {

	public static void main(String args[])
	{
		String s = "[]][][";
		System.out.println(swapCount(s) );

		s = "[[][]]";
		System.out.println(swapCount(s) );

	}

	private static int swapCount(String s) {
		int cl, cr, sw, im;
		cl = cr = sw = im =0;

		for(char c: s.toCharArray()) {
			if(c == '[') {
				cl++;

				if(im > 0) {
					sw += im;
				}
			} else if(c == ']') {
				cr++;

				im = cr - cl;
			}
		}
		return sw;
	}
}
