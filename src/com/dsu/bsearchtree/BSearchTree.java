package com.dsu.bsearchtree;

import java.util.Stack;

class Node {
	Node left, right;
	int data;
	Node(int k) {
		data = k;
	}
}
public class BSearchTree {

	static Node root;

	public static void main(String[] args)
	{
		BSearchTree tree = new BSearchTree();
		tree.insert(30);
		tree.insert(50);
		tree.insert(15);
		tree.insert(20);
		tree.insert(10);
		tree.insert(40);
		tree.insertRec(root, 60);
		tree.inorder();
		System.out.println();
		System.out.println("Is element exist in the tree: " + search(root, 60));
		tree.deleteNode(root, 30);
		tree.inorder();
		System.out.println();
		System.out.println("IsBST: " + isBST(root));
		System.out.println("Get Min value: " + minValue(root));
		System.out.println("BST is height balanced: " + isHeightBalanced(root));

		int a[] = {8, 3, 6, 1, 4, 7, 10, 14, 13};
		int b[] = {8, 10, 14, 3, 6, 4, 1, 7, 13};
		int n=a.length;
		System.out.printf("%s\n", isSameBST(a, b, n)?
				"BSTs are same":"BSTs not same");

		tree.modifyBST(root);
		tree.inorder();
		System.out.println();

		int k = 3;
		int count = ksmallestElementSum(root, k);
		System.out.println(count);
	}
	
	static int count;

	private static int ksmallestElementSum(Node root, int k) {
		if(root == null) {
			return 0;
		}
		
		if(count >= k) {
			return 0;
		}
		
		int res = ksmallestElementSum(root.left, k);
		count++;
		res += root.data;
		
		if(count >= k) {
			return res;
		}
		return res + ksmallestElementSum(root.right, k);
	}

	static int sum = 0;
	private static void modifyBST(Node root) {
		if(root == null) {
			return;
		}

		modifyBST(root.left);
		sum += root.data;
		root.data = sum;
		modifyBST(root.right);
	}

	private static boolean isSameBST(int[] a, int[] b, int n) {
		return isSame(a,b,n, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	private static boolean isSame(int[] a, int[] b, int n, int s1, int s2, int max, int min) {
		int j,i;

		for(i = s1; i < n; i++) {
			if(a[i] > min && a[i] < max) break;
		}
		for(j = s2; j < n; j++) {
			if(b[j] > min && b[j] < max) break;
		}


		if(i == n &&  j== n) {
			return true;
		}

		if( ((i==n) ^ (j == n)) || a[i] != b[j]) {
			return false;
		}
		return isSame(a, b, n, i+1, j+1, a[i], min) && isSame(a, b, n, i+1, j+1, max, a[i]);
	}

	private static int isHeightBalanced(Node root) {
		if(root == null) {
			return  0;
		}

		int l = isHeightBalanced(root.left);
		if(l == -1) {
			return -1;
		}

		int r = isHeightBalanced(root.right); 
		if(r == -1){
			return -1;
		}

		if(Math.abs(r - l) > 1) {
			return -1;
		} else
			return Math.max(l, r) + 1;
	}

	private static int minValue(Node root) {
		while(root.left !=null) {
			root = root.left;
		}
		return root.data;
	}

	private static boolean isBST(Node root) {
		return isBSTUtil(root);
	}

	static Node prev = null;
	private static boolean isBSTUtil(Node root) {
		if(root != null) {
			if(!isBST(root.left)) return false;

			if(prev != null && root.data <= prev.data) {
				return false;
			}

			prev = root;

			return isBST(root.right);
		}
		return true;
	}

	public Node sortedArrayToBST(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}

	public Node construct(int[] nums, int start, int end) {
		if(start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		Node n = new Node(nums[mid]);

		n.left = construct(nums, start, mid - 1);
		n.right = construct(nums, mid + 1, end);
		return n;
	}

	private Node deleteNode(Node root, int data) {
		if(root == null) {
			return root;
		}

		if(root.data > data) {
			root.left = deleteNode(root.left, data);
			return root;
		} else if(root.data < data) {
			root.right = deleteNode(root.right, data);
			return root;
		}


		if(root.left == null) {
			return root.right;
		} else if(root.right == null) {
			return root.left;
		} else {
			Node succPar = root;
			Node curr = root.right;
			while(curr.left != null) {
				succPar = curr;
				curr =curr.left;
			}
System.out.println(root.data+ " "+ succPar.data+ " "+curr.data);
			if(succPar != root) {
				succPar.left = curr.right;
			} else {
				succPar.right = curr.right;
			}

			root.data = curr.data;
		}
		return root;
	}

	private static boolean search(Node root, int i) {
		return searchRec(root, i).data == i;
	}

	private static boolean iterativeSearch(Node root, int key) {
		while(root != null) {
			if(root.data < key) {
				root = root.right;
			} else if(root.data > key) {
				root = root.left;
			} else {
				return true;
			}
		}
		return false;
	}

	private static Node searchRec(Node root, int key) {
		if(root == null || root.data == key) {
			return root;
		}

		if(root.data < key) {
			return searchRec(root.right, key);
		}

		return searchRec(root.left, key);
	}

	private Node insertRec(Node root, int data) {
		Node n = new Node(data);
		if(root == null) {
			root = n;
			return root;
		}

		if(root.data > data ) {
			root.left = insertRec(root.left, data);
		}

		if(root.data < data) {
			root.right = insertRec(root.right, data);
		}

		return root;
	}

	private void insert(int data) {
		Node n = new Node(data);
		if(root == null) {
			root = n;
			return;
		} else {
			Node prev = null;
			Node curr = root;
			while(curr != null) {
				if(curr.data > data) {
					prev = curr;
					curr = curr.left;
				}
				else if(curr.data < data) {
					prev = curr;
					curr = curr.right;
				}
			}

			if(prev.data > data) {
				prev.left = n;
			} else {
				prev.right = n;
			}
		}
	}

	private void inorder() {
		if(root != null) {
			Node curr = root;
			Stack<Node> s = new Stack<>();
			while(curr != null || !s.isEmpty()) {
				if(curr !=null) {
					s.push(curr);
					curr = curr.left;
				} else {
					curr = s.pop();
					System.out.print(curr.data+ " ");
					curr = curr.right;
				}
			}
		}
	}
}
