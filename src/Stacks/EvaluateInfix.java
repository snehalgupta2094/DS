package Stacks;

import java.util.Stack;

public class EvaluateInfix {

    public static int preecedence(char ch){
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
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);

            //operand
            if(ch>='0' && ch<='9'){
                int num=ch-'0';
                System.out.println(num);
                operand.push(num);
            }
            //open bracket
            else if(ch=='('){
                operator.push(ch);
            }
            //close bracket
            else if(ch==')'){
                while (!operator.isEmpty() && operator.peek()!='('){
                    //push it back to stack
                    int result=calculate(operand.pop(),operand.pop(), operator.pop());
                    operand.push(result);
                }
                operator.pop();
            }
            //operator
            else{
                //1. If current operator has higher precedence than operator on top of the stack,
                //the current operator can be placed in stack
                // 2. else keep popping operator from stack and perform the operation in numbers stack till
                //either stack is not empty or current operator has higher precedence than operator on top of the stack
                while(!operator.isEmpty() && preecedence(ch)<=preecedence(operator.peek())){
                    int output=calculate(operand.pop(),operand.pop(), operator.pop());
                   operand.push(output);
                }
                operator.push(ch);
            }
        }

        return operand.pop();
    }
    public static void main(String[] args) {
        String infix="(5+3)/4";
        System.out.println(solve(infix));
    }
}
