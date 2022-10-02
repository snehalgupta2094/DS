package Tree;

import java.util.HashMap;

public class BurnTree {
    public static int createMap(HashMap<Integer,Integer> nodeToParent){
        nodeToParent.put(1,1);
        nodeToParent.put(2,2);
        return 7;
    }
    public static void main(String[] args) {
        HashMap<Integer,Integer> nodeToParent=new HashMap<>();
       int targetNode=createMap(nodeToParent);
        System.out.println(nodeToParent.size());
    }
}