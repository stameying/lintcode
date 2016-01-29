package EPI.stack_and_queue;

import java.util.Stack;

/**
 * Created by stameying on 1/28/16.
 */
public class sort_stack {

    public static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()){
            int val = stack.pop();
            sort(stack);
            insert(stack,val);
        }
    }

    public static void insert(Stack<Integer> stack, int val){
        if (stack.isEmpty() || stack.peek() <= val) stack.push(val);
        else{
            int temp = stack.pop();
            insert(stack,val);
            stack.push(temp);
        }

    }
}
