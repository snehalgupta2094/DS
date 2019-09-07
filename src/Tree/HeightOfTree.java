package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {
	//Recursive
	public static int heightOfTreeRecursive(Node root)
	{
		if(root==null)
			return 0;
		int right=heightOfTreeRecursive(root.right);
		int left=heightOfTreeRecursive(root.left);
		return Math.max(right, left)+1;	
	}

	//With level order traversal
	public static int heightOfTree(Node root)
	{
		int height=1;
		Queue<Node> q=new LinkedList<Node>();
		q.offer(root);
		q.offer(null);
		
		while(!q.isEmpty())
		{
			Node tmp=q.poll();
			
			if(tmp!=null)
			{
				if(tmp.left!=null)
					tmp=tmp.left;
				if(tmp.right!=null)
					tmp=tmp.right;
			}
			else
			{
				if(!q.isEmpty())
					q.offer(null);
				height++;
			}
			
		}
		
		return height;
	}
}
