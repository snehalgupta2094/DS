package Interviews.karat;
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
Given same input as Q1 and 2 nodes a, b. Determine both nodes share same ancestors. Remember this is a directed graph and not a tree, try to think of all edge cases like both nodes could be present at farther apart.

Edit: Solution

Calculate indegree[] of all nodes by iterating connections and prepare a hashset with list of all nodes.
Compare these 2 data to compute result.

Start with a parent node one at a time, perform dfs() through the graph at the same time keep a stack of parent nodes.
Once one of the 2 nodes(a/b) is seen, copy the current content of stack to distinct hashmap[] for the visited child.
After visiting both child, check any common nodes in the hashmap.
*
* */
public class ParentsOfNode {

}
