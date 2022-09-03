package Stacks;

import java.util.Stack;

public class FindMid {


    public static void getMiddle(Stack<Integer> stack, int count, int size){
        //base case
        if(count==size/2)
        {
            System.out.println(stack.pop());
            return;
        }
        int top=stack.pop();
        getMiddle(stack,count+1,size);
        stack.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> inputStack=new Stack<>();
        inputStack.push(1);
        inputStack.push(3);
        inputStack.push(9);
        inputStack.push(4);
        inputStack.push(5);
        getMiddle(inputStack,0,5);
        System.out.println(inputStack);
    }
}
