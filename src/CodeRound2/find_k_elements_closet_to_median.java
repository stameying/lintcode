package src.CodeRound2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by stameying on 2/18/16.
 */
public class find_k_elements_closet_to_median {

    /**
     * Given an array,
     * Output k elements thats closet to the median of the array
     * */


    /*
    * Brute force:
    * 1. sort
    * 2. find median and move either side
    * */

    /*
    * Second:
    * 1. Use quick select to find median
    * 2. Scan array and maintain a max heap of size k by difference between this element and the median
    * */

    /*
    * Use quick select k times
    * */
    public static List<Integer> findKClosetToMedian(List<Integer> A, int k){
        final double median = findMedian(A);

        Comparator<Integer> cmp = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return Double.compare(Math.abs(a-median),Math.abs(b-median));
            }
        };

//        OrderStatistic.findKth(A,k,cmp);

        return new ArrayList<>(A.subList(0,k));
    }

    public static double findMedian(List<Integer> A){
        int half = A.size()/2+1;
        if (A.size()%2 != 0){
            return (double)(A.get(half-1));
        }else{
            int x = A.get(half-1);
//            OrderStatistic.findKthSmallest(A,half-1);
            return 0.5 * (x+A.get(half-2));
        }

    }
}
