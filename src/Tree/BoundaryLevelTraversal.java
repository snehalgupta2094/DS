package Tree;

import java.util.ArrayList;
class BTraversal{
    ArrayList<Integer> list=new ArrayList<>();
    public void leafTraversal(Node root){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            list.add(root.data);
        }
        leafTraversal(root.left);
        leafTraversal(root.right);
    }
    public void leftTraversal(Node root){
        if((root==null) || (root.right==null && root.left==null)){
            return;
        }
        list.add(root.data);
        if(root.left!=null)
            leftTraversal(root.left);
        else
            leftTraversal(root.right);
    }
    public void rightTraversal(Node root){
        if((root==null) || (root.left==null && root.right==null)){
            return;
        }
        list.add(root.data);
        if(root.right!=null)
            rightTraversal(root.right);
        else
            rightTraversal(root.left);
    }
    public void boundaryLevelTraversal(Node root){
        if(root==null)
            return;

        leftTraversal(root.left);
        leafTraversal(root);
        rightTraversal(root.right);
    }
}
public class BoundaryLevelTraversal {

    public static void main(String[] args) {
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
        BTraversal traversal=new BTraversal();
        traversal.boundaryLevelTraversal(t.root);
       ArrayList<Integer> list= traversal.list;
        System.out.println(list);
    }
}
