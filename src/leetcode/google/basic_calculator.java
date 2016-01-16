package leetcode.google;

import java.util.Stack;

/**
 * Created by stameying on 1/15/16.
 */
public class basic_calculator {

    public int calculate(String s) {
        if (s.length() == 0) return 0;
        int res = 0;
        /* main purpose for this stack is to store the sign, which is 1 as positive, -1 as negative
        * because 1+(2-3) can be viewed as 1+1*2-1*3
        * and 1-(2-3) can be viewed as 1+(-1)*2+(-1)*(-1)*3
        */
        Stack<Integer> stack = new Stack<Integer>();
        // put a helper positive sign
        stack.push(1);
        // handle input string, get rid of space
        String str = s.replaceAll(" ","");
        int sign = 1;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if ( ch == '+'){
                sign = 1;
            }else if ( ch == '-'){
                sign = -1;
            }else if ( ch == '('){
                stack.push(stack.peek()*sign);
                sign = 1;
            }else if ( ch == ')'){
                stack.pop();
            }else{
                // digit
                int j;
                for (j = i+1; j < str.length(); j++){
                    if (Character.isDigit(str.charAt(j))) continue;
                    else{
                        break;
                    }
                }
                int num = Integer.parseInt(str.substring(i,j));
                res += stack.peek()*sign*num;
                i = j-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        basic_calculator calculator = new basic_calculator();
//        System.out.println(calculator.calculate("1+(5)"));
        String s = "he llo";
        String temp = s.replaceAll(" ","");
        System.out.println(temp);
    }
}
