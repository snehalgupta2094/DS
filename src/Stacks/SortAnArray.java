package Stacks;

import java.util.Stack;

public class SortAnArray {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(11);
        s.push(2);
        s.push(10);
        s.push(5);
        s.push(20);
        System.out.println(s);
        sortStack(s);
        System.out.println(s);
    }

    private static void sortedInsert(Stack<Integer> stack,int element){
        //base condition
        if(stack.isEmpty() || (!stack.isEmpty() && stack.peek()<element)){
            stack.push(element);
            return;
        }

        int top=stack.pop();
        sortedInsert(stack,element);
        stack.push(top);
    }
    private static void sortStack(Stack<Integer> stack) {
        //base condition
        if(stack.isEmpty()){
            return;
        }

        int element =stack.pop();
        //recursive call
        sortStack(stack);
        sortedInsert(stack,element);
    }
}
