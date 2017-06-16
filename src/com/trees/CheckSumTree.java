package com.trees;

public class CheckSumTree {
	
	public static boolean isSumTree(Node root){
		if(root == null){
			return true;
		}
		
		if(root.left == null && root.right == null){
			return true;
		}
		
		int leftSum = add(root.left);
		int rightSum = add(root.right);
		
		if(root.data == leftSum+rightSum){
			if(isSumTree(root.left) && isSumTree(root.right)){
				return true;
			}
		}
		return false;
	}
	
	public static int add(Node root){
		if(root == null){
			return 0;
		}
		return add(root.left)+root.data+add(root.right);
	}

	public static void main(String[] args) {
		
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
        
        if(isSumTree(tree.root)){
        	System.out.println("It is sum tree");
        }
        else{
        	System.out.println("Not a sum tree");
        }

	}

}
