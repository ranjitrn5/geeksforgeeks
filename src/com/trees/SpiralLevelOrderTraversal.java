package com.trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class SpiralLevelOrderTraversal {
	
	public static void spiralLevelOrderTraversal(Node root){
		if(root == null){
			return;
		}
		Stack<Node> stackEven = new Stack<Node>();
		Stack<Node> stackOdd = new Stack<Node>();
		
		stackEven.push(root);
		System.out.println("Using 2 Stacks:");
		while(!stackEven.isEmpty() || !stackOdd.isEmpty()){
			while(!stackEven.isEmpty()){
				root = stackEven.pop();
				System.out.print(root.data+" ");
				if(root.left != null){
					stackOdd.push(root.left);
				}
				if(root.right != null){
					stackOdd.push(root.right);
				}
			}
			
			while(!stackOdd.isEmpty()){
				root = stackOdd.pop();
				System.out.print(root.data+" ");
				if(root.right != null){
					stackEven.push(root.right);
				}
				if(root.left != null){
					stackEven.push(root.left);
				}
			}
		}
		System.out.println("");
	}
	
	public static void sprialOrderTraversalWithDeque(Node root){
		if(root == null){
			return;
		}
		
		Deque<Node> deque = new LinkedList<>();
		deque.offer(null);
		deque.offerFirst(root);
		System.out.println("Using deque with delimiter:");
		while(deque.size() > 1){
			root = deque.peekFirst();
			while(root != null){
				root = deque.pollFirst();
				System.out.print(root.data+" ");
				if(root.left != null){
					deque.offerLast(root.left);
				}
				if(root.right != null){
					deque.offerLast(root.right);
				}
				root = deque.peekFirst();
			}
			
			root = deque.peekLast();
			while(root != null){
				root = deque.pollLast();
				System.out.print(root.data+" ");
				if(root.right != null){
					deque.offerFirst(root.right);
				}
				if(root.left != null){
					deque.offerFirst(root.left);
				}
				root = deque.peekLast();
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.addNode(10);
		bt.addNode(30);
		bt.addNode(25);
		bt.addNode(35);
		bt.addNode(-10);
		bt.addNode(0);
		bt.addNode(-20);
		bt.addNode(-15);
		bt.addNode(45);
		
		spiralLevelOrderTraversal(bt.root);
		sprialOrderTraversalWithDeque(bt.root);

	}

}
