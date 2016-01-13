package leetcode.google;

import java.util.Stack;

/**
 * Created by stameying on 1/12/16.
 */
public class minstack {

    Stack<Integer> minstack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty() || x <= minstack.peek()) minstack.push(x);
    }

    public void pop() {
        int i = stack.pop();
        if (i == minstack.peek()) minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }

}
