package EPI.stack_and_queue;

import java.util.Stack;

/**
 * Created by stameying on 1/28/16.
 */
public class max_stack {
    Stack<Integer> maxStack;
    Stack<Integer> stack;

    public max_stack(){
        maxStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int val){
        stack.push(val);
        if (maxStack.isEmpty() || val >= maxStack.peek()) maxStack.push(val);
    }

    public int pop(){
        int res = stack.pop();
        if (res == maxStack.peek()) maxStack.pop();
        return res;
    }

    public int peek(){
        return stack.peek();
    }

    public int max(){
        return maxStack.peek();
    }
}
