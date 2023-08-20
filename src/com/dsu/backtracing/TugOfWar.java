package com.dsu.backtracing;

public class TugOfWar {

	static int min;

	public static void main (String[] args)
	{
		int arr[] = {23, 45, -34, 12, 0, 98,
				-99, 4, 189, -1, 4};
		TugOfWar a = new TugOfWar();
		a.tugOfWar(arr);
	}

	private void tugOfWar(int[] arr) {
		boolean curr_ele[] = new boolean[arr.length];
		boolean sol[] = new boolean[arr.length];

		min = Integer.MAX_VALUE;
		int sum =0 ;
		for(int i: arr) {
			sum += i;
		}

		tugOfWarUtil(arr, curr_ele, sol, sum, 0, 0, 0, arr.length);
		System.out.print("The first subset is: ");
		for (int i = 0; i < arr.length; i++)
		{
			if (sol[i] == true)
				System.out.print(arr[i] + " ");
		}
		System.out.print("\nThe second subset is: ");
		for (int i = 0; i < arr.length; i++)
		{
			if (sol[i] == false)
				System.out.print(arr[i] + " ");
		}
	}

	private void tugOfWarUtil(int[] arr, boolean[] curr_ele, boolean[] sol, int sum, int csum, int noEle, int pos, int n) {
		if(pos == n) {
			return;
		}

		if(n/2 - noEle > n -pos) {
			return;
		}

		tugOfWarUtil(arr, curr_ele, sol, sum, csum, noEle, pos+1, n);

		noEle++;
		csum = csum + arr[pos];
		curr_ele[pos] = true;

		if(noEle == n/2) {
			if(Math.abs(sum/2 - csum) < min) {
				min = Math.abs(sum/2 - csum);

				for(int i =0; i < n; i++) {
					sol[i] = curr_ele[i];
				}
			}
		} else {
			tugOfWarUtil(arr, curr_ele, sol, sum, csum, noEle, pos+1, n);
		}
		curr_ele[pos] = false;
	}
}
