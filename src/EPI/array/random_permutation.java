package EPI.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by stameying on 1/29/16.
 */
public class random_permutation {

    public static List<Integer> random_permutation(int n){
        List<Integer> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            res.add(i);
        }
        Random gen = new Random();
        for (int i = 0; i < n; i++){
            int temp = i+gen.nextInt(n-i);
            System.out.println("i="+i+";temp="+temp);
            Collections.swap(res,i,temp);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        random_permutation(5);
    }
}
