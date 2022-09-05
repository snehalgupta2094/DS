package Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
class MergeLogic{
    public List<Integer> mergeKSorted(List<List<Integer>> kArrays, int k){
        List<Integer> mergeList=new ArrayList<>();
        PriorityQueue<Node> queue=new PriorityQueue<>((node1, node2)->Integer.compare(node1.data, node2.data));

        //Step: saare k arrays ka first element insert kr denge heap mein
        for(int i=0;i<k;i++){
           Node node=new Node(kArrays.get(i).get(0), i, 0);
            queue.offer(node);
        }
        //Step2: minimum data aur indexes extract karenge then array index ko increment karenge
        while(queue.size()>0){
            Node temp=queue.remove();
            mergeList.add(temp.data);
            int i=temp.i; //array no
            int j=temp.j; //array index
            if(j+1<kArrays.get(i).size()){
                Node node=new Node(kArrays.get(i).get(j + 1), i, j + 1);
                queue.offer(node);
            }
        }
        return mergeList;
    }

}
class Node{
    int data;
    int i,j;
    Node(int data, int i, int j){
        this.data=data;
        this.i=i;
        this.j=j;
    }
}
public class MergeKSortedArrays {
    public static void main(String[] args) {
        List<List<Integer>> kArrays=new ArrayList<>();
        List<Integer> a= Arrays.asList(1,3,5,13);
        List<Integer> b= Arrays.asList(2,4,6,7,10,12);
        List<Integer> c= Arrays.asList(11,15);
        kArrays.add(a);
        kArrays.add(b);
        kArrays.add(c);
       MergeLogic m=new MergeLogic();
       List<Integer> list=m.mergeKSorted(kArrays,kArrays.size());
        System.out.println(list);
    }
}
