package Tree;

import java.nio.channels.Pipe;

class Pair{
     boolean isSumTree;
     int sum;
     Pair(boolean isSumTree,int sum){
      this.isSumTree=false;
      this.sum=sum;
     }
 }
public class CheckIfSumTree {
public Pair isSumTree(Node root){
    if(root==null)
        return new Pair(true,0);

    if(root.right==null && root.left==null){
        return new Pair(true,root.data);
    }

    Pair left=isSumTree(root.left);
    Pair right=isSumTree(root.right);

    boolean isSumValid=root.data==left.sum+ right.sum;

    if(left.isSumTree && right.isSumTree && isSumValid)
    {
        Pair p=new Pair(true,root.data+ left.sum+ right.sum);
        return p;
    }

    return new Pair(false,0);
}
}
