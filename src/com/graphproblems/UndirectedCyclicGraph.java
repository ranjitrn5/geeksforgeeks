package com.graphproblems;

import java.util.Iterator;

public class UndirectedCyclicGraph {
	
	public boolean isCyclic(Graph g){
		int n = g.getVertices();
		boolean[] visited = new boolean[n];
		for(int i=0;i<n;i++)
			visited[i]=false;
		
		for(Integer u: g.getAllVertices()){
			if(!visited[u])
				if(isCyclicUtil(u,visited,-1,g)){
					return true;
				}
		}
		return false;
	}
	
	private boolean isCyclicUtil(int v, boolean[] visited, int parent, Graph g){
		visited[v]=true;
		Iterator<Integer> it = g.getAdjacencyList(v).listIterator();
		while(it.hasNext()){
			int n = it.next();
			if(!visited[n]){
				if(isCyclicUtil(n, visited, v, g)){
					return true;
				}
			}
			else
				if(n!=parent){
					return true;
				}
		}
		return false;
		
	}

	public static void main(String[] args) {
		Graph g = new Graph(6, false);
		
		g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        //g.addEdge(5, 1);
        
        UndirectedCyclicGraph unDirectedGraph = new UndirectedCyclicGraph();
        
        if(unDirectedGraph.isCyclic(g)){
        	System.out.println("Cycle Detected");
        }
        else{
        	System.out.println("No cycle detected");
        }

	}

}
