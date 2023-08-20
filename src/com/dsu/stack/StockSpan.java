package com.dsu.stack;

public class StockSpan {

	 static void printArray(int arr[], int n)
	    {
	        for (int i = 0; i < n; i++)
	            System.out.print(arr[i] + " ");
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	        int price[] = { 10, 4, 5, 90, 120, 80 };
	        int n = price.length;
	        int S[] = new int[n];
	 
	        // Fill the span values in array S[]
	        calculateSpan(price, n, S);
	 
	        // print the calculated span values
	        printArray(S, n);
	    }

		private static void calculateSpan(int[] price, int n, int[] s) {
			// TODO Auto-generated method stub
			s[0] = 1;
			int counter = 0;
			for(int i = 1; i < n; ++i) {
				counter = 1;
				
				while(((i - counter) >= 0) && (price[i] >= price[i - counter])) {
					counter+= s[i - counter];
				}
				
				s[i] = counter;
			}
		}
}
