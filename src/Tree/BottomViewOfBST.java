package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;



public class BottomViewOfBST {

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
	class Pair<K,V>{
		K first;
		V second;
		Pair(K first, V second){
			this.first=first;
			this.second=second;
		}
	}
	public void bottomView()
	{
		TreeMap<Integer,Integer> map=new TreeMap<>();
		Queue<Pair<TNode,Integer>> queue=new ArrayDeque<>();
		queue.offer(new Pair<>(root,0));

		while (!queue.isEmpty()){
			Pair<TNode,Integer> p=queue.poll();
			TNode frontNode=p.first;
			int hd=p.second;
			map.put(hd,frontNode.data);

			if(frontNode.left!=null)
				queue.offer(new Pair<>(frontNode.left,hd-1));
			if(frontNode.right!=null)
				queue.offer(new Pair<>(frontNode.right,hd+1));
		}
		ArrayList<Integer> ans=new ArrayList<>();
		for(int val:map.values()){
			ans.add(val);
		}
		System.out.println(ans);
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

		n3.left = n7;
		n3.right = n8;

		n4.left = n9;
		n4.right = n10;

		return root;
	}

	public static void main(String[] args) {
		BottomViewOfBST tree=new BottomViewOfBST();
		tree.create();
		tree.bottomView();
	}

}
