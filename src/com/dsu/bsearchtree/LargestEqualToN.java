package com.dsu.bsearchtree;

public class LargestEqualToN {

	public static void main(String[] args)
	{
		int N = 50;
		Node root = insert(null, 5);
		insert(root, 2);
		insert(root, 1);
		insert(root, 3);
		insert(root, 12);
		insert(root, 9);
		insert(root, 21);
		insert(root, 19);
		insert(root, 25);

		findMaxforN(root, N);
	}

	private static void findMaxforN(Node root, int n) {
		while(root != null && root.right != null) {
			if(n > root.data && n > root.right.data) {
				root = root.right;
			} else if ( n < root.data) {
				root = root.left;
			}
			else {
				break;
			}
		}
		
		if(root == null || root.data > n) {
			System.out.println(-1);
		} else {
			System.out.println(root.data);
		}
		
	}

	private static Node insert(Node root, int x) {
		if(root == null) {
			return new Node(x);
		}

		if(root.data < x) {
			root.right = insert(root.right, x);
		}

		else if(root.data > x) {
			root.left = insert(root.left, x);
		}

		return root;
	}
}
