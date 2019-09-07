package Tree;

import java.util.ArrayList;

class Node
{
	int data;
	Node left;
	Node right;

	Node(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
}
class BST{
	Node root;
	BST()
	{
		root=null;
	}
	public void insert(int data)
	{
		Node node=new Node(data);
		if(root==null)
		{
			root=node;
		}
		else 
		{
			Node current=root;
			while(true)
			{
			if(current.data<data)
			{
				if(current.right==null)
				{
					current.right=node;
					break;
				}
				current=current.right;
			}
			else
			{
				if(current.left==null)
				{
					current.left=node;
					break;
				}
				current=current.left;
			}
			}
		}
	}

}
public class BinaryTreeImplementation 
{
	public static void main(String[] args) 
	{
		BST t=new BST();

		//Create a binary tree	
		//tree1
		t.insert(7);
		t.insert(3);
		t.insert(9);
		t.insert(2);
		t.insert(4);
		t.insert(6);
		t.insert(11);
		//t.insert(13);
		
		//tree2
		/*t.insert(20);
		t.insert(8);
		t.insert(22);
		t.insert(5);
		t.insert(13);
		t.insert(25);
		t.insert(10);
		t.insert(14);*/
		
		//tree3
		/*t.insert(10);
		t.insert(2);
		t.insert(12);
		t.insert(4);
		t.insert(5);
		t.insert(6);*/
		
		
		//Tree traversals
		System.out.println("--In order--");
		Traversals.inorder(t.root);
		System.out.println("--Pre order--");
		Traversals.preorder(t.root);
		System.out.println("--Post order--");
		Traversals.postorder(t.root);
		System.out.println("--Zigzag order--");
		Traversals.zigzagorder(t.root);
		System.out.println("--Level order--");
		Traversals.levelorder(t.root);
		
		System.out.println("--In order recursive--");
		ArrayList<Integer> res=new ArrayList<Integer>();
		res=Traversals.recursiveInorder(t.root,res);
		Traversals.printResult(res);
		System.out.println("--Pre order recursive--");
		res=new ArrayList<Integer>();
		res=Traversals.recursivePreorder(t.root,res);
		Traversals.printResult(res);
		System.out.println("--Post order recursive--");
		res=new ArrayList<Integer>();
		res=Traversals.recursivePostorder(t.root,res);
		Traversals.printResult(res);
		
		//Height of tree
		int height=HeightOfTree.heightOfTree(t.root);
		System.out.println("--height="+height);
		height=HeightOfTree.heightOfTreeRecursive(t.root);
		System.out.println("--height recursive="+height);
		
		//Mirror of tree

		//Views
		TreeQuestions.leftView(t.root);
		TreeQuestions.rightView(t.root);
	}
}
