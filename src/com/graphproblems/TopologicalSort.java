package com.graphproblems;

import java.util.Iterator;

import java.util.Stack;

import java.util.LinkedList;

public class TopologicalSort {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public TopologicalSort(int v){
		this.V = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public Stack<Integer> topSort(){
		
		Stack stack = new Stack();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		
		for(int i=0;i<V;i++){
			if(!visited[i]){
				topSortUtil(i,stack, visited);
			}
		}
		
		return stack;
	}
	
	public void topSortUtil(int v, Stack s, boolean[] visited){
		visited[v]=true;
		
		Iterator<Integer> it = adj[v].listIterator();
		
		while(it.hasNext()){
			int n = it.next();
			if(!visited[n]){
				topSortUtil(n, s, visited);
			}
		}
		s.push(new Integer(v));
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}

	public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
		
		Stack<Integer> result = g.topSort();
		System.out.println("Topological Sort is: ");
		while(!result.isEmpty()){
			System.out.print(result.pop()+" ");
		}

	}

}
