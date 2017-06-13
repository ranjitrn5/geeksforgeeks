package com.graphproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graph {
	
	private int vertices;
	private LinkedList<Integer> adjList[];
	private boolean isDirected;
	public Graph(int v, boolean isDirected){
		this.vertices = v;
		this.isDirected = isDirected;
		adjList = new LinkedList[vertices];
		for(int i=0;i<vertices;i++){
			adjList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v, int w){
		if(!isDirected){
			adjList[v].add(w);
			adjList[w].add(v);
		}
		else{
			adjList[v].add(w);
		}
	}
	
	public List<Integer> getAdjacencyList(int vertex){
		return adjList[vertex];
	}
	
	public Set<Integer> getAllVertices(){
		Set<Integer> resultList = new HashSet<>();
		for(LinkedList i: adjList){
			Iterator<Integer> it=i.listIterator();
			while(it.hasNext()){
				int n = it.next();
				if(!resultList.contains(n)){
					resultList.add(n);
				}
			}
		}
		return resultList;
	}
	
	

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public LinkedList<Integer>[] getAdjList() {
		return adjList;
	}

	public void setAdjList(LinkedList<Integer>[] adjList) {
		this.adjList = adjList;
	}
	
	public void displayVertices(Set<Integer> resultSet){
		System.out.println("Vertices: ");
		for(Integer i: resultSet){
			System.out.print(i+",");
		}
		System.out.println("");
	}

	@Override
	public String toString() {
		String result = "";
		for(int i=0;i<adjList.length;i++){
			result += i+"-->";
			Iterator<Integer> it = adjList[i].listIterator();
			while(it.hasNext()){
				result+="{"+it.next()+"}";
			}
			result+="\n";
		}
		
		return result;
	}

	public static void main(String[] args) {
        Graph g1 = new Graph(6, false);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.addEdge(4, 5);
        g1.addEdge(5, 1);
        
        System.out.println(g1);
        g1.displayVertices(g1.getAllVertices());

	}

}
