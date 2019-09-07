package Stacks;

import java.util.Arrays;

class Stacking{
	int top=-1;
	int capacity=10;
	int s[]=new int[capacity];
	public void push(int data) throws Exception
	{
		if(top+1==capacity)
			throw new Exception("Stack overflow");
		s[++top]=data;
	}
	public int pop() throws Exception
	{
		if(top==-1)
			throw new Exception("Stack is empty");
		return s[top--];
	}
	public void printStack()
	{
		System.out.println("--printing stack");
		Arrays.stream(s).forEach(System.out::println);
	}
}
public class StackImplementation {
public static void main(String[] args) throws Exception {
	Stacking st=new Stacking();
	st.push(1);
	st.push(2);
	st.push(3);
	st.printStack();
	st.pop();
	st.push(6);
	st.printStack();
}

}
