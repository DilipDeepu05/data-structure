package com.dsu.greedy;

public class PaperCutMinSquareNumber {

	public static void main(String[] args) {
		int n = 13, m = 29;
		System.out.println(minimumSquare(n, m));
	}

	private static int minimumSquare(int n, int m) {
		int res =0;
		int rem = 0;
		if(n < m) {
			int t = n;
			n = m;
			m = t;
		}
		
		while(m > 0) {
			res += n /  m;
			rem = n % m;
			n = m;
			m = rem;
		}
		return res;
	}
}
