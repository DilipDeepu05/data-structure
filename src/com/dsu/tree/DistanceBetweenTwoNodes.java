package com.dsu.tree;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DistanceBetweenTwoNodes {

	static final Logger log = Logger.getAnonymousLogger();
	 public static void main(String[] args) throws SecurityException, IOException
	    {
	 
	        // Let us create binary tree given in
	        // the above 
		 	log.info("log the data");
	        Node root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.right.left = new Node(6);
	        root.right.right = new Node(7);
	        root.right.left.right = new Node(8);
	        System.out.println("Dist(4, 5) = "
	                           + findDistance(root, 4, 5));
	        getLogs();
	        log.info("log the data");
	        //	 
//	        System.out.println("Dist(4, 6) = "
//	                           + findDistance(root, 4, 6));
//	 
//	        System.out.println("Dist(3, 4) = "
//	                           + findDistance(root, 3, 4));
//	 
//	        System.out.println("Dist(2, 4) = "
//	                           + findDistance(root, 2, 4));
//	 
//	        System.out.println("Dist(8, 5) = "
//	                           + findDistance(root, 8, 5));
	    }

	private static void getLogs() throws SecurityException, IOException {
		FileHandler f = new FileHandler("D:\\InStructions.txt");
	
		f.setFormatter(new SimpleFormatter());
		log.addHandler(f);
	}

	private static int findDistance(Node root, int n1, int n2) {
		if(root == null) {
			return -1;
		}
		
		Node l = findLca(root, n1, n2);
		
		int d1 = findLevel(l, n1 , 0);
		int d2 = findLevel(l, n2, 0);
		
		return d1 + d2;
	}

	private static int findLevel(Node root, int n, int level) {
		if(root == null) {
			return -1;
		}
		if(root.key == n) {
			return level;
		}
		
		int l = findLevel(root.left, n, level + 1);
		if(l == -1) {
			return findLevel(root.right, n, level + 1);
		}
		return l;
	}

	private static Node findLca(Node root, int n1, int n2) {
		if(root == null) {
			return null;
		}
		
		if(root.key ==  n1 || root.key == n2) {
			return root;
		}
		
		Node l = findLca(root.left, n1, n2);
		Node r = findLca(root.right, n1, n2);
		System.out.println((l != null ? l.key : 0) + " "+ (r != null ? r.key : 0)+ " "+ root.key);
		if( l != null && r != null) {
			return root;
		}
		
		return l != null ? l : r;
	}
}
