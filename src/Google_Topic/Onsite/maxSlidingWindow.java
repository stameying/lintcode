package src.Google_Topic.Onsite;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by stameying on 4/5/16.
 */
public class maxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums == null || nums.length == 0) return new int[0];

        //维护一个最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){ return i2-i1; }
        });

        int[] res = new int[nums.length + 1 - k];

        for (int i = 0; i < nums.length; i++){
            if (maxHeap.size() >= k) maxHeap.remove(nums[i-k]);
            maxHeap.offer(nums[i]);
            if (maxHeap.size() == k) res[i+1-k] = maxHeap.peek();
        }

        return res;
    }
}
