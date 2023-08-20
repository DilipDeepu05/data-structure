package com.dsu.bsearchtree;

public class RemoveAllLeaf {

    public static void main(String[] args)
    {
        Node root = null;
        root = insert(root, 20);
        insert(root, 10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 30);
        insert(root, 25);
        insert(root, 35);
        System.out.println("Inorder before Deleting the leaf Node. ");
        inorder(root);
        System.out.println();
        leafDelete(root);
        System.out.println("INorder after Deleting the leaf Node. ");
        inorder(root);
    }

	private static Node leafDelete(Node root) {
		if(root == null) {
			return null;
		}
		
		if(root.left == null && root.right == null) {
			return null;
		}
		
		root.left = leafDelete(root.left);
		root.right = leafDelete(root.right);
		return root;
	}

	private static void inorder(Node root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.data+ " ");
			inorder(root.right);
		}
	}

	private static Node insert(Node root, int i) {
		if(root == null) {
			return new Node(i);
		}
		
		if(i < root.data) {
			root.left = insert(root.left, i);
		} else if(i > root.data) {
			root.right = insert(root.right, i);
		}
		return root;
	}
}
