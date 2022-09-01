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
    public static int calculate(int a, int b, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return b-a;
            case '/':
                if (a == 0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b/a;
            case '^':
                return a^b;
            case '*':
                return a*b;
        }
        return 0;
    }
    public static int solve(String expr){
        Stack<Integer> operand=new Stack<>();
        Stack<Character> operator=new Stack<>();

        for(int i=0;i<expr.length();i++){
            char ch=expr.charAt(i);

            //operand
            if(Character.isDigit(ch)){
                //Entry is Digit, it could be greater than one digit number
                int num = 0;
                while (Character.isDigit(ch)) {
                    num = num*10 + (ch-'0');
                    i++;
                    if(i < expr.length())
                        ch = expr.charAt(i);
                    else
                        break;
                }
                i--;
                //push it into stack
                operand.push(num);
            }
            //open bracket
            else if(ch=='('){
                operator.push(ch);
            }
            //close bracket
            else if(ch==')'){
                while (operator.peek()!='('){
                    //push it back to stack
                    int result=calculate(operand.pop(),operand.pop(), operator.pop());
                    operand.push(result);
                }
                operator.pop();
            }
            //operator
            else if(isOperator(ch)){
                //1. If current operator has higher precedence than operator on top of the stack,
                //the current operator can be placed in stack
                // 2. else keep popping operator from stack and perform the operation in numbers stack till
                //either stack is not empty or current operator has higher precedence than operator on top of the stack
                while(!operator.isEmpty() && preecedence(ch)<=preecedence(operator.peek())){
                    int output=calculate(operand.pop(),operand.pop(), operator.pop());
                    System.out.println("---"+output);
                   operand.push(output);
                }
                operator.push(ch);
            }
        }
        while(!operator.isEmpty()){
            int output=calculate(operand.pop(),operand.pop(), operator.pop());
            System.out.println("---"+output);
            operand.push(output);
        }
        return operand.pop();
    }
    public static boolean isOperator(char c){
        return (c=='+'||c=='-'||c=='/'||c=='*'||c=='^');
    }
    public static void main(String[] args) {
        String infixExpression = "2*(5*(3+6))/15-2";
        System.out.println(solve(infixExpression));
    }
}
