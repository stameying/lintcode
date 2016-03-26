package src.CodeRound3;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 3/20/16.
 */
public class p179 {

    public static String largestNumber(int[] nums) {
        String curStr = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return (i1+""+i2).compareTo(i2+""+i1);
            }
        });

        for (int num : nums){
            pq.offer(num);
        }

        StringBuilder builder = new StringBuilder();
        while (!pq.isEmpty()){
            builder.insert(0,pq.poll());
        }

        return builder.toString();
    }


    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
