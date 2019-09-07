package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 *  1
 *  |
 *  2----5
 *  |    |
 *  3----6----8
 *  |    |
 *  4    7
 */

//Adjacency List
class Node
{
	int data;
	boolean visited;
	LinkedList<Node> list=new LinkedList<>();
	Node(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public void addNode(Node node)
	{
		this.list.add(node);
	}
	public LinkedList<Node> getList() {
		return list;
	}
	public void setList(LinkedList<Node> list) {
		this.list = list;
	}
}

public class BFS 
{
	public static void main(String[] args) 
	{
		Node v1=new Node(1);
		Node v2=new Node(2);
		Node v3=new Node(3);
		Node v4=new Node(4);
		Node v5=new Node(5);
		Node v6=new Node(6);
		Node v7=new Node(7);
		Node v8=new Node(8);
		v1.addNode(v2);
		v2.addNode(v3);
		v2.addNode(v5);
		v2.addNode(v1);
		v3.addNode(v4);
		v3.addNode(v6);
		v3.addNode(v2);
		v6.addNode(v7);
		v6.addNode(v8);
		v6.addNode(v3);
		v6.addNode(v5);
		v5.addNode(v2);
		v5.addNode(v6);
		v7.addNode(v6);
		v8.addNode(v6);
		v4.addNode(v3);
		System.out.println();
		bfsList(v1);
		
	}
	
	public static void bfsList(Node node)
	{
	  Queue<Node> queue=new LinkedList<>();
	  queue.add(node);
	  node.setVisited(true);
	  while(!queue.isEmpty())
	  {
		  Node n1=queue.poll();
		  System.out.print(n1.data+" ");
		  LinkedList<Node> list=n1.getList();
		  for(Node n: list)
		  {
			  if(!n.isVisited())
			  {
				  queue.add(n);
				  n.setVisited(true);
			  }
		  }
	  }
	}
	
}
