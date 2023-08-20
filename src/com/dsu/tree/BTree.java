package com.dsu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

public class BTree {

	Node root;

	BTree(int key) {
		root = new Node(key);
	}

	public static void main(String[] args) {
		BTree b = new BTree(1);
		b.root.left = new Node(2);
		b.root.right = new Node(3);
		b.root.left.left = new Node(4);
		b.root.left.right = new Node(5);
		b.root.right.left = new Node(6);
		System.out.println("Inorder: ");
		b.printInOrder(b.root);
		System.out.println();
		System.out.println("Inorder iterative: ");
		b.printInOrderIterative();
		System.out.println();
		System.out.println("Inorder morris iterative: ");
		
		b.printMorrisInOrder();
		System.out.println();
		System.out.println("Preorder morris iterative: ");
		b.printMorrisPreOrder();
		System.out.println();
		System.out.println("Preorder: ");
		b.printPreOrder(b.root);
		System.out.println();
		System.out.println("Preorder iterative: ");
		b.printPreOrderIterative(b.root);
		System.out.println();
		System.out.println("PostOrder: ");
		b.printPostOrder(b.root);
		System.out.println();
		System.out.println("PostOrder Iterative: ");
		b.printPostOrderIterative(b.root);
		System.out.println();
		System.out.println("Level Order: ");
		System.out.println();
		b.printLevelOrder(b.root);
		System.out.println();
		System.out.println("Diagonal Tree: ");
		System.out.println();
		b.printDiagonal(b.root);
		System.out.println();
		System.out.println("Boundary: ");
		b.printBoundary(b.root);
		System.out.println();
		//		System.out.println("Spiral Form: ");
		//		b.printSpiralForm();
		//		System.out.println("Sprial Form With Stack: ");
		//		b.printSpiralFormStack();
		System.out.println("Reverse Tree: ");
		b.reverse();
		System.out.println();
		b.insert(b.root, 10);
		b.delete(b.root, 5);
		System.out.println("Tree height or max depth: "+ b.maxHeight(b.root));
	}
	
	private void printBoundary(Node root) {
		if(root == null) {
			return;
		} else {
			System.out.print(root.key+ " ");
			printLeftBoundary(root.left);
			printLeaves(root.left);
			printLeaves(root.right);
			printRightBoundary(root.right);
		}
		
	}

	private void printRightBoundary(Node root) {
		if(root == null) {
			return;
		}
		
		if(root.right != null) {
			printRightBoundary(root.right);
		} else {
			printRightBoundary(root.left);
		}
		if(root.left != null || root.right != null) {
			System.out.print(root.key+ " ");
		}
	}

	private void printLeaves(Node root) {
		if(root == null) {
			return;
		}
		
		printLeaves(root.left);		
		if(root.left == null && root.right == null) {
			System.out.print(root.key+ " ");
		}
		printLeaves(root.right);
	}

	private void printLeftBoundary(Node root) {
		if(root == null) {
			return;
		} else {
			if(root.left != null  || root.right != null) {
				System.out.print(root.key+ " ");
			} 
			if(root.left != null) {
				printLeftBoundary(root.left);
			} else {
				printLeftBoundary(root.right);
			}
		}
	}

	private void printDiagonal(Node root) {
		if(root == null) {
			return;
		}
		
		Map<Integer, List<Integer>> m = new TreeMap<>();
		Queue<TNode> q = new LinkedList<>();
		q.add(new TNode(root, 0));
		
		while(!q.isEmpty()) {
			TNode curr = q.poll();
			m.putIfAbsent(curr.level, new ArrayList<>());
			m.get(curr.level).add(curr.node.key);
			
			if(curr.node.left != null) {
				q.add(new TNode(curr.node.left , curr.level + 1));
			}
			
			if(curr.node.right != null) {
				q.add(new TNode(curr.node.right , curr.level));
			}
		}
		
		for(int i: m.keySet()) {
			List<Integer> ls = m.get(i);
			
			for(int j: ls) {
				System.out.print(j+ " ");
			}
			System.out.println();
		}
	}

