package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckSymmetricTrees {
	
	public static boolean isSymmetricRecursive(Node root1, Node root2){
		if(root1 == null && root2 == null){
			return true;
		}
		
		if(root1 == null || root2 == null){
			return false;
		}
		
		return (root1.data == root2.data && isSymmetricRecursive(root1.left, root2.right)
				&& isSymmetricRecursive(root1.right, root2.left));
	}
	
	public static boolean isSymmetricIterative(Node root1, Node root2){
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
			
			if(n1 == null && n2 == null){
				continue;
			}
			
			if((n1 == null || n2 == null) || (n1.data != n2.data)){
				return false;
			}
			
			q1.add(n1.left);
			q1.add(n1.right);
			
			q2.add(n2.right);
			q2.add(n2.left);
		}
		return true;
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.root = new Node(3);
        bt.root.left = new Node(1);
        bt.root.left.left = new Node(0);
        bt.root.left.right = new Node(2);
        bt.root.left.left.left = new Node(3);
        bt.root.left.right.right = new Node(4);
        
        bt.root.right = new Node(1);
        bt.root.right.left = new Node(2);
        bt.root.right.right = new Node(0);
        bt.root.right.left.left = new Node(4);
        bt.root.right.right.right = new Node(3);
        
        System.out.println("Recursive Version: "+isSymmetricRecursive(bt.root, bt.root));
        System.out.println("Iterative Version: "+isSymmetricIterative(bt.root, bt.root));

	}

}
