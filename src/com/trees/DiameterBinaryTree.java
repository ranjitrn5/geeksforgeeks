/**
 * Calculate Diameter of a given Binary Tree
 */

package com.trees;

public class DiameterBinaryTree {
	
	/**
	 * 
	 * @param root: Root of Binary Tree
	 * @return: returns the diameter of binary tree
	 * Time Complexity: O(n^2)
	 */
	
	public static int calculateDiameter(Node root){
		if(root == null){
			return 0;
		}
		
		int lheight = calculateHeight(root.left);
		int rheight = calculateHeight(root.right);
		
		int ldiameter = calculateDiameter(root.left);
		int rdiameter = calculateDiameter(root.right);
		
		return Math.max(lheight+rheight+1, Math.max(ldiameter, rdiameter));
	}
	
	public static int calculateHeight(Node root){
		if(root == null){
			return 0;
		}
		
		return 1+Math.max(calculateHeight(root.left), calculateHeight(root.right));
	}
	
	/**
	 * 
	 * @param root: Root of Binary Tree
	 * @param height: Current height of current root node
	 * @return: returns the diameter of binary tree
	 * Time Complexity: O(n)
	 */
	
	public static int calculateDiameterOpt(Node root, Height height){
		if(root == null){
			height.h=0;
			return 0;
		}
		Height lh = new Height();
		Height rh = new Height();
		
		lh.h++;
		rh.h++;
		
		int ldiameter = calculateDiameterOpt(root.left, lh);
		int rdiameter = calculateDiameterOpt(root.right, rh);
		
		height.h = Math.max(lh.h, rh.h)+1;
		
		return Math.max(lh.h+rh.h+1, Math.max(ldiameter, rdiameter));
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
		
		System.out.println("Diameter of Binary Tree: "+calculateDiameter(bt.root));
		System.out.println("Diameter of Binary Tree: "+calculateDiameterOpt(bt.root, new Height()));

	}

}
