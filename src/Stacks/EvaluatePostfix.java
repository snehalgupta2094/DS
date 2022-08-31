package Stacks;

import java.util.Stack;

public class EvaluatePostfix {
    public static int calculate(int b, int a, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '/':
                return a/b;
            case '^':
                return a^b;
            case '*':
                return a*b;
        }
        return -1;
    }
    public static int solve(String expr){
       Stack<Integer> st=new Stack<>();
       for(int i=0;i<expr.length();i++){
           char ch=expr.charAt(i);
            if(ch==' ')
                continue;
           //operand
           if(ch>='0' && ch<='9'){
               int n=0;

               while(ch>='0' && ch<='9'){
                   int num=ch-'0';
                   n=n*10+num;
                   i++;
                   ch=expr.charAt(i);
               }
               i--;
               st.push(n);
           }
           //operator
           else
           {
               int output=calculate(st.pop(), st.pop(), ch);
               st.push(output);
           }
       }

        return st.pop();
    }
    public static void main(String[] args) {
        String postfix="100 200 + 2 / 5 * 7 +";
        System.out.println(solve(postfix));
    }
}
