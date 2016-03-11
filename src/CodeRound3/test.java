package src.CodeRound3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 3/10/16.
 */
public class test {

    public static void main(String[] args) {
        int n = 7;
        int h = n & (~(n)+1);
        System.out.println(h);

        List<Integer> list = new ArrayList<>(Arrays.asList(2,3,5));
        List<Integer> list2 = Arrays.asList(2,3,5);

        System.out.println(list);
        System.out.println(list2);
    }
}
