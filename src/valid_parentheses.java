import java.util.Stack;

/**
 * Created by stameying on 12/15/15.
 */
public class valid_parentheses {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if (stack.isEmpty()) return false;
                else{
                    char temp = stack.pop();
                    if (ch == ')'){
                        if (temp != '(') return false;
                    }else if (ch == ']'){
                        if (temp != '[') return false;
                    }else{
                        if (temp != '{') return false;
                    }
                }
            }
        }
        return true;
    }

}
