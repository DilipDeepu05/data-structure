package com.dsu.recurrsion;

public class TowerOfHanoi {

	public static void main(String args[])
	{
		int N = 3;

		towerOfHanoi(N, 'A', 'C', 'B');
	}

	private static void towerOfHanoi(int n, char src, char dest, char aux) {
		if(n <= 0) {
			return;
		}
		
		towerOfHanoi(n-1, src, aux, dest);
		System.out.println(n+" from" + src +" to"+ dest);
		towerOfHanoi(n-1, aux, dest, src);
	}
}
