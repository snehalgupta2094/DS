package Tree;

import javax.swing.tree.TreeNode;

public class MaxSumRootToLeaf {
    public void sumPath(Node root, int len, int maxLen, int sum, int maxSum){
        if(root==null){
            if(len>maxLen){
                maxLen=len;
                maxSum=sum;
            }
            else if(len==maxLen){
                maxSum=Math.max(maxSum,sum);
            }
            return;
        }
        sum=sum+root.data;
        sumPath(root.left,len+1,maxLen,sum,maxSum);
        sumPath(root.right,len+1,maxLen,sum,maxSum);

    }
    public int maxPathSum(Node root) {
        int maxSum=Integer.MIN_VALUE;
        sumPath(root,0,0,0,maxSum);
        return maxSum;
    }
}
