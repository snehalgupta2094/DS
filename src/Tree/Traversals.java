package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversals {
	
	//Postorder-LRP		
	public static ArrayList<Integer> recursivePostorder(Node root,ArrayList<Integer> res)
	{
		if(root.left!=null)
		recursivePostorder(root.left, res);
		if(root.right!=null)
		recursivePostorder(root.right, res);
		res.add(root.data);
		return res;
	}
	
	//Preorder-PLR
	public static ArrayList<Integer> recursivePreorder(Node root,ArrayList<Integer> res)
	{	
		res.add(root.data);
		if(root.left!=null)
		recursivePreorder(root.left,res);
		if(root.right!=null)
		recursivePreorder(root.right,res);
		return res;
	}
	
	//Inorder-LPR
	public static ArrayList<Integer> recursiveInorder(Node root,ArrayList<Integer> res)
	{
		if(root.left!=null)
		recursiveInorder(root.left,res);
		res.add(root.data);
		if(root.right!=null)
		recursiveInorder(root.right,res);
		return res;
	}
	
	//In-order-LPR
	public static void inorder(Node root)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		Stack<Node> stack=new Stack<Node>();
		Node temp=root;
		boolean done=false;
		while(!done)
		{
			if(temp!=null)
			{
				stack.push(temp);
				temp=temp.left;
			}
			else
			{
				if(stack.isEmpty())
					done=true;
				else
				{
					temp=stack.pop();	
					result.add(temp.data);
					temp=temp.right;
				}
			}	
		}
		printResult(result);
	}
	
	//Postorder-LRP
	public static void postorder(Node root) {
		ArrayList<Integer> result=new ArrayList<Integer>();
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		Node prev=null;
		while(!s.empty())
		{
			Node curr=s.peek();
			if(prev==null || prev.right==curr || prev.left==curr)
			{
				if(curr.left!=null)
				{
					s.push(curr.left);
				}
				else if(curr.right!=null)
				{
					s.push(curr.right);
				}
			}
			else if(curr.left==prev)	 
			{
				//control reaches here after the leftmost child is visited
				if(curr.right!=null)
					s.push(curr.right);
			}
			else
			{
				result.add(curr.data);
				s.pop();
			}
			prev=curr;
		}
		printResult(result);
	}
	
	//Preorder-PLR
	public static void preorder(Node root){
		ArrayList<Integer> res=new ArrayList<Integer>();
		Stack<Node> s=new Stack<Node>();
		s.push(root);
		while(!s.isEmpty())
		{
			Node tmp=s.pop();
			res.add(tmp.data);

			if(tmp.right!=null)
				s.push(tmp.right);
			if(tmp.left!=null)
				s.push(tmp.left);
		}
		printResult(res);
	}

	//Level order-7 3 9 2 4 11 6
	public static void levelorder(Node root) {
		ArrayList<Integer> res=new ArrayList<Integer>();
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		
		//Marker to mark end of level
		q.offer(null);

		while(!q.isEmpty())
		{
			//FIFO-Removes the element which was first inserted in queue
			Node temp=q.poll();
			if(temp!=null)
			{
				res.add(temp.data);
				if(temp.left!=null)
					q.offer(temp.left);
				if(temp.right!=null)
					q.offer(temp.right);
			}
			else
			{
				/***
				 * Marks end of level- 
				 * Control comes in this flow when we reach 
				 * a null in queue.At this point 
				 * previous null is removed by poll 
				 * and new null is added at the end of queue
				 ***/
				if(!q.isEmpty())
					q.offer(null);
			}
		}
		printResult(res);
	}
	
	//7 9 3 2 4 11 6
	public static void zigzagorder(Node root) {
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		ArrayList<Integer> result=new ArrayList<Integer>();
		boolean leftToRight=true;
		
		Stack<Integer> s=new Stack<Integer>();
		
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			if(tmp!=null)
			{
				if(leftToRight)
					result.add(tmp.data);
				else
					s.push(tmp.data);
			
				if(tmp.left!=null)
					q.offer(tmp.left);
				if(tmp.right!=null)
					q.offer(tmp.right);
			}
			else
			{
				if(!q.isEmpty())
					q.offer(null);
				if(leftToRight)
					leftToRight=false;
				else
				{
					while(s.size()>0)
						result.add(s.pop());

					s=new Stack<Integer>();
					leftToRight=true;
				}
			}
		}
		printResult(result);
	}

	public static void printResult(ArrayList<Integer> result)
	{
		System.out.println(result);
	}
}
