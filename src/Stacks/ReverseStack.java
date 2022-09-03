package Stacks;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
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
		//base case
		if (s.isEmpty()) {
			return;
		}

		int element = s.pop();
		reverse(s);
		insertAtBottom(s, element);
	}

	public static void insertAtBottom(Stack<Integer> stack, int element) {
		//base case
		if (stack.isEmpty()) {
			stack.push(element);
			return;
		}
		int ele = stack.pop();
		//recursive call
		insertAtBottom(stack, element);
		stack.push(ele);
	}
}
