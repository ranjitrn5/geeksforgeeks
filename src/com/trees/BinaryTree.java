package com.trees;

class Node{
	Node left;
	Node right;
	int data;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class Height{
	int h;
}

public class BinaryTree {
	Node root;
	
		
	public void addNode(int data){
		Node newNode = new Node(data);
		if(root == null){
			root = newNode;
			return;
		}
		Node current = root;
		Node previous = null;
		while(true){
			previous = current;
			if(newNode.data < current.data){
				current = current.left;
				if(current == null){
					previous.left=newNode;
					return;
				}
			}
			else{
				current = current.right;
				if(current == null){
					previous.right = newNode;
					return;
				}
			}
		}
	}

}
