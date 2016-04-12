package src.Google_Topic.Onsite;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by stameying on 4/6/16.
 */
public class test {


    public static class MyComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i1, Integer i2){
            if (i1 > i2) return 1;
            else if (i1.equals(i2)) return 0;
            else return -1;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2,4,1,3};
        Arrays.sort(arr, new MyComparator());
        System.out.println(Arrays.toString(arr));
    }
}
