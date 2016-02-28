package src.amazon_oa.oa1;

import java.util.Stack;

/**
 * Created by stameying on 2/25/16.
 */
public class valid_parenthisis {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else{
                if (stack.isEmpty()) return false;
                if (ch == ')' && stack.peek() != '(') return false;
                if (ch == ']' && stack.peek() != '[') return false;
                if (ch == '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
