package com.graphproblems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearchAlgorithms {
	
	private int V;
	private LinkedList<Integer> adj[];
	
	public GraphSearchAlgorithms(int v){
		this.V = v;
		this.adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
	
	public void bfs(int s){
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()){
			s = q.poll();
			System.out.print(s+" ");
			Iterator<Integer> it = adj[s].listIterator();
			while(it.hasNext()){
				int n = it.next();
				if(!visited[n]){
					visited[n]=true;
					q.add(n);
				}
			}
		}
		System.out.println("");
	}
	
	public void dfs(int s){
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(s);
		visited[s]=true;
		while(!stack.isEmpty()){
			s = stack.pop();
			System.out.print(s+" ");
			Iterator<Integer> it = adj[s].listIterator();
			while(it.hasNext()){
				int n = it.next();
				if(!visited[n]){
					visited[n]=true;
					stack.push(n);
				}
			}
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		GraphSearchAlgorithms graph = new GraphSearchAlgorithms(4);
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		
		System.out.println("Breadth first Traversal: ");
		graph.bfs(0);

		System.out.println("Depth First Traversal: ");
		graph.dfs(0);
	}

}
