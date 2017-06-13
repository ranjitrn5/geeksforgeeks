package com.trees;

import java.util.Stack;

public class CheckBinarySearchTree {
	
	public static boolean isBST(Node root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.data <= min || root.data > max){
			return false;
		}
		
		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	public static boolean isBSTIterative(Node root){
		if(root == null){
			return true;
		}
		
		Stack<Node> s = new Stack<Node>();
		int current;
		int prev = Integer.MIN_VALUE;
		
		while(true){
			if(root != null){
				s.push(root);
				root = root.left;
			}
			else{
				if(s.isEmpty()){
					break;
				}
				else{
					root = s.pop();
					current = root.data;
					if(current < prev){
						return false;
					}
					prev = current;
					root = root.right;
				}
			}
		}
		return true;
		
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
		bt1.root = new Node(10);
        bt1.root.left = new Node(5);
        bt1.root.right = new Node(19);
        bt1.root.left.left = new Node(-5);
        bt1.root.left.right = new Node(6);
        bt1.root.right.left = new Node(125);
        bt1.root.right.right = new Node(21);
        
        System.out.println("Recursive Method: "+isBST(bt1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println("Iterative Method: "+isBSTIterative(bt1.root));
	}

}
