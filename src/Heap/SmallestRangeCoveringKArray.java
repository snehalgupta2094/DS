package Heap;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringKArray {
static class Node{
    int data;
    int i;
    int j;
    Node(int data, int i, int j){
        this.data=data;
        this.i=i;
        this.j=j;
    }
}
public static void smallestRange(List<List<Integer>> list){
    PriorityQueue<Node> pq=new PriorityQueue<>((node1,node2)->Integer.compare(node1.data,node2.data));
    int k=list.size();
    int max=Integer.MIN_VALUE;
    int min=Integer.MAX_VALUE;
    for(int i=0;i<k;i++){
        max=Math.max(list.get(i).get(0),max);
        min=Math.min(list.get(i).get(0),min);
        Node node=new Node(list.get(i).get(0),i,0);
        pq.offer(node);
    }

    int start=min,end=max;
    while (pq.size()>0){
        Node temp=pq.remove();
        min=temp.data;
        int i=temp.i;
        int j=temp.j;
        int n=list.get(i).size();
        if(max-min<end-start){
           start=min;
           end=max;
        }
        if(temp.j+1<n){
            max=Math.max(list.get(i).get(j+1),max);
            Node node=new Node(list.get(i).get(j+1),i,j+1);
            pq.offer(node);
        }
    }
}
    public static void main(String[] args) {

    }
}
