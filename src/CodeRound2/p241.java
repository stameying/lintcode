package src.CodeRound2;
import java.util.List;
import java.util.ArrayList;
/**
 * Created by stameying on 3/1/16.
 */
public class p241 {

    public static List<Integer> diffWaysToCompute(String input) {
        List<String> inputList = new ArrayList<>();
        inputList = preProcess(input);
        // System.out.println(inputList);
        List<Integer> res = new ArrayList<>();
        dfs(inputList,res);
        return res;
    }

    public static void dfs(List<String> exp, List<Integer> res){
        System.out.println("exp="+exp);
        if (exp.size() == 1){
            res.add(Integer.parseInt(exp.get(0)));
            System.out.println("size="+res.size());
            return;
        }
        for (int i = 0; i + 2 < exp.size(); i+=2){
            List<String> nextExp = new ArrayList<>();
            for (int j = 0; j < i; j++){
                nextExp.add(exp.get(j));
            }
            nextExp.add(String.valueOf(eval(exp.get(i+1),exp.get(i),exp.get(i+2))));
            for (int j = i+3; j < exp.size(); j++){
                nextExp.add(exp.get(j));
            }
            dfs(nextExp,res);
        }
    }

    public static int eval(String op, String num1, String num2){
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        if (op.equals("+")) return n1+n2;
        else if (op.equals("-")) return n1-n2;
        else return n1*n2;
    }

    public static List<String> preProcess(String input){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if (Character.isDigit(ch)){
                int aheadIdx = i+1;
                while (aheadIdx < input.length() && Character.isDigit(input.charAt(aheadIdx))) aheadIdx++;
                list.add(input.substring(i,aheadIdx));
                i = aheadIdx-1;
            }else{
                list.add(input.substring(i,i+1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("15-7*6+24"));
    }

}
