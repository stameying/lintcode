package src.amazon_oa.oa2.second_trial;
import java.util.Stack;
/**
 * Created by stameying on 2/28/16.
 */
public class valid_paranthesis {

    public static int valid_parenthsis(String s){
        if (s == null || s.length() <= 1) return 0;
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(')');
            }else{
                if (stack.isEmpty()) return 0;
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return 0;
        return s.length()/2;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(valid_parenthsis(s));
    }
}
