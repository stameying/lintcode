package leetcode.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/24/16.
 */
public class Expression_Add_Operators {


    /**
     * 递归
     * 因为乘法优先于加减法, 所以需要特殊处理.
     * 如果是 1+2, 当前结果是3, 前一个数记录的是2, 当前想加的数是3, 符号是*, 便有 1+2 => 1+2*3,
     *   正确的做法应该是 当前的结果减去前一个数加上前一个数乘以当前的数
     *   当前res = 3, 下一个结果是 (3-2) + 2*3 => 1 + 2 * 3
     * */
    public List<String> Expression_Add_Operators(String num, int target){
        List<String> list = new ArrayList<>();
        dfs(0,num,target,list,"",0,0);
        return list;
    }

    public void dfs(int pos, String num, int target, List<String> list, String exp, long curRes, long prevNum){
        if (pos == num.length() && curRes == target){
            // a valid solution
            list.add(exp);
            return;
        }
        for (int i = pos+1; i <= num.length(); i++){
            //寻找下一个数
            String nextStr = num.substring(pos,i);
            // 如果有leading 0, 则不符合,需要返回, 无需再dfs
            if (nextStr.length() > 1 && nextStr.charAt(0) == '0') return; // here is return, not continue, since we won't find valid number anymore with a leading zero
            long nextNum = Long.parseLong(nextStr);
            if (exp.length() != 0){
                // try *
                // 如果是 1 + 2*3, 那下一层的前一个数应该是 2*3 而不是 3
                dfs(i,num,target,list,exp+"*"+nextNum,(curRes-prevNum)+prevNum*nextNum,prevNum*nextNum);
                // try +
                dfs(i,num,target,list,exp+"+"+nextNum,curRes+nextNum,nextNum);
                // try -
                dfs(i,num,target,list,exp+"-"+nextNum,curRes-nextNum,-1*nextNum);
            }else{ // 第一个数
                dfs(i,num,target,list,exp+nextStr,nextNum,nextNum);
            }
        }
    }

    public static void main(String[] args) {
        Expression_Add_Operators test = new Expression_Add_Operators();
        String num = "123";
        List res = test.Expression_Add_Operators(num,6);
        System.out.println(res);
    }
}
