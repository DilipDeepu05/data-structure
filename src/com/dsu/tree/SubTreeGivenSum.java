package com.dsu.tree;

class Int {
	int v;
	Int(int v) {
		this.v = v;
	}
}

public class SubTreeGivenSum {
	public static void main(String args[])
	{
	    Node root = new Node(8);
	    root.left = new Node(5);
	    root.right = new Node(4);
	    root.left.left = new Node(9);
	    root.left.right = new Node(7);
	    root.left.right.left = new Node(1);
	    root.left.right.right = new Node(12);
	    root.left.right.right.right = new Node(2);
	    root.right.right = new Node(11);
	    root.right.right.left = new Node(3);
	    int sum = 22;
	 
	    if (sumSubtree(root, sum))
	        System.out.println( "Yes");
	    else
	        System.out.println( "No");
	}

	private static boolean sumSubtree(Node root, int sum) {
		return sumSubTreeRec(root, new Int(0), sum);
	}

	private static boolean sumSubTreeRec(Node root, Int curr, int sum) {
		if(root == null) {
			return false;
		}
		
		
		Int l = new Int(0);
		Int r = new Int(0);

		return sumSubTreeRec(root.left, l, sum) || sumSubTreeRec(root.right, r, sum) ||
				((curr.v = l.v + r.v+ root.key) == sum); 
	}
}
