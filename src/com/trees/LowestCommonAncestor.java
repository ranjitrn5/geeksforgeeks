package com.trees;

public class LowestCommonAncestor {
	
	public static Node getLca(Node root, int n1, int n2){
		if(root == null){
			return null;
		}
		if(root.data == n1 || root.data == n2){
			return root;
		}
		
		Node left = getLca(root.left, n1, n2);
		Node right = getLca(root.right, n1, n2);
		
		if(left == null && right == null){
			return null;
		}
		
		if(left != null && right != null){
			return root;
		}
		
		return left!=null ? left:right;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(3);
		tree.root.left = new Node(6);
		tree.root.right = new Node(8);
		tree.root.left.left = new Node(2);
		tree.root.left.right = new Node(11);
		tree.root.left.right.left = new Node(9);
		tree.root.left.right.right = new Node(5);
		tree.root.right.right = new Node(13);
		
		System.out.println("Ancestor for Nodes(2,9): "+getLca(tree.root, 2, 9).data);

	}

}
