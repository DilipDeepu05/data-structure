package com.dsu.tree;

import java.util.ArrayList;
import java.util.List;

public class PossibleTreesWithInOrder {

	  public static void main(String args[]) {
	        int in[] = {4, 5, 7};
	        int n = in.length;
	        PossibleTreesWithInOrder tree = new PossibleTreesWithInOrder();
	        List<Node> trees = tree.getTrees(in, 0, n - 1);
	        System.out.println("Preorder traversal of different "+
	                           " binary trees are:");
	        for (int i = 0; i < trees.size(); i++) {
	            tree.preOrder(trees.get(i));
	            System.out.println("");
	        }
	    }

	private List<Node> getTrees(int[] in, int start, int end) {
		List<Node> ls = new ArrayList<>();
		
		if(start > end) {
			ls.add(null);
			return ls;
		}
		
		for(int i = start; i <= end; ++i) {
			List<Node> l = getTrees(in, start, i - 1);
			List<Node> r = getTrees(in, i+1, end);
			
			for(int j = 0; j < l.size(); j++) {
				for(int k =0 ; k < r.size(); ++k) {
					
					
					Node n = new Node(in[i]);
					n.left = l.get(j);
					n.right = r.get(k);
					
					ls.add(n);
				}
			}
		}
		
		return ls;
	}

	private void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.key+ " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}
