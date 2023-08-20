package com.dsu.bsearchtree;

public class KthSmallestBST {
//reverse morris for kth largest
	//morris for kth smallest
	public static void printKthSmallest(Node root, int k)
	{
		Node res = kthSmallest(root, k);
		if (res == null)
			System.out.println("There are less than k nodes in the BST");
		else
			System.out.println("K-th Smallest Element is " + res.data);
		
		System.out.println("K-th Smallest Element is " + KSmallestUsingMorris(root, k));
	}

	static int KSmallestUsingMorris(Node root, int k)
	{
	    // Count to iterate over elements till we
	    // get the kth smallest number
	    int count = 0;
	 
	    int ksmall = Integer.MIN_VALUE; // store the Kth smallest
	    Node curr = root; // to store the current node
	 
	    while (curr != null)
	    {
	        // Like Morris traversal if current does
	        // not have left child rather than printing
	        // as we did in inorder, we will just
	        // increment the count as the number will
	        // be in an increasing order
	        if (curr.left == null)
	        {
	            count++;
	 
	            // if count is equal to K then we found the
	            // kth smallest, so store it in ksmall
	            if (count==k)
	                ksmall = curr.data;
	 
	            // go to current's right child
	            curr = curr.right;
	        }
	        else
	        {
	            // we create links to Inorder Successor and
	            // count using these links
	            Node pre = curr.left;
	            while (pre.right != null && pre.right != curr)
	                pre = pre.right;
	 
	            // building links
	            if (pre.right== null)
	            {
	                //link made to Inorder Successor
	                pre.right = curr;
	                curr = curr.left;
	            }
	 
	            // While breaking the links in so made temporary
	            // threaded tree we will check for the K smallest
	            // condition
	            else
	            {
	                // Revert the changes made in if part (break link
	                // from the Inorder Successor)
	                pre.right = null;
	 
	                count++;
	 
	                // If count is equal to K then we found
	                // the kth smallest and so store it in ksmall
	                if (count==k)
	                    ksmall = curr.data;
	 
	                curr = curr.right;
	            }
	        }
	    }
	    return ksmall; //return the found value
	}
	
	static int count = 0;
	private static Node kthSmallest(Node root, int k) {
		if(root == null) {
			return null;
		}

		Node left = kthSmallest(root.left, k);

		if(left != null) {
			return left;
		}
		
		count++;
		if(count == k) {
			return root;
		}

		return kthSmallest(root.right, k);

	}

	public static void main(String[] args)
	{
		Node root = null;
		int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
		for (int x : keys)
			root = insert(root, x);
		int k = 3;
		printKthSmallest(root, k);
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
