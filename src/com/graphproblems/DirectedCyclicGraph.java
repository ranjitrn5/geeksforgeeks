package com.graphproblems;

import java.util.HashSet;
import java.util.Set;

import com.graphproblems.utils.GenericGraph;
import com.graphproblems.utils.Vertex;

public class DirectedCyclicGraph {
	
	public boolean isCyclic(GenericGraph<Integer> graph){
		Set<Vertex<Integer>> whiteSet = new HashSet<>();
		Set<Vertex<Integer>> graySet = new HashSet<>();
		Set<Vertex<Integer>> blackSet = new HashSet<>();
		
		for(Vertex<Integer> v: graph.getAllVertex()){
			whiteSet.add(v);
		}
		
		while(whiteSet.size() > 0){
			Vertex<Integer> current = whiteSet.iterator().next();
			if(isCyclicUtil(current, whiteSet, graySet, blackSet)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicUtil(Vertex<Integer> current, Set<Vertex<Integer>> whiteSet,
			Set<Vertex<Integer>> graySet, Set<Vertex<Integer>> blackSet){
		moveVertex(current, whiteSet, graySet);
		
		for(Vertex<Integer> neighbour: current.getAdjacentVertexes()){
			if(blackSet.contains(neighbour)){
				continue;
			}
			else
				if(graySet.contains(neighbour)){
					return true;
				}
				else{
					if(isCyclicUtil(neighbour, whiteSet, graySet, blackSet)){
						return true;
					}
				}
		}
		moveVertex(current, graySet, blackSet);
		return false;
	}
	
	private void moveVertex(Vertex<Integer> current, Set<Vertex<Integer>> source,Set<Vertex<Integer>> dest){
		source.remove(current);
		dest.add(current);
	}

	public static void main(String[] args) {
        GenericGraph<Integer> graph = new GenericGraph<>(true);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 4);
        
        DirectedCyclicGraph dcg = new DirectedCyclicGraph();
        System.out.println(dcg.isCyclic(graph));

	}

}
