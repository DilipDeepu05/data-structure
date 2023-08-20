package com.dsu.dp;

public class Fib {

	public static void main(String[] args) {
		System.out.println(fact(10));
		System.out.println(fib(10));
		System.out.println(fibDp(10));
		System.out.println(fibDpM(10));
	}
	
	static int a[] =new int[11];

	private static int fibDpM(int n) {
		if(a[n] == 0) {
			if(n <=1) {
				a[n] = n;
			} else { 
				a[n] = fibDpM(n - 1) + fibDpM(n - 2);
			}
		}
		return a[n];
	}

	private static int fibDp(int n) {
		int fb[] = new int[n+1];
		fb[0] = 0;
		fb[1] = 1;
		for(int i = 2; i <=n ;i++) {
			fb[i] = fb[i-1]+fb[i-2];
		}
		return fb[n];
	}

	private static int fib(int n) {
		if(n <= 1) return n;
		
		return fib(n-1) + fib(n-2);
	}

	private static int fact(int n) {
		if(n <= 1) return n;
		
		return n * fact(n -1);
	}
}