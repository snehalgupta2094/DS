package Stacks;

import java.util.Stack;

public class InsertAtBottom {

    public static void insertAtBottom(Stack<Integer> stack, int element){
        //base case
        if(stack.isEmpty()){
            stack.push(element);
            return;
        }
        int ele=stack.pop();
        //recursive call
        insertAtBottom(stack,element);
        stack.push(ele);
    }
    public static void main(String[] args) {
        Stack<Integer> inputStack=new Stack<>();
        inputStack.push(1);
        inputStack.push(3);
        inputStack.push(9);
        inputStack.push(4);
        inputStack.push(5);
        insertAtBottom(inputStack,11);
        System.out.println(inputStack);
    }
}
