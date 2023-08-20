package com.dsu.greedy;

public class MaximumPossibleSum {

	public static void main(String[] args)
	{
		int stack1[] = { 3, 2, 1, 1, 1 };
		int stack2[] = { 4, 3, 2 };
		int stack3[] = { 1, 1, 4, 1 };

		int n1 = stack1.length;
		int n2 = stack2.length;
		int n3 = stack3.length;

		System.out.println(maxSum(stack1, stack2,
				stack3, n1, n2, n3));
	}

	private static int maxSum(int[] stack1, int[] stack2, int[] stack3, int n1, int n2, int n3) {
		int s1 =0, s2 =0, s3 =0;
		
		for(int i: stack1) {
			s1 += i;
		}
		
		for(int i: stack2) {
			s2 += i;
		}
		
		for(int i: stack3) {
			s3 += i;
		}
		
		int t1 = 0, t2 = 0, t3 =0;
		
		
		while(true) {
			if(t1 == n1 || t2 == n2 || t3 == n3) {
				return 0;
			}
			
			if(s1 == s2 && s2 == s3) {
				return s1;
			}
			
			if(s1 >= s2 && s1 >= s3) {
				s1 -= stack1[t1++];
			} else if(s2 >= s1 && s2 >= s3) {
				s2 -= stack2[t2++];
			} else if(s3 >= s1 && s3 >= s2) {
				s3 -= stack3[t3++];
			}
		}
	}
}
