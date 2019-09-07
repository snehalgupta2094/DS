package Stacks;

import java.util.Stack;

public class SymbolBalancing {
	 // Complete the isBalanced function below.
    static String isBalanced(String s) {
     Stack<Character> stack=new Stack<Character>();
     for(int i=0;i<s.length();i++)
     {
        if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
        {
            stack.push(s.charAt(i));
        }
        else if(s.charAt(i)==')')
        {
            if(!stack.isEmpty() && stack.peek()=='(')
                stack.pop();
            else
                return "NO";
        }
        else if(s.charAt(i)=='}')
        {
            if(!stack.isEmpty() && stack.peek()=='{')
                stack.pop();
            else
                return "NO";
        }
        else if(s.charAt(i)==']')
        {
            if(!stack.isEmpty() && stack.peek()=='[')
                stack.pop();
            else
                return "NO";
        }
     }
        if(stack.isEmpty())
        return "YES";
    return "NO";
    }
public static void main(String[] args) {
	//String s="{(][)}";
	String s="{[()]}";
	System.out.println(isBalanced(s));
}
}
