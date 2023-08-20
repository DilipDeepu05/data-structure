package com.dsu.bsearchtree;

public class FixBSTSwapTwoNodes {

	static Node first, middle, last, prev = null;
	public static void main (String[] args)
    { 
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);
 
        System.out.println("Inorder Traversal"+
                        " of the original tree");
       
        printInorder(root);
 
        correctBST(root);
 
        System.out.println("\nInorder Traversal"+
                          " of the fixed tree");
        printInorder(root);
    }

	private static void correctBST(Node root) {
		
		correct(root);
		if(first != null && last != null) {
			int t = first.data;
			first.data = last.data;
			last.data = t;
		} else if(first != null && middle != null) {
			int t = first.data;
			first.data = middle.data;
			middle.data = t;
		}
	}

	private static void correct(Node root) {
		if(root == null) {
			return;
		}
		
		correct(root.left);
		
		if(prev != null && root.data < prev.data) {
			if(first== null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		}
		
		prev = root;
		
		correct(root.right);
	}

	private static void printInorder(Node root) {
		if(root != null) {
			printInorder(root.left);
			System.out.print(root.data+ " ");
			printInorder(root.right);
		}
	}
}
