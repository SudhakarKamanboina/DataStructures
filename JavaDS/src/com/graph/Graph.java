package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
		
		public int count;
		private List<Node> vertices;
		
		public Graph()
		{
			count=0;
			vertices = new ArrayList<Node>();
		}
		
		public void addNode(Node newNode)
		{
			vertices.add(newNode);
			count++;
		}
		
		public List<Node> getNode()
		{
			return vertices;
		}
}
