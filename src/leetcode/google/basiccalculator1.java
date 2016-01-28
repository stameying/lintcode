package leetcode.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stameying on 1/16/16.
 */
public class basiccalculator1 {

    private List<String> fixStr;
    /**
     * https://github.com/stameying/lintcode/blob/master/infix_to_postfix.md
     * */
    public basiccalculator1(String str){
        fixStr = infix_to_postfix(str);
        displayFiXStr(fixStr);
    }

    public void displayFiXStr(List<String> fixStr){
        StringBuilder builder = new StringBuilder();
        for (String str:fixStr){
            builder.append(str);
        }
        System.out.println( builder.toString());
    }

    public List<String> infix_to_postfix(String input){
        char[] inputArr = input.replaceAll(" ","").toCharArray();
        List<String> res = new ArrayList<>();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    res.add(stack.pop().toString());
                }
                stack.push(ch);
            }else if (ch == '*' || ch == '/'){
                while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    res.add(stack.pop().toString());
                }
                stack.push(ch);
            }else if (ch == '('){
                stack.push(ch);
            }else if (ch == ')'){
                while (!stack.isEmpty() && stack.peek() != '('){
                    res.add(stack.pop().toString());
                }
                stack.pop();
            }else{
                // number
                int j = i+1;
                for (; j < input.length(); j++){
                    if (!Character.isDigit(input.charAt(j))) break;
                }
                int num = Integer.parseInt(input.substring(i,j));
                res.add(String.valueOf(num));
                i = j-1;
            }
        }
        while (!stack.isEmpty()){
            // stack shoud not contain '(', otherwise it is error
            res.add(stack.pop().toString());
        }
        return res;
    }

    public int evalueate(){
        Stack<Integer> stack = new Stack<>();
        for (String str: fixStr){
            char ch = str.charAt(0);
            if (Character.isDigit(ch)){
                stack.push(Integer.parseInt(str));
            }else{
                // operator
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (ch == '+'){
                    stack.push(num1+num2);
                }else if (ch == '-'){
                    stack.push(num1-num2);
                }else if (ch == '*'){
                    stack.push(num1*num2);
                }else{
                    stack.push(num1/num2);
                }
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        basiccalculator1 calculator = new basiccalculator1("2*6-(23+7)/(1+2)");
        System.out.println(calculator.evalueate());
    }
}
