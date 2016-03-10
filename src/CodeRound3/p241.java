package src.CodeRound3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by stameying on 3/9/16.
 */
public class p241 {

    public static List<Integer> diffWaysToCompute(String input) {
        Set<Integer> outputs = new HashSet<>();
        List<String> list = parseInput(input);
        dfs(list, outputs);
        List<Integer> res = new ArrayList<>(outputs);
        return res;
    }

    public static void dfs(List<String> list, Set<Integer> outputs){
        if (list.size() == 1){
            int sol = Integer.parseInt(list.get(0));
            outputs.add(sol);
            return;
        }
        for (int i = 0; i < list.size()-2; i+=2){
            System.out.println(list);
            List<String> nextExp = new ArrayList<>();
            for (int j = 0; j < i; j++){
                nextExp.add(list.get(j));
            }
            nextExp.add(String.valueOf(eval(list.get(i),list.get(i+1),list.get(i+2))));
            for (int j = i+3; j < list.size(); j++){
                nextExp.add(list.get(j));
            }
            dfs(nextExp,outputs);
        }
    }

    public static List<String> parseInput(String input){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if ("+-*".indexOf(ch) != -1){
                list.add(ch+"");
            }else{
                int j = i+1;
                while (j < input.length() && Character.isDigit(input.charAt(j))) j++;
                list.add(input.substring(i,j));
                i = j-1;
            }
        }
        return list;
    }

    public static int eval(String num1, String op, String num2){
        System.out.println("eval " + num1 + op + num2);
        int num_1 = Integer.parseInt(num1);
        int num_2 = Integer.parseInt(num2);
        if (op.equals("+")) return num_1+num_2;
        else if (op.equals("-")) return num_1-num_2;
        else return num_1*num_2;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
}
