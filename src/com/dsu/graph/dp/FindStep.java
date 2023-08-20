package com.dsu.dp;

public class FindStep {

	public static void main(String argc[])
	{
		int n = 4;
		System.out.println(findStep(n));
		System.out.println(findStepDp(n));
	}

	private static int findStepDp(int n) {
		int a[] = new int[n+1];
		a[0] = 1; a[1] = 1; a[2] = 2;
		for(int i = 3; i <= n; i++) {
			a[i] = a[i - 1] + a[i - 2] + a[i - 3];
		}
		
		return a[n];
	}

	private static int findStep(int n) {
		if(n == 0) {
			return 1;
		}
		
		if(n < 0) {
			return 0;
		}
		
		return findStep(n - 3)+ findStep(n - 2) + findStep(n - 1);
	}
}
