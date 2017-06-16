package com.trees;

public class LowestCommonAncestorBinarySearchTree {
	
	public static Node getLca(Node root, int n1, int n2){
		if(root.data > n1 && root.data > n2){
			return getLca(root.left,n1,n2);
		}
		else if(root.data < n1 && root.data < n2){
			return getLca(root.right, n1, n2);
		}
		else{
			return root;
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(10);
		tree.addNode(-10);
		tree.addNode(30);
		tree.addNode(8);
		tree.addNode(25);
		tree.addNode(60);
		tree.addNode(6);
		tree.addNode(9);
		tree.addNode(28);
		tree.addNode(78);
		
		System.out.println("Lowest Common Ancestor of (9,78): "+getLca(tree.root, 9, 78).data);
		

	}

}
