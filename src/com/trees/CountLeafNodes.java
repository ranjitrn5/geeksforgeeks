package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CountLeafNodes {
	
	public static int countLeafNodes(Node root){
		int count = 0;
		if(root == null){
			return 0;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		while(!q.isEmpty()){
			root = q.poll();
			if(root.left == null && root.right == null){
				count++;
			}
			if(root.left != null){
				q.add(root.left);
			}
			if(root.right != null){
				q.add(root.right);
			}
		}
		return count;
	}

	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Leaf Node count ="+countLeafNodes(tree.root));
	}

}
