package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;



public class TopViewOfBST {

	class TNode
	{
		TNode left;
		TNode right;
		int data;
		TNode(int data)
		{
			this.data=data;
		}
	}
	TNode root;
	class QEntry
	{
		int distance;
		TNode node;
		QEntry(TNode node, int distance)
		{
			this.distance=distance;
			this.node=node;
		}
	}
	
	public void topView()
	{
		LinkedList<QEntry> queue=new LinkedList<QEntry>();
		queue.add(new QEntry(root, 0));
		
		Map<Integer,QEntry> map=new TreeMap<Integer,QEntry>();
		while(!queue.isEmpty())
		{
			QEntry tmp=queue.remove();
			if(tmp.node!=null)
			{
				if(!map.containsKey(tmp.distance))
					map.put(tmp.distance, tmp);
				if(tmp.node.left!=null)
					queue.add(new QEntry(tmp.node.left, tmp.distance-1));
				if(tmp.node.right!=null)
					queue.add(new QEntry(tmp.node.right,tmp.distance+1));
			}
		}
		System.out.println("---Top view---");
		map.forEach((k,v)->System.out.print(v.node.data+" "));
	}
	
	public TNode create()
	{
		this.root=new TNode(1);
		TNode n1=new TNode(2);
		TNode n2=new TNode(3);
		TNode n3=new TNode(4);
		TNode n4=new TNode(5);
		TNode n5=new TNode(6);
		TNode n6=new TNode(7);
		TNode n7=new TNode(8);
		TNode n8=new TNode(9);
		TNode n9=new TNode(10);
		TNode n10=new TNode(11);
		
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
	
	public static void main(String[] args) {
	TopViewOfBST tree=new TopViewOfBST();
	tree.create();
	tree.topView();
	}
	
}
