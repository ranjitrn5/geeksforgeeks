package com.trees;

public class BoundaryTraversalTree {
	
	private static void printLeftBoundary(Node root){
		if( root != null){
			if(root.left != null){
				System.out.print(root.data+" ");
				printLeftBoundary(root.left);
			}
			else if(root.right != null){
					System.out.print(root.data+" ");
					printLeftBoundary(root.right);
				}
		}
	}
	
	private static void printLeaves(Node root){
		if(root != null){
			printLeaves(root.left);
			if(root.left == null && root.right == null){
				System.out.print(root.data+" ");
			}
			printLeaves(root.right);
		}
	}
	
	private static void printRightBoundary(Node root){
		if(root != null){
			if(root.right != null){
				printRightBoundary(root.right);
				System.out.print(root.data+" ");
			}
			else if(root.left != null){
					printRightBoundary(root.left);
					System.out.print(root.data+" ");
				}
		}
	}
	
	public static void displayBoundaryTraversal(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		printLeftBoundary(root.left);
		printLeaves(root.left);
		printLeaves(root.right);
		printRightBoundary(root.right);
		
	}

	public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.left.left = new Node(5);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        displayBoundaryTraversal(tree.root);

	}

}
