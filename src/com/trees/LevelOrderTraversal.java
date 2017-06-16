/**
 * Level Order Traversal
 * Time Complexity: O(n)
 */

package com.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
		/*System.out.println("Size of Binary Tree: "+count);*/
	}
	/*
	 * Calculates maximum width using level order traversal
	 */
	public static int getMaxWidth(Node root){
		if(root == null){
			return 0;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int maxWidth = 0, count;
		while(!q.isEmpty()){
			count = q.size();
			maxWidth = Math.max(count, maxWidth);
			while(count > 0){
				root = q.remove();
				if(root.left != null){
					q.add(root.left);
				}
				if(root.right != null){
					q.add(root.right);
				}
				count--;
			}
		}
		return maxWidth;
	}
	/*
	 * Display the node data at a particular distance from root node
	 */
	public static void displayNodeAtKDistanceFromRoot(Node root, int k){
		if(root == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		int count=0,level=0;
		while(!q.isEmpty()){
			count = q.size();
			if(level == k){
				break;
			}
			level++;
			while(count > 0){
				root = q.poll();
				if(root.left != null){
					q.add(root.left);
				}
				if(root.right != null){
					q.add(root.right);
				}
				count--;
			}
		}
		System.out.println("Nodes at distance "+k+" from root:");
		while(!q.isEmpty()){
			System.out.print(q.poll().data+ " ");
		}
		System.out.println("");
	}
	
	public static int getNodeLevel(Node root, int key, int level){
		return getNodeLevelUtil(root, key, level++);
	}
	
	public static int getNodeLevelUtil(Node root, int key, int level){
		if(root == null){
			return 0;
		}
		if(root.data == key){
			return level+1;
		}
		
		int result = getNodeLevelUtil(root.left, key, level++);
		if(result != 0){
			return result;
		}
		
		result = getNodeLevelUtil(root.right, key, level++);
		return result;
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
		System.out.println("Maximum Width of binaryTree: "+getMaxWidth(bt.root));
		displayNodeAtKDistanceFromRoot(bt.root, 3);
		System.out.println("Level of Node: "+19+"is: "+getNodeLevel(bt.root, 23, 0));

	}

}
