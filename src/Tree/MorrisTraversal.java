package Tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
        }
    }
    public TreeNode findPredecessor(TreeNode current){
        TreeNode predecessor=current.left;
        while(predecessor.right!=null && predecessor.right!=current)
        {
            predecessor=predecessor.right;
        }
        return predecessor;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        TreeNode current=root;
        ArrayList<Integer> result=new ArrayList<Integer>();
        while(current!=null){
            if(current.left==null){
                result.add(current.val);
                current=current.right;
            }
            else{
                TreeNode predecessor=findPredecessor(current);
                if(predecessor.right==null){
                    predecessor.right=current;
                    current=current.left;
                }
                else{
                    predecessor.right=null;
                    result.add(current.val);
                    current=current.right;
                }
            }
        }
        return result;
    }
}