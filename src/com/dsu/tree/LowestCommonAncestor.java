package com.dsu.tree;

public class LowestCommonAncestor {
	static Node root;
	public static void main(String args[])
    {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println("LCA(4, 5) = "
                           + findLCA(4, 5).key);
        System.out.println("LCA(4, 6) = "
                           + findLCA(4, 6).key);
        System.out.println("LCA(3, 4) = "
                           + findLCA(3, 4).key);
        System.out.println("LCA(2, 4) = "
                           + findLCA(2, 4).key);
    }

	private static Node findLCA(int n1, int n2) {
		
		return findLCA(root , n1, n2);
	}

	private static Node findLCA(Node root, int n1, int n2) {
		if(root == null) {
			return null;
		}
		
		if(root.key == n1  || root.key == n2) {
			return root;
		}
		
		Node l = findLCA(root.left, n1, n2);
		Node r = findLCA(root.right, n1, n2);
		
		
		if(l != null && r != null) {
			return root;
		}
		
		return l != null ? l : r;
	}
}
