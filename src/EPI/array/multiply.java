package EPI.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by stameying on 1/28/16.
 */
public class multiply {
    public static List<Integer> multiply(List<Integer> num1, List<Integer> num2){
        boolean isNegative = (num1.get(0) < 0 && num2.get(0) >= 0 ) || (num1.get(0) >= 0 && num2.get(0) < 0);
        num1.set(0, Math.abs(num1.get(0)));
        num2.set(0, Math.abs(num2.get(0)));

        // reserve to make it easier
        Collections.reverse(num1);
        Collections.reverse(num2);

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < num1.size()+num2.size(); i++){
            res.add(0);
        }
        for (int i = 0; i < num1.size(); ++i){
            for (int j = 0; j < num2.size(); ++j){
                int temp = res.get(i+j)+num1.get(i)*num2.get(j);
                res.set(i+j+1,res.get(i+j+1)+temp/10);
                res.set(i+j,temp%10);
            }
        }

        while (res.size() != 1 && res.get(res.size()-1) == 0) res.remove(res.size()-1);

        Collections.reverse(res);

        if (isNegative) res.set(0,res.get(0)*-1);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> num1 = new ArrayList<Integer>(2);
        num1.add(1);
        num1.add(5);
        List<Integer> num2 = new ArrayList<Integer>(2);
        num2.add(2);
        num2.add(0);
        System.out.println(multiply(num1,num2));
    }
}
