package Stacks;

import java.util.Stack;

public class InfixToPostfix {

    public static int preceedence(char ch){
        switch (ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    public static String solve(String expr){
        String output="";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);
            //operand
            if(Character.isLetterOrDigit(ch)){
                output=output+ch;
            }
            //open parentheses
            else if(ch=='(' || ch=='{' || ch=='[') {
               st.push(ch);
            }
            //close parenthesis
            else if(ch==')' || ch=='}' || ch==']'){
                while(!st.isEmpty() && (st.peek()!='(' && st.peek()!='{' && st.peek()!='[')){
                    output=output+st.pop();
                }
                //discard [({
                    st.pop();
            }
            //operator
            else{
                while (!st.isEmpty() && preceedence(ch)<=preceedence(st.peek())){
                        output=output+st.pop();
                    }
                st.push(ch);
                }
            }

         //stack not empty
        while (!st.isEmpty()){
            output=output+st.pop();
        }
        return output;
    }
    public static void main(String[] args) {
        String input="K+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.println(solve(input));
    }
}
