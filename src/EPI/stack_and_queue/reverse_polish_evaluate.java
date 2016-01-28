package EPI.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by stameying on 1/28/16.
 */
public class reverse_polish_evaluate {

    public static int eval(String expression){
        Deque<Integer> result = new LinkedList<>();
        String delimiter = ",";
        String[] symbols = expression.split(delimiter);
        for (String token: symbols){
            if (token.length() == 1 && "+-*/".contains(token)){
                int y = result.removeFirst();
                int x = result.removeFirst();
                switch (token.charAt(0)){
                    case '+':
                        result.addFirst(x+y);
                        break;
                    case '-':
                        result.addFirst(x-y);
                        break;
                    case '*':
                        result.addFirst(x*y);
                        break;
                    case '/':
                        result.addFirst(x/y);
                        break;
                    default:
                        throw new IllegalArgumentException("Mal formed RPN at :" + token);
                }
            }else{
                result.addFirst(Integer.parseInt(token));
            }
        }
        return result.removeFirst();
    }
}
