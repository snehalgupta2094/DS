package Interviews.karat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* Coding question. You will ONLY be given 20 mins to solve it. Not an extra min more. In this 20 mins you need to understand/explain your approach and solve the problem. Was given a node tree and asked to find which nodes have single parent and which nodes dosen't have parents.
* Given a list of connections as parent->child (like a directed graph). Identify the parent nodes and number of child with 1 parent.

E.g:
[1,3]
[2,3]
[4,2]
[4,7]

parent - [1, 4]
child with 1 parent - [2, 7]

Q2.
Given same input as Q1 and 2 nodes a, b. Determine both nodes share same ancestors.
* Remember this is a directed graph and not a tree, try to think of all edge cases like both nodes could be present at farther apart.

Edit: Solution

Calculate indegree[] of all nodes by iterating connections and prepare a hashset with list of all nodes.
Compare these 2 data to compute result.

Start with a parent node one at a time, perform dfs() through the graph at the same time keep a stack of parent nodes.
Once one of the 2 nodes(a/b) is seen, copy the current content of stack to distinct hashmap[] for the visited child.
After visiting both child, check any common nodes in the hashmap.
*
* Given a set of relationship between parent and child , create two lists where one presents children with one parent while another one where children with no known parents.
[1,3][2,3][3,4][4,5][6,5] --> would be the answer in this case {4} & {1,2,6}

Modified the problem after this : Given a set of parent child pairs , find if there are any common ancestory between any two given input like hasCommonAns(int a, int b) should return true or false based.
For this part , i went with the approach of preparing an adjlist of child to parent and then traversing them in dfs to collect all ancestors in a set. Similarly for another input b and then compare the two sets for any common ancestor -- any suggestions please ?
*
* */
public class ParentsOfNode {

    public static void main(String[] args) {
        System.out.println("====Output 2===");
        int[][] relationship = {{1,3}, {2,3}, {3,4}, {4,5}, {6,5}};
        Map<Integer, List<Integer>> childParentMap = createRelationshipMap(relationship);
        findParents (relationship, childParentMap);
        System.out.println("===ancestor===");
        Set<Integer> ancestors1 = findAncestors(childParentMap, 4);
        Set<Integer> ancestors2 = findAncestors(childParentMap, 3);
        System.out.println(ancestors1);
        System.out.println(ancestors2);

        System.out.println("====Output 2===");
        int[][] relationship1 = {{1,3}, {2,3}, {4,2}, {4,7}};
        Map<Integer, List<Integer>> childParentMap1 = createRelationshipMap(relationship1);
        findParents (relationship1, childParentMap1);
        System.out.println("===ancestor===");
        Set<Integer> ancestors3 = findAncestors(childParentMap1, 2);
        Set<Integer> ancestors4 = findAncestors(childParentMap1, 7);
        System.out.println(ancestors3);
        System.out.println(ancestors4);

    }
    public static Map<Integer, List<Integer>> createRelationshipMap(int[][] relationship){
        Map<Integer, List<Integer>> childParentMap = new HashMap<>();
        for(int index = 0; index < relationship.length; index++){
            int parent = relationship[index][0];
            int child = relationship[index][1];

            List<Integer> parents = childParentMap.getOrDefault(child, new ArrayList<>());
            parents.add(parent);
            childParentMap.put(child, parents);
        }
        return childParentMap;
    }

    public static void findParents(int[][] relationship, Map<Integer, List<Integer>> childParentMap){

        Set<Integer> parentNodes = new HashSet<>();
        Set<Integer> singleParentNodes = new HashSet<>();

        for(int index = 0; index < relationship.length; index++){
            int parent = relationship[index][0];
            if(!childParentMap.containsKey(parent)){
                parentNodes.add(parent);
            }
        }

        Set<Map.Entry<Integer, List<Integer>>> childParentSet = childParentMap.entrySet();
        for(Map.Entry<Integer, List<Integer>> childParents : childParentSet){
            List<Integer> parents = childParents.getValue();

            if(parents.size() == 1){
                singleParentNodes.add(childParents.getKey());
            }
        }
        System.out.println(parentNodes);
        System.out.println(singleParentNodes);
    }

    public static Set<Integer> findAncestors(Map<Integer, List<Integer>> childParentMap, int node){
        Set<Integer> visited = new HashSet<>();
        Set<Integer> ancestors = new HashSet<>();

            if(!visited.contains(node)){
                return findAncestorsOfParent(visited, ancestors,childParentMap, node);
            }

        return null;
    }

    public static Set<Integer> findAncestorsOfParent(Set<Integer> visited, Set<Integer> ancestors , Map<Integer, List<Integer>> childParentMap, int child){
        if(visited.contains(child)){
            return ancestors;
        }

        List<Integer> parents = childParentMap.get(child);
        visited.add(child);

        if(parents == null){
            return ancestors;
        }

        for(int parent : parents){
            if(!visited.contains(parent)){
                ancestors.add(parent);
                findAncestorsOfParent(visited, ancestors, childParentMap, parent);
            }
        }

        return ancestors;
    }
}
