package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalBinaryTrees {
	
	public static boolean checkBinaryTreeRecursive(Node root1, Node root2){
		if(root1 == null && root2 == null){
			return true;
		}
		if(root1 == null || root2 == null){
			return false;
		}
		
		return (root1.data == root2.data) && checkBinaryTreeRecursive(root1.left, root2.left) && checkBinaryTreeRecursive(root1.right, root2.right);
		
		
	}
	
	public boolean checkBinaryTreeIterative(Node root1, Node root2){
		if(root1 == null && root2 == null){
			return true;
		}
		
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Node> q2 = new LinkedList<Node>();
		
		q1.add(root1);
		q2.add(root2);
		
		while(!q1.isEmpty() && !q2.isEmpty()){
			Node n1 = q1.poll();
			Node n2 = q2.poll();
			
			if(n1.data != n2.data || (n1 == null || n2 == null)){
				return false;
			}
			
			q1.add(n1.left);
			q1.add(n2.left);
			q2.add(n1.right);
			q2.add(n2.right);
		}
		return true;
		
	}

	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree();
	 	bt1.addNode(10);
        bt1.addNode(12);
        bt1.addNode(13);
        bt1.addNode(14);
        bt1.addNode(15);
        bt1.addNode(16);
        
		BinaryTree bt2 = new BinaryTree();
		bt2.addNode(10);
        bt2.addNode(12);
        bt2.addNode(13);
        bt2.addNode(14);
        bt2.addNode(15);
        bt2.addNode(16);
        
        System.out.println("Recursive Method: "+checkBinaryTreeRecursive(bt1.root, bt2.root));
        System.out.println("Iterative Method: "+checkBinaryTreeRecursive(bt1.root, bt2.root));

	}

}
