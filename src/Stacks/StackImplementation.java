package Stacks;

import java.util.Arrays;

class Stacking{
	int top=-1;
        int capacity;
	int stack[];
	Stacking(int capacity){
		this.capacity=capacity;
		this.stack=new int[capacity];
	}
	public void push(int element) throws Exception  {
		top++;
		if(top==capacity)
			throw new Exception("full");
		stack[top]=element;
	}
        public int pop() throws Exception{
		if(top==-1)
			throw new Exception("empty");
		return stack[top--];
	}
	public void printStack() {
		System.out.println();
		for (int i = 0; i <=top; i++) {
			System.out.print(stack[i]+" ");
		}
	}
}
public class StackImplementation {
public static void main(String[] args) throws Exception {
	Stacking st=new Stacking(10);
	st.push(1);
	st.push(2);
	st.push(3);
	st.push(4);
	st.printStack();
	st.pop();
	st.pop();
	st.printStack();
	st.push(6);
	st.printStack();
}

}
