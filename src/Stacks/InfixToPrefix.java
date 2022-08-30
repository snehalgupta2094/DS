package Stacks;

import java.util.Stack;

public class InfixToPrefix {
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
        String output="";
        Stack<Character> st=new Stack<>();
        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                output=output+ch;
            }
            else if(ch==']' || ch=='}' || ch==')'){
                st.push(ch);
            }
            else if(ch=='(' || ch=='[' || ch=='{'){
                while (!st.isEmpty() && (st.peek()!=')' && st.peek()!=']' && st.peek()!='}')){
                    output=output+st.pop();
                }
                st.pop();
            }
            else{
                while (!st.isEmpty() && preceedence(ch)<preceedence(st.peek())){
                    output=output+st.pop();
                }
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            output=output+st.pop();
        }
        return reverse(output);
    }
    public static void main(String[] args) {
        String input="K+L-M*N+(O^P)*W/U/V*T+Q";
        System.out.println(solve(input));
    }
}
