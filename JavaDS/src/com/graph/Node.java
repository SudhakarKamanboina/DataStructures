package com.graph;

import java.util.LinkedList;
import java.util.List;

public class Node {
	
	public List<Node> adj;
	public int adjCount;
	private String vertex;
	public State state;

	public Node(String vertex)
	{
		this.vertex=vertex;
		adjCount=0;
		adj= new LinkedList<Node>();
	}
	
	public String getVertex() {
		return vertex;
	}

	public void setVertex(String vertex) {
		this.vertex = vertex;
	}
	
	public void addChildNode(Node adj){
		adj.state = State.Unvisited;
		
		this.adj.add(adj);
		adjCount++;
	}

	public List<Node> getAdj()
	{
		return adj;
	}
	
}
