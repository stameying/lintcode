package src.CodeRound2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by stameying on 2/24/16.
 */
public class p227 {

    public static int calculate(String s) {
        List<String> list = toInputList(s);
        List<String> PolishOrder = toPolishOrder(list);
        System.out.println(PolishOrder);
        return calculate(PolishOrder);
    }

    public static int calculate(List<String> list){
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String str: list){
            if (str.length() == 1 && !Character.isDigit(str.charAt(0))){
                int num2 = stack.pop();
                int num1 = stack.pop();
                char op = str.charAt(0);
                if (op == '+'){
                    stack.push(num1+num2);
                }else if (op == '-'){
                    stack.push(num1-num2);
                }else if (op == '*'){
                    stack.push(num1*num2);
                }else{
                    stack.push(num1/num2);
                }
            }else{
                int number = Integer.parseInt(str);
                stack.push(number);
            }
        }
        return stack.pop();
    }

    public static List<String> toPolishOrder(List<String> list){
        Stack<String> opStack = new Stack<>();
        List<String> PolishOrder = new ArrayList<>();
        for (String str: list){
            if (str.length() == 1 && !Character.isDigit(str.charAt(0))){
                //operator
                char op = str.charAt(0);
                if (op == '+' || op == '-'){
                    while (!opStack.isEmpty() && opStack.peek().charAt(0) != '('){
                        PolishOrder.add(opStack.pop());
                    }
                    opStack.push(op+"");
                }else if (op == '*' || op == '/'){
                    while (!opStack.isEmpty() && (opStack.peek().charAt(0) != '(' && opStack.peek().charAt(0) != '+' && opStack.peek().charAt(0) != '-' )){
                        PolishOrder.add(opStack.pop());
                    }
                    opStack.push(op+"");
                }else if (op == '('){
                    opStack.push(op+"");
                }else{ // ')'
                    while (!opStack.isEmpty() && (opStack.peek().charAt(0) != '(')){
                        PolishOrder.add(opStack.pop());
                    }
                    opStack.pop();
                }
            }else{
                PolishOrder.add(str);
            }
        }

        while (!opStack.isEmpty()) PolishOrder.add(opStack.pop()+"");
        return PolishOrder;
    }

    public static List<String> toInputList(String s){
        List<String> list = new ArrayList<>();
        int pos = 0;
        while (pos < s.length()){
            if (Character.isDigit(s.charAt(pos))){
                int aheadIdx = pos+1;
                while (aheadIdx < s.length() && Character.isDigit(s.charAt(aheadIdx))) aheadIdx++;
                list.add(s.substring(pos,aheadIdx));
                pos = aheadIdx;
            }else{
                if (s.charAt(pos) == ' '){
                    pos++;
                    continue;
                }
                list.add(s.substring(pos,pos+1));
                pos++;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        System.out.println( calculate("3+2*(2-3)"));
    }
}
