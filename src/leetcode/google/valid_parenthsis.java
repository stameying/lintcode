package leetcode.google;

import java.util.Stack;

/**
 * Created by stameying on 1/12/16.
 */
public class valid_parenthsis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else{
                if (stack.size() == 0) return false;
                if (ch == ')'){
                    if (stack.pop() != '(') return false;
                }else if (ch == ']'){
                    if (stack.pop() != '[') return false;
                }else{
                    if (stack.pop() != '{') return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