	private void printPostOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.add(root);
		while(!s1.isEmpty()) {
			Node curr = s1.pop();
			s2.push(curr);
			
			if(curr.left != null) {
				s1.push(curr.left);
			}
			
			if(curr.right !=null) {
				s1.push(curr.right);
			}
		}
		
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().key+ " ");
		}
		
	}

	private void printPreOrderIterative(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> s = new Stack<>();
		s.add(root);
		while(!s.isEmpty()) {
			Node curr = s.pop();
			System.out.print(curr.key + " ");
			
			if(curr.right !=null) {
				s.push(curr.right);
			}
			
			if(curr.left != null) {
				s.push(curr.left);
			}
		}
	}

	private void printMorrisPreOrder() {
		if(root == null) {
			return;
		}
		
		Node curr = root;
		Node prev = null;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.key+ " ");
				curr = curr.right;
			} else {
				prev = curr.left;
				
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				
				if(prev.right == null) {
					prev.right = curr;
					System.out.print(curr.key+ " ");
					curr =  curr.left;
				} else {
					prev.right = null;
					curr = curr.right;
				}
			}
		}
		
	}

	private void printMorrisInOrder() {
		if(root  == null) {
			return;
		}

		Node curr = root;
		Node prev = null;
		while(curr != null) {
			if(curr.left == null) {
				System.out.print(curr.key + " ");
				curr = curr.right;
			} else {
				prev = curr.left;

				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}

				if(prev.right == null) {
					prev.right = curr;
					curr = curr.left;

				} else {
					prev.right = null;
					System.out.print(curr.key + " ");
					curr = curr.right;
				}
			}
		}
	}

	private void reverse() {
		if(root == null) {
			return;
		}

		Stack<Node> s = new Stack<>();
		Queue<Node> q = new LinkedList<>();

		q.add(root);

		while(!q.isEmpty()) {
			Node curr = q.poll();

			s.push(curr);

			if(curr.right != null) {
				q.add(curr.right);
			}

			if(curr.left != null) {
				q.add(curr.left);
			}
		}

		while(!s.isEmpty()) {
			System.out.print(s.pop().key+ " ");
		}
	}

	private void printSpiralFormStack() {
		if(root  == null) {
			return;
		}

		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();

		s1.add(root);

		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				Node temp = s1.pop();
				System.out.print(temp.key+ " ");

				if(temp.right != null) {
					s2.push(temp.right);
				}

				if(temp.left !=null) {
					s2.push(temp.left);
				}
			}

			while(!s2.isEmpty()) {
				Node temp = s2.pop();
				System.out.print(temp.key + " ");

				if(temp.left != null) {
					s1.push(temp.left);
				}

				if(temp.right != null) {
					s1.push(temp.right);
				}
			}
		}
	}

	private void printSpiralForm() {
		if(root == null) {
			return ;
		}

		int h = maxHeight(root);
		boolean alt = false;
		for(int i = 1 ; i <= h ; ++i) {
			printGivenLevel(root, i, alt);

			alt = !alt;
		}
	}

	private void printGivenLevel(Node root, int level, boolean alt) {
		if(root == null) {
			return;
		}

		if(level == 1) {
			System.out.print(root.key+ " ");
		} else if(level > 1) {
			if(alt) {
				printGivenLevel(root.left, level-1, alt);
				printGivenLevel(root.right, level-1, alt);
			} else {
				printGivenLevel(root.right, level-1, alt);
				printGivenLevel(root.left, level-1, alt);
			}
		}

	}

	private int maxHeight(Node root) {
		if(root  == null) {
			return 0;
		}

		int lh = maxHeight(root.left);
		int rh = maxHeight(root.right);

		if(lh > rh) {
			return lh+1;
		} else {
			return rh+1;
		}
	}

	private void printInOrderIterative() {
		if(root == null) {
			return;
		}

		Stack<Node> s = new Stack<>();
		Node curr = root;

		while(!s.isEmpty() || curr != null) {

			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.key + " ");
			curr =curr.right;
		}
	}

	private void printLevelOrder(Node root) {
		if(root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			Node curr = q.poll();
			System.out.println(curr.key+ " ");

			if(curr.left != null) {
				q.add(curr.left);
			}
			if(curr.right != null) {
				q.add(curr.right);
			}
		}
	}

	private void printPostOrder(Node root) {
		if(root == null) {
			return;
		}

		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.key+ " ");
	}

	private void printPreOrder(Node root) {
		if(root == null) {
			return;
		}

		System.out.print(root.key + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	private void printInOrder(Node root) {
		if(root == null) {
			return;
		}

		printInOrder(root.left);
		System.out.print(root.key+ " ");
		printInOrder(root.right);
	}

	private Node delete(Node temp, int key) {
		if(root == null) {
			return null;
		}

		if(root.left == null && root.right == null) {
			if(root.key == key) {
				return null;
			} else {
				return null;
			}
		}

		Node curr = null, keyNode = null, last = null;
		Queue<Node> q = new LinkedList<>();

		q.add(temp);

		while(!q.isEmpty()) {
			curr = q.poll();

			if(curr.key == key) {
				keyNode = curr;
			}

			if(curr.left != null) {
				last = curr.left;
				q.add(last);
			}

			if(curr.right != null) {
				last = curr.right;
				q.add(last);
			}
		}

		if(keyNode != null) {
			keyNode.key = curr.key;

			if(last.right == curr) {
				last.right = null;
			} else {
				last.left = null;
			}
		}

		return temp;
	}

	private void insert(Node temp, int i) {
		if(root == null) {
			root = new Node(i);
		} else {
			Queue<Node> q = new LinkedList<>();
			q.add(temp);

			while(!q.isEmpty()) {
				Node curr = q.poll();

				if(curr.left == null) {
					curr.left = new Node(i);
					break;
				} else {
					q.add(curr.left);
				}

				if(curr.right == null) {
					curr.right = new Node(i);
					break;
				} else {
					q.add(curr.right);
				}
			}
		}
	}
}

class TNode {
	int level;
	Node node;
	TNode(Node node, int level) {
		this.node = node;
		this.level = level;
	}
}

class Node {
	Node right, left;
	int key;
	Node(int key) {
		this.key = key;
		this.left = this.right = null;
	}
}