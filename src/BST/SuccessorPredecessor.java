package BST;

import java.util.HashSet;

import com.sun.source.tree.Tree;

public class SuccessorPredecessor {
    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
    }
    TreeNode root;
    public void findSuccessorPredecessor(TreeNode root,int key){

      TreeNode temp=root;
      int predecessor=0;
      int successor=0;
      while(temp.data!=key){
          if(temp.data>key){
              temp=temp.left;
              predecessor=temp.data;
          }
         else{
              temp=temp.right;
              successor=temp.data;
          }
      }

      TreeNode leftTree=temp.left;
      TreeNode rightTree=temp.right;

      while(leftTree!=null){
          predecessor=leftTree.data;
          leftTree=leftTree.left;
      }
        while(rightTree!=null){
            successor=rightTree.data;
            rightTree=leftTree.right;
        }
        System.out.println(successor);
        System.out.println(predecessor);
    }
}
