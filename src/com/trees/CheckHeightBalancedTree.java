package com.trees;

public class CheckHeightBalancedTree {
	
	public static boolean isHeightBalanced(Node root){
		if(checkHeight(root) < 0){
			return false;
		}
		return true;
	}
	
	public static int checkHeight(Node root){
		if(root == null){
			return 0;
		}
		int lHeight = checkHeight(root.left);
		int rHeight = checkHeight(root.right);
		
		if(lHeight==-1 || rHeight==-1){
			return -1;
		}
		
		if(Math.abs(lHeight-rHeight) > 1){
			return -1;
		}
		
		return (1+Math.max(lHeight, rHeight));
	}

	public static void main(String[] args) {
	       BinaryTree tree = new BinaryTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.right = new Node(5);
	        tree.root.left.left.left = new Node(7);
	        
	        System.out.println(isHeightBalanced(tree.root));

	}

}
