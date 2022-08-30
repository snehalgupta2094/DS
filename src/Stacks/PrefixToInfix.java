package Stacks;

import java.util.Stack;

public class PrefixToInfix {
    public static String reverse(String str){
        char arr[]=str.toCharArray();
        int s=0;
        int e= str.length()-1;
        while(s<=e){
            char temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
        return String.valueOf(arr);
    }
    public static String solve(String expr){
        expr=reverse(expr);
        Stack<String> st=new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                st.push(""+ch);
            }
            else{
                String op1= st.pop();
                String op2= st.pop();
                st.push("("+op1+ch+op2+")");
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        String prefix="++-+KL*MN*//*^OPWUVTQ";
        System.out.println(solve(prefix));
    }
}
