package com.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertLinkedList2BinaryTree {
	ListNode head;
	Node root;
	public class ListNode{
		ListNode next;
		int data;
		public ListNode(int data){
			next = null;
			this.data = data;
		}
	}
	
	public void addFirst(int data){
		ListNode node = new ListNode(data);
		node.next = head;
		head=node;
	}
	
	public Node convertToBinaryTree(ListNode node){
		if(head == null){
			node = null;
			return null;
		}
		Queue<Node> q = new LinkedList<Node>();
		root = new Node(head.data);
		head = head.next;
		q.add(root);
		while(head != null){
			Node leftChild=null, rightChild=null;
			Node parent = q.poll();
			leftChild = new Node(head.data);
			head = head.next;
			q.add(leftChild);
			if(head != null){
				rightChild = new Node(head.data);
				head=head.next;
				q.add(rightChild);
			}
			
			parent.left = leftChild;
			parent.right = rightChild;
		}
		return root;
		
	}
	
	public void inorderTraversal(Node root){
		if(root == null){
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}

	public static void main(String[] args) {
		ConvertLinkedList2BinaryTree test = new ConvertLinkedList2BinaryTree();
		test.addFirst(36);
		test.addFirst(30);
		test.addFirst(25);
		test.addFirst(15);
		test.addFirst(12);
		test.addFirst(10);
		test.addFirst(5);
		
		Node root = test.convertToBinaryTree(test.head);
		test.inorderTraversal(root);
		

	}

}
