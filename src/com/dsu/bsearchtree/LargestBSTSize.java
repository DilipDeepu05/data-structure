package com.dsu.bsearchtree;

public class LargestBSTSize {

	public static void main(String[] args)
	{
		final Node node1 = new Node(60);
		node1.left = new Node(65);
		node1.right = new Node(70);
		node1.left.left = new Node(50);

		System.out.print("Size of the largest BST is "+ largestBst(node1));
	}

	static class NodeInfo {
		int max;
		int min;
		boolean isBST;
		int size;
		NodeInfo() {};
		public NodeInfo(int max, int min, boolean isBST, int size) {
			this.max = max;
			this.min = min;
			this.isBST = isBST;
			this.size = size;
		}
	}
	private static int largestBst(Node root) {
		if(root == null) {
			return 0;
		}
		
		return largest(root).size;
	}
	private static NodeInfo largest(Node root) {
		if(root == null) {
			return new NodeInfo(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
		}
		
		NodeInfo  l = largest(root.left);
		NodeInfo r = largest(root.right);
		
		NodeInfo res = new NodeInfo();
		res.min = Math.min(l.min, root.data);
		res.max = Math.max(r.max, root.data);
		res.isBST = l.isBST && r.isBST && root.data > l.max && root.data < r.min;
		
		if(res.isBST) {
			res.size = l.size + r.size + 1;
		} else {
			res.size = Math.max(l.size, r.size);
		}
		return res;
	}
}
