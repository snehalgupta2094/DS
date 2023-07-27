package Stacks;

import java.util.Arrays;
import java.util.Stack;

class DecodeImpl {
    public String decodeString(String s) {
        Stack<String> stack=new Stack<String>();
        int token=0;
        String output="";
        while(token<s.length()){
            char t=s.charAt(token);
            //digit
            if(Character.isDigit(t)){
                int num=0;
                while(Character.isDigit(t)){
                    num=num*10+(t-'0');
                    token++;
                    if(token<s.length())
                        t=s.charAt(token);
                    else
                        break;
                }
                token--;
                stack.push(""+num);
            }
            else if(t==']'){
                String temp="";
                while(!stack.isEmpty() && !stack.peek().equals("[")){
                    temp=temp+stack.pop();
                }

               stack.pop();
                int num=Integer.parseInt(stack.pop());
                String temp1="";
                for(int i=0;i<num;i++)
                    temp1=temp1+temp;
                System.out.println("--here:"+reverse(temp1));
                if(!stack.isEmpty())
                    stack.push(reverse(temp1));
            }
            else{
                stack.push(""+t);
            }
            token++;
        }
        String temp="";
        while (!stack.isEmpty())
            temp=temp+stack.pop();
        System.out.println("--here1:"+temp);
        output=output+temp;
        System.out.println(output);
        return output;
    }
    public String reverse(String output){
        int i=0, j=output.length()-1;
        char[] op=output.toCharArray();
        while(i<j){
            char a=op[i];
            op[i]=op[j];
            op[j]=a;
            i++;
            j--;
        }
        return String.valueOf(op);
    }
}
public class Decode {

    public static void main(String[] args) {
        DecodeImpl d=new DecodeImpl();
        String op=d.decodeString("abc3[cd]xyz");
        System.out.println(op);
        //aacdecdeaacdecdeaacdecde
        //edcedcedcedcaedcedcaedcedca
    }
}
