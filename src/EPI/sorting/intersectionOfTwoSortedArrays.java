package EPI.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stameying on 2/2/16.
 */
public class intersectionOfTwoSortedArrays {

    public static List<Integer> intersection(List<Integer> A, List<Integer> B){
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.size() && j < B.size()){
            System.out.println("i="+i+" j="+j);
            if (A.get(i) == B.get(j) && (i==0 || A.get(i) != A.get(i-1))){
                res.add(A.get(i));
                i++;
                j++;
            }else if (A.get(i) < B.get(j)){
                i++;
            }else{
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(2,3,3,5,7,7,11));
        List<Integer> B = new ArrayList<>(Arrays.asList(3,3,7,7,15,31));
        System.out.println(intersection(A,B));

    }
}
