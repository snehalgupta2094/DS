package Stacks;

import java.util.Stack;

public class PostfixToInfix {
    public static String solve(String expr){
        Stack<String> st=new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(""+ch);
            }
            else{
                String op2= st.pop();
                String op1= st.pop();
               st.push("("+op1+ch+op2+")");
            }

        }

        return st.pop();
    }
    public static void main(String[] args) {
     String postfix="KL+MN*-OP^W*U/V/T*+Q+";
     System.out.println(solve(postfix));
    }
}
