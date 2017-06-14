package com.trees;

import java.util.Stack;

public class IterativeOrderTraversal {
	
	public static void iterativeInorderTraversal(Node root){
		if(root == null){
			return;
		}
		
		Stack<Node> s = new Stack<Node>();
		System.out.println("Inorder Traversal: ");
		while(true){
			if(root != null){
				s.push(root);
				root=root.left;
			}
			else{
				if(s.isEmpty()){
					break;
				}
				root = s.pop();
				System.out.print(root.data+" ");
				root = root.right;
			}
		}
		
	}
	
	public static void iterativePreOrderTraversal(Node root){
		if(root == null){
			return;
		}
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		System.out.println("");
		System.out.println("Iterative Pre order traversal: ");
		while(!s.isEmpty()){
			Node tempNode = s.pop();
			System.out.print(tempNode.data+" ");
			if(tempNode.right != null){
				s.push(tempNode.right);
			}
			if(tempNode.left != null){
				s.push(tempNode.left);
			}
		}
		
		System.out.println("");
		
	}
	
	public static void iterativePostOrderTraversal(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		Node tempNode;
		s1.push(root);
		while(!s1.isEmpty()){
			tempNode = s1.pop();
			s2.push(tempNode);
			if(tempNode.left != null){
				s1.push(tempNode.left);
			}
			if(tempNode.right != null){
				s1.push(tempNode.right);
			}
		}
		System.out.println("Iterative Post Order Traversal: ");
		while(!s2.isEmpty()){
			tempNode = s2.pop();
			System.out.print(tempNode.data+" ");
		}
		System.out.println("");
	}
	
	public static void optimizedPostOrderTraversal(Node root){
		if(root == null){
			return;
		}
		Node current = root;
		Stack<Node> s = new Stack<Node>();
		System.out.println("Optimized Post Order Traversal Result: ");
		while(current != null || !s.isEmpty()){
			if(current != null){
				s.push(current);
				current = current.left;
			}
			else{
				Node temp = s.peek().right;
				if(temp == null){
					temp = s.pop();
					System.out.print(temp.data+" ");
					while(!s.isEmpty() && temp == s.peek().right){
						temp=s.pop();
						System.out.print(temp.data+" ");
					}
				}
				else{
					current = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
/*		 	bt.addNode(10);
	        bt.addNode(15);
	        bt.addNode(19);
	        bt.addNode(17);
	        bt.addNode(11);
	        bt.addNode(-11);*/
		
        bt.root = new Node(1);
        bt.root.left = new Node(2);
	        
	        iterativeInorderTraversal(bt.root);
	        iterativePreOrderTraversal(bt.root);
	        iterativePostOrderTraversal(bt.root);
	        optimizedPostOrderTraversal(bt.root);
	}

}
