package com.dsu.dp;

public class CatlanNumber {

	public static void main(String[] args)
    {
		CatlanNumber cn = new CatlanNumber();
        for (int i = 0; i < 10; i++) {
            System.out.print(cn.catalan(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(cn.catalanDp(i) + " ");
        }
    }

	private int catalanDp(int n) {
		int a[] = new int[n + 2];
		
		a[0] = 1;
		a[1] = 1;
		
		for(int i = 2; i<= n; i++) {
			a[i] = 0;
			for(int j =0; j < i;j++) {
				a[i] += a[j] * a[i-j-1];
			}
		}
		return a[n];
	}

	private int catalan(int n) {
		int res = 0;
		
		if(n <= 1) {
			return 1;
		}
		
		for(int i =0;i < n; i++) {
			res += catalan(i) * catalan(n -i -1);
		}
		return res;
	}
}
