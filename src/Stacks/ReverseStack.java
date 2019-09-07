package Stacks;

import java.util.Stack;

public class ReverseStack {
public static void main(String[] args) {
	Stack<Integer> s=new Stack<Integer>();
	s.push(1);
	s.push(2);
	s.push(3);
	s.push(4);
	s.push(5);
	System.out.println(s);
	reverse(s);
	System.out.println(s);
}

private static void reverse(Stack<Integer> s) {
	int element=s.pop();
	if(s.size()!=1)
	{
		reverse(s);
	}
	
	pushToBottom(element,s);
}

private static void pushToBottom(int element, Stack<Integer> s) {
	// TODO Auto-generated method stub
	if(s.isEmpty())
	{
		s.push(element);
		return;
	}
	
int temp=s.pop();
pushToBottom(element, s);
s.push(temp);
}
}
