package Heap;


import com.sun.source.tree.Tree;

import Tree.BottomViewOfBST;

public class IsBinaryTreeHeap {
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
    public TreeNode createTree()
    {
        this.root=new TreeNode(7);
        TreeNode n1=new TreeNode(6);
        TreeNode n2=new TreeNode(5);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(3);
        //TreeNode n4=new TreeNode(9);
        TreeNode n5=new TreeNode(2);
        TreeNode n6=new TreeNode(1);

        root.left  = n1;
        root.right = n2;

        n1.left  = n3;
        n1.right = n4;

        n2.left  = n5;
        n2.right = n6;

        return root;
    }

    public boolean solve(TreeNode root){
        //base condition
        if(root==null)
            return true;

        int nodeCount=countNodes(root);
        int index=0;
        if(isCBT(root,index,nodeCount) && isMaxOrder(root)){
            return true;
        }
        return false;
    }

    private boolean isMaxOrder(TreeNode root){
        //base condition
        if(root.left==null && root.right==null)
            return true;
        //If this the parent of a leaf node w/o right child
        if(root.right==null){
            return root.data>root.left.data;
        }
        else
        {
            boolean left=isMaxOrder(root.left);
            boolean right=isMaxOrder(root.right);
            return left && right && root.data>root.left.data && root.data>root.right.data;
        }
    }
    private boolean isCBT(TreeNode root, int index, int count) {
      //base condition
        if(root==null)
            return true;

        //This means there is right node to a parent w/o left node
        if(index>count)
            return false;
        else{
            boolean left=isCBT(root.left,2*index+1,count);
            boolean right=isCBT(root.right,2*index+2,count);
            return left && right;
        }
    }

    private int countNodes(TreeNode root) {
        //base condition
        if(root==null)
            return 1;

        return countNodes(root.left)+countNodes(root.right)+1;
    }

    public static void main(String[] args) {
    IsBinaryTreeHeap bst=new IsBinaryTreeHeap();
    TreeNode root=bst.createTree();
        System.out.println(bst.solve(root));
    }
}
