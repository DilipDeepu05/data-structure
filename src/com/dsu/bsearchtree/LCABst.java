package com.dsu.bsearchtree;

public class LCABst {

	// figure
	public	 static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		// Function calls
		int n1 = 10, n2 = 14;
		Node t = lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2
				+ " is " + t.data);

		n1 = 14;
		n2 = 8;
		t = lca(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2
				+ " is " + t.data);

		n1 = 10;
		n2 = 22;
		t = lcaM(root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2
				+ " is " + t.data);
	}

	private static Node lcaM(Node root, int n1, int n2) {
		if(root == null) {
			return null;
		}

		while(root != null) {
			if(root.left == null) {
				if(root.data  == n1  || root.data == n2) {
					return root;
				}
				root = root.right;
			} else {
				Node prev = root.left;
				while(prev.right != null && prev.right != root) {
					prev = prev.right;
				}

				if(prev.right == null) {
					prev.right = root;
					root =root.left;
				} else {
					prev.right = null;
					if(root.data == n1 || root.data == n2) {
						return root;
					}
					root= root.right;
				}
			}
		}
		return null;
	}

	private static Node lca(Node root, int n1, int n2) {
		//		if(root == null) {
		//			return null;
		//		}
		//		
		//		if(root.data > n1 && root.data > n2) {
		//			return lca(root.left, n1, n2);
		//		}
		//		
		//		if(root.data <n1 && root.data < n2) {
		//			return lca(root.right, n1, n2);
		//		}
		//		
		//		return root;

		while(root != null) {
			if(root.data > n1 && root.data > n2) {
				root = root.left;
			} else if(root.data < n1 && root.data < n2) {
				root = root.right;
			} else {
				break;
			}
		}
		return root;
	}
}
