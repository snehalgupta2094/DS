package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeQuestions 
{
	public static void leftView(Node root)
	{
		System.out.println("--Left view---");
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		q.offer(null);		
		
		boolean levelChange=true;
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			if(levelChange)
			{
				System.out.print(tmp.data+" ");
				levelChange=false;
			}
			if(tmp!=null)
			{
			if(tmp.left!=null)
				q.offer(tmp.left);
			if(tmp.right!=null)
				q.offer(tmp.right);
			}
			else
			{
			   if(!q.isEmpty())
				   q.offer(null);
			   levelChange=true;
			}
		}
	}
	
	public static void rightView(Node root)
	{
		System.out.println();
		System.out.println("--Right view---");
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		q.offer(null);		
		
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			if(q.peek()==null && tmp!=null)
			{
				System.out.print(tmp.data+" ");
			}
			
			if(tmp!=null)
			{
			if(tmp.left!=null)
				q.offer(tmp.left);
				
			if(tmp.right!=null)
				q.offer(tmp.right);
			
			}
			else
			{
			   if(!q.isEmpty())
				   q.offer(null);
			}
		}	
	}
}
