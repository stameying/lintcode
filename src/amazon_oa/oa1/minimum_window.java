package src.amazon_oa.oa1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by stameying on 2/25/16.
 */
public class minimum_window {


    public static List<Integer> minSlidingWindow(int[] nums, int k){
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return res; // special case

        //
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k-1; i++) {
            int curNum = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] >= curNum) deque.removeLast();
            deque.addLast(i);
        }

        for (int i = k-1; i < nums.length; i++){
            int curNum = nums[i];
            while (!deque.isEmpty() && nums[deque.getLast()] >= curNum) deque.removeLast();
            deque.addLast(i);
            while (!deque.isEmpty() && (i-deque.getFirst()+1) > k) deque.removeFirst();
            res.add(nums[deque.getFirst()]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,12,11,-5};
        System.out.println(minSlidingWindow(nums,2));
    }
}
