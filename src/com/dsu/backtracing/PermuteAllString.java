package com.dsu.backtracing;

public class PermuteAllString {

	public static void main(String[] args)
	{
		String str = "ABC";
		int n = str.length();
		
		permute(str, 0, n - 1);
	}

	private static void permute(String str, int l, int r) {
		if(l == r) {
			System.out.println(str);
			return;
		} else {
			for(int i =0; i < str.length(); i++) {
				str = swap(str, l ,i);
				permute(str, l+1, r);
				str = swap(str, l ,i);
			}
		}
	}

	private static String swap(String str, int l, int i) {
		char c[] = str.toCharArray();
		char a = c[l];
		c[l] = c[i];
		c[i] = a;
		return String.valueOf(c);
	}
}
