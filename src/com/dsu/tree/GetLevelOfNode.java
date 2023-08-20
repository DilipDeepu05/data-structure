package com.dsu.tree;

public class GetLevelOfNode {

	Node root;
	public static void main(String[] args)
	{
		GetLevelOfNode tree = new GetLevelOfNode();

		/* Constructing tree given in the above figure */
		tree.root = new Node(3);
		tree.root.left = new Node(2);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		for (int x = 1; x <= 5; x++) {
			int level = tree.getLevel(tree.root, x);
			if (level != 0)
				System.out.println(
						"Level of " + x + " is "
								+ tree.getLevel(tree.root, x));
			else
				System.out.println(
						x + " is not present in tree");
		}
	}
	
	private int getLevel(Node root, int x) {
		return getLevelRec(root, x, 1);
	}
	
	private int getLevelRec(Node root, int x, int level) {
		if(root == null) {
			return 0;
		}
		
		if(root.key == x) {
			return level;
		}

		int downLevel = getLevelRec(root.left, x, level+1);
		if(downLevel != 0) {
			return downLevel;
		}
		
		downLevel = getLevelRec(root.right, x, level+1);
		
		return downLevel;
	}
}
