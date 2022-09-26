package Tree;
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
    }
}
class TreeAncestor {
    public TreeNode getAncestor(TreeNode root,int node, int k){
        if(root==null)
            return null;
        if(root.data==node){
            return root;
        }
        TreeNode left=getAncestor(root.left,node,k);
        TreeNode right=getAncestor(root.right,node,k);

        if(left!=null && right==null){
            k--;
            if(k<=0){
                k=Integer.MAX_VALUE;
                return root;
            }
            return left;
        }
        if(right!=null && left==null){
            k--;
            if(k<=0){
                k=Integer.MAX_VALUE;
                return root;
            }
            return right;
        }
        return null;
    }
    public int getKthAncestor(TreeNode root,int node, int k) {
        TreeNode treeNode=getAncestor(root,node,k);
        if(treeNode==null)
            return -1;
        else
            return treeNode.data;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
public class KthAncestor {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(4);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(6);
        TreeNode n6=new TreeNode(7);
        TreeNode n7=new TreeNode(8);
        TreeNode n8=new TreeNode(9);
        TreeNode n9=new TreeNode(10);
        TreeNode n10=new TreeNode(11);

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
        TreeAncestor t=new TreeAncestor();
        System.out.println(t.getKthAncestor(root,11,1));
    }

}
//11->5->2->1