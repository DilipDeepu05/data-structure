package com.dsu.tree;

public class LargestSubTreeSum {

	static int ans = 0;
	 public static void main(String[] args)
	  {
	    /*
	                1
	                / \
	                /   \
	            -2   3
	            / \ / \
	            / \ / \
	            4 5 -6 2
	        */
	 
	    Node root = new Node(1);
	    root.left = new Node(-2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(-6);
	    root.right.right = new Node(2);
	 
	    System.out.println(findLargestSubtreeSum(root));
	  }

	private static int findLargestSubtreeSum(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return root.key;
		}
		
		int a = dfs(root);
		return ans;
	}

	private static int dfs(Node root) {
		if(root == null) {
			return 0;
		}
		
		if(root.left == null && root.right == null) {
			return root.key;
		}
		
		int sumleft = dfs(root.left);
		int sumright = dfs(root.right);
		
		int sumRoot = sumleft + sumright + root.key;
		
		int tempMax = Math.max(sumleft, sumright);
		
		tempMax = Math.max(tempMax, sumRoot);
		
		ans  = Math.max(ans, tempMax);
		
		return sumRoot;
	}
}
