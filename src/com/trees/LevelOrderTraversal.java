/**
 * Level Order Traversal
 * Time Complexity: O(n)
 */

package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public static void levelOrderTraversal(Node root){
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<Node>();
		Node tempNode = root;
		System.out.println("Level Order Traversal: ");
		int count = 1;
		while(tempNode != null){
			System.out.print(tempNode.data+" ");
			if(tempNode.left != null){
				queue.add(tempNode.left);
				count++;
			}
			if(tempNode.right != null){
				queue.add(tempNode.right);
				count++;
			}
			
			tempNode = queue.poll();
		}
		
		System.out.println("");
		System.out.println("Size of Binary Tree: "+count);
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		
		bt.addNode(10);
		bt.addNode(15);
		bt.addNode(5);
		bt.addNode(7);
		bt.addNode(19);
		bt.addNode(20);
		bt.addNode(-1);
		
		levelOrderTraversal(bt.root);
		

	}

}
