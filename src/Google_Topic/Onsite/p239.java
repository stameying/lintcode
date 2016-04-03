package src.Google_Topic.Onsite;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by stameying on 3/31/16.
 */
public class p239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k-1; i++){
            int num = nums[i];
            while (!queue.isEmpty() && nums[queue.peekLast()] < num){
                queue.pollLast();
            }
            queue.addLast(i);
        }

        int[] res = new int[nums.length-k+1];
        int idx = 0;
        for (int i = k-1; i < nums.length; i++){
            while (!queue.isEmpty() && queue.peekFirst() < (i-k+1)){
                queue.removeFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            res[idx++] = nums[queue.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,3)));
    }
}
