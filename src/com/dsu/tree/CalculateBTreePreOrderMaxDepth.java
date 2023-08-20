package com.dsu.tree;

public class CalculateBTreePreOrderMaxDepth {

	 static public void main(String[] args)
	    {
	        String tree = "nlnnlll";
	        int n = tree.length();
	        System.out.println(findDepth(tree, n));
	    }

	private static int findDepth(String tree, int n) {
		int index = 0;
		return findDepthRec(tree, n, index);
	}

	private static int findDepthRec(String tree, int n, int index) {
		if(index >= n || tree.charAt(index) == 'l') {
			return 0;
		}
		
		int lm = findDepthRec(tree, n, ++index);
		int rm = findDepthRec(tree, n , ++index);
		
		return Math.max(lm, rm) + 1;
	}
}
