package com.dsu.tree;

import com.dsu.tree.DuplicateSubTreeSize2.Node;

class Height {
	int h;
}
public class DiameterOfBTree {
	
	Node root;
    public static void main(String args[])
    {
        // creating a binary tree and entering the nodes
    	DiameterOfBTree tree = new DiameterOfBTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
 
        // Function Call
        System.out.println("The diameter of given binary tree is : " + tree.diameter());
    }
    
	private int diameter() {
		return diameterRec(root, new Height());
	}

	private int diameterRec(Node root, Height height) {
		Height lh = new Height(), rh = new Height();
		if(root == null) {
			height.h = 0;
			return 0;
		}
		
		int l = diameterRec(root.left, lh);
		int r = diameterRec(root.right, rh);
		
		height.h = Math.max(lh.h, rh.h) + 1;
		
		return Math.max(lh.h + rh.h + 1, Math.max(l, r));
	}
}
