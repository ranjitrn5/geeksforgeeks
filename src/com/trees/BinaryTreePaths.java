package com.trees;

import java.util.ArrayList;

import java.util.List;

public class BinaryTreePaths {
	
	public static void rootToLeafPaths(Node root){
		int[] path = new int[1000];
		rootToLeafPathUtil(root, path, 0);
		
	}
	
	public static void rootToLeafPathUtil(Node root, int[] path, int  pathLength){
		if(root == null){
			return;
		}
		//List<Node> resultList = new ArrayList<Node>();
		path[pathLength++]=root.data;
		if(root.left == null && root.right == null){
			printPath(path, pathLength);
		}
		else{
			rootToLeafPathUtil(root.left, path, pathLength);
			rootToLeafPathUtil(root.right, path, pathLength);
		}
	}
	
	public static void printPath(int[] arr, int len){
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
  
        /* Print all root-to-leaf paths of the input tree */
        rootToLeafPaths(tree.root);

	}

}
