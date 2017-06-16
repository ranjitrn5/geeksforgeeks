package com.trees;

public class MinimumDepthBinaryTree {
	
	public static int getMinDepth(Node root){
		if(root == null){
			return 0;
		}
		
		if(root.left == null && root.right == null){
			return 1;
		}
		
		int leftDepth = (root.left!=null)?getMinDepth(root.left):Integer.MAX_VALUE;
		int rightDepth = (root.right != null)?getMinDepth(root.right):Integer.MAX_VALUE;
		
		return (1+Math.min(leftDepth, rightDepth));
	}

	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        System.out.println("Minimum Depth: "+getMinDepth(tree.root));

	}

}
