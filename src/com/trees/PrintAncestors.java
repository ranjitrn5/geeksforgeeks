package com.trees;

public class PrintAncestors {
	
	public static boolean traverse(Node src, int target){
		if(src == null){
			return false;
		}
		else{
			if(src.data == target){
				return true;
			}
			
			if(traverse(src.left, target) || traverse(src.right, target)){
				System.out.print(src.data+" ");
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
	       BinaryTree tree = new BinaryTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.left.left.left = new Node(7);
	        
	        System.out.println(traverse(tree.root, 7));

	}

}
