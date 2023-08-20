package com.dsu.hash;

public class SmallestSubArrayWithK {

	public static void main(String[] args)
	{
		int arr[] = { 1, 1, 2, 2, 3, 3, 4, 5 };
		int n = arr.length;
		int k = 3;

		minRange(arr, n, k);
	}

	private static void minRange(int[] arr, int n, int k) {
		int start = 0;
		int end = n;
		int j = 0;
		int i =0;

		java.util.Map<Integer, Integer> m = new java.util.HashMap<>();

		while(j < n) {
			m.put(arr[j], m.getOrDefault(arr[j], 0)+1);
			j++;
			if(j < k) {
				continue;
			}

			while(m.size() == k) {
				int index = (j - 1 )- i + 1;
				int len = end - start + 1;
				if(index < len) {
					start = i;
					end = j -1;
				}

				if(m.get(arr[i]) == 1) {
					m.remove(arr[i]);
				}
				else {
					m.put(arr[i], m.get(arr[i]) - 1);
				}
				i++;
			}

		}

		if (start == 0 && end == n)
			System.out.println("Invalid k");

		else
			System.out.println(start + " " + end);
	}
}
