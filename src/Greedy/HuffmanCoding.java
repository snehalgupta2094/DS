package Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanCoding {
   static class TreeNode{
       int data;
       TreeNode left;
       TreeNode right;
       TreeNode(int data){
           this.data=data;
       }
   }
   public static void huffman(int coding[])
   {
       PriorityQueue<TreeNode> pq=new PriorityQueue<>((a,b)->Integer.compare(a.data,b.data));
       for(int i=0;i<coding.length;i++)
       {
           TreeNode node=new TreeNode(coding[i]);
           pq.offer(node);
       }
       //Create huffman tree
       while(pq.size()>1){
           TreeNode firstNode=pq.remove();
           TreeNode secondNode=pq.remove();
           TreeNode sumNode=new TreeNode(firstNode.data+secondNode.data);
           sumNode.left=firstNode;
           sumNode.right=secondNode;
           pq.offer(sumNode);
       }
       //Encode
       TreeNode root=pq.peek();
       String path="";
       ArrayList<String> result=new ArrayList<>();
       traversal(root,result,path);
       System.out.println(result);
   }
    public static void traversal(TreeNode root,ArrayList<String> result, String path) {
       if(root.left==null && root.right==null){
           result.add(path);
           return;
       }
       traversal(root.left,result,path+'0');
       traversal(root.right,result,path+'1');
    }
    public static void main(String[] args) {
        int [] coding={5,9,12,13,16,45};
        huffman(coding);
    }

}
