import java.util.ArrayList;
import java.util.List;

/**
 * Created by stameying on 1/3/16.
 */
public class Print_Numbers_by_Recursion {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (n == 0) return res;
        getNumber(1,n,0,res);
        return res;
    }

    public void getNumber(int cur, int n, int prev, List<Integer> res){
        if (cur > n) return;
        
    }

    public static void main(String[] args) {
        Print_Numbers_by_Recursion test = new Print_Numbers_by_Recursion();
        List<Integer> res = test.numbersByRecursion(2);
        for (int i = 0; i < res.size(); i++){
            System.out.print(res.get(i)+",");
        }
    }
}
