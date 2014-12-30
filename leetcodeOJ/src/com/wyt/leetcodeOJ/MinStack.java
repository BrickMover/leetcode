package com.wyt.leetcodeOJ;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	int min;
	
	
	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(1);
		stack.push(0);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack.getMin());
	}
	
	
	public void push(int x) {
		if (stack.empty() || min >= x) {
			stack.push(min);
			stack.push(x);
			min = x;
		} else {
			stack.push(x);
		}
	}
	
	public void pop(){
		if(stack.pop() == min) {
			min = stack.pop();
		}
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return min;
	}
	
}
