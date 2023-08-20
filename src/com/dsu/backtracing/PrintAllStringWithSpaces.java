package com.dsu.backtracing;

import java.util.Arrays;

public class PrintAllStringWithSpaces {

	public static void main(String[] args)
	{
		String str = "ABCD";
		printPattern(str);
	}

	private static void printPattern(String str) {
		int n = str.length();
		
		char l[] = new char[n*2];
		l[0] = str.charAt(0);
		printPatternUtil(str,l, 1,1, n);
	}

	private static void printPatternUtil(String str, char[] l, int i, int j, int n) {
		if(i == n) {
			l[j] = '\0';
			System.out.println(l);
			return;
		}
		
		l[j] = str.charAt(i);
		printPatternUtil(str, l, i+1, j+1, n);
		
		l[j] = ' ';
		l[j+1] = str.charAt(i);
		printPatternUtil(str, l, i+1, j+2, n);
	}
}
