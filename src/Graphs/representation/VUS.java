package Graphs.representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class VUS {
static class Pair<K,V>{
   K count;
   V element;
   Pair(K count, V element){
       this.count=count;
       this.element=element;
   }
}
    public static void main(String[] args) {
    Integer abc=null;
        System.out.println(">>abc"+abc);
    /* int nums[]={1,1,1,2,2,3};
     int k=2;
        HashMap<Integer, Integer> countMap=new HashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
                countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->Integer.compare((int)b.count, (int)a.count));

        for (Map.Entry<Integer,Integer> entry:countMap.entrySet()){
            q.offer(new Pair<>(entry.getValue(),entry.getKey()));
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=(int)q.peek().element;
            q.remove(q.peek());
            System.out.println(result[i]);
        }*/
    }
}

