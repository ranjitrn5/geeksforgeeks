package com.trees;

import java.util.Queue;

import java.util.LinkedList;

import java.util.Stack;

public class ReverseLevelOrderTraversal {
	
	public static void reverseLevelOrderTraversal(Node root){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node temp = q.peek();
			q.remove();
			s.push(temp);
			if(temp.right != null){
				q.add(temp.right);
			}
			if(temp.left != null){
				q.add(temp.left);
			}
		}
		System.out.println("Reverse Level Order Traversal: ");
		while(!s.isEmpty()){
			System.out.print(s.pop().data+" ");
		}
		
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
	 	bt.addNode(10);
        bt.addNode(15);
        bt.addNode(19);
        bt.addNode(17);
        bt.addNode(11);
        bt.addNode(-11);
        
        reverseLevelOrderTraversal(bt.root);

	}

}
