package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class BottomViewOfBST 
{
	class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
	TreeNode root;
	class QueueEntry
	{
		TreeNode node;
		int distance;
		QueueEntry(TreeNode node, int distance)
		{
			this.node=node;
			this.distance=distance;
		}
	}
	public TreeNode createTree()
	{
		this.root=new TreeNode(1);
		TreeNode n1=new TreeNode(2);
		TreeNode n2=new TreeNode(3);
		TreeNode n3=new TreeNode(4);
		TreeNode n4=new TreeNode(5);
		TreeNode n5=new TreeNode(6);
		TreeNode n6=new TreeNode(7);
		TreeNode n7=new TreeNode(8);
		TreeNode n8=new TreeNode(9);
		TreeNode n9=new TreeNode(10);
		TreeNode n10=new TreeNode(11);
		
		root.left  = n1;
        root.right = n2;
         
        n1.left  = n3;
        n1.right = n4;
   
        n2.left  = n5;
        n2.right = n6;
         
        n3.right = n7;
         
        n4.left = n8;
         
        n5.right = n9;
         
        n6.right = n10;
		
        return root;
	}
	
	private void bottomUpView() 
	{
		Map<Integer,QueueEntry> map=new TreeMap<Integer, QueueEntry>();
		LinkedList<QueueEntry> queue=new LinkedList<QueueEntry>();
		queue.add(new QueueEntry(root, 0));
		
		while(!queue.isEmpty())
		{
			QueueEntry tmp=queue.remove();
			
			if(tmp.node!=null)
			{
				map.put(tmp.distance, tmp);
			if(tmp.node.left!=null)
			{
				queue.add(new QueueEntry(tmp.node.left, tmp.distance-1));
				
			}
		    if(tmp.node.right!=null)
		    {
		    	queue.add(new QueueEntry(tmp.node.right, tmp.distance+1));
		    }
			}
		}
		
		System.out.println();
		map.forEach((k,v)->System.out.print(v.node.data+" "));
		System.out.println("--trial--"+map.size());
	}
	
	public static void main(String[] args) 
	{
		BottomViewOfBST tree=new BottomViewOfBST();
		tree.createTree();
		tree.bottomUpView();
	}
}

