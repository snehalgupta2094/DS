package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    class Pair<K,V>{
       K first;
       V second;
       Pair(K first,V second){
           this.first=first;
           this.second=second;
       }
    }
    public List<List<Integer>> verticalTraversal(Node root) {
        if(root==null)
            return null;
    Map<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
    Queue<Pair<Node,Pair<Integer,Integer>>> queue=new ArrayDeque<>();

    queue.offer(new Pair<>(root,new Pair<>(0,0)));

    while (!queue.isEmpty()){
        //fetch from queue
        Pair<Node,Pair<Integer,Integer>> p=queue.poll();
        Node frontNode=p.first;
        Pair p1=p.second;
        int level=(int) p1.first;
        int hd= (int) p1.second;

        //insert in tree map

        map.putIfAbsent(hd,new TreeMap<>());
        map.get(hd).putIfAbsent(level,new PriorityQueue<>());
        map.get(hd).get(level).add(frontNode.data);

        //perform preorder
        if(frontNode.left!=null)
            queue.offer(new Pair<>(frontNode.left,new Pair<>(hd-1,level+1)));
        if(frontNode.right!=null)
            queue.offer(new Pair<>(frontNode.right,new Pair<>(hd+1,level+1)));
    }

    List<List<Integer>> result=new ArrayList<>();
    for(Map<Integer,PriorityQueue<Integer>> distanceMap:map.values()){
        for(PriorityQueue<Integer> levelList:distanceMap.values()){
            ArrayList<Integer> res=new ArrayList<>();
            for(int j:levelList){
                res.add(j);
            }
            result.add(res);
        }
    }
     return result;
    }
}
