package com.dsu.dp;

public class MinimumJump {

	public static void main(String[] args)
	{
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

		System.out.println(
				"Minimum number of jumps to reach end is : "
						+ minJumps(arr, arr.length));
	}

	private static int minJumps(int[] arr, int length) {
		if(length == 0 || arr[0] == 0) {
			return  0;
		}
		int jump[] = new int[length];
		jump[0] = 0;
		for(int i = 1; i < length; i++) {
			jump[i] =  Integer.MAX_VALUE;
			for(int j = 0; j < i ;j++) {
				if(i <= j +arr[j] && jump[j] != Integer.MAX_VALUE) {
					jump[i] = Math.min(jump[i], jump[j]+ 1);
				}
			}
		}
		return jump[length -1];
	}
}
