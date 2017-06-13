package com.trees;

public class BinaryTreeSize {
	
	public static int getTreeSize(Node root){
		if(root == null){
			return 0;
		}
		
		int leftSize = getTreeSize(root.left);
		int rightSize = getTreeSize(root.right);
		return leftSize+rightSize+1;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
	 	bt.addNode(10);
        bt.addNode(15);
        bt.addNode(19);
        bt.addNode(17);
        bt.addNode(11);
        bt.addNode(-11);
        
        System.out.println("Size of Binary Tree: "+getTreeSize(bt.root));

	}

}
