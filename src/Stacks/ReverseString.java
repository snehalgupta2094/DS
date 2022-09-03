package Stacks;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String d="abcd";
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<d.length();i++)
            stack.push(d.charAt(i));

        for (int i = 0; i < d.length(); i++) {
            System.out.print(stack.pop());
        }


    }
}
