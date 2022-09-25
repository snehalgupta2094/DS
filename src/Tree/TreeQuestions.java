package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeQuestions 
{
	public static void left(Node root, int level, List<Integer> ans){

		if(root==null)
			return;

		if(level==ans.size()){
			ans.add(root.data);
		}
		left(root.left,level+1,ans);
		left(root.right,level+1,ans);

	}

	public static void leftView(Node root)
	{
		System.out.println("--left view--");
		ArrayList<Integer> ans =new ArrayList<>();
		left(root,0,ans);
		System.out.println(ans);
	}
	public static void right(Node root, int level, List<Integer> ans){

		if(root==null)
			return;

		if(level==ans.size()){
			ans.add(root.data);
		}
		right(root.right,level+1,ans);
		right(root.left,level+1,ans);
	}

	public static void rightView(Node root)
	{
		System.out.println("--Right view--");
		ArrayList<Integer> ans =new ArrayList<>();
		right(root,0,ans);
		System.out.println(ans);
	}
}
