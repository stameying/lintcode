package leetcode.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by stameying on 1/20/16.
 */
public class hIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Integer[] arr = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++){
            arr[i] = Integer.valueOf(citations[i]);
        }
        Arrays.sort(arr, new IntegerComparator());
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > i) continue;
            else return i;
        }
        return arr.length;
    }

    class IntegerComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            return Integer.compare(i2,i1);
        }
    }


    public static void main(String[] args) {
        int[] citations = {0};
        hIndex test = new hIndex();
        System.out.println(test.hIndex(citations));
    }
}
