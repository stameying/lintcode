package EPI.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by stameying on 2/14/16.
 */
public class maxium_sliding_window {

    public int[] slidingMax(int[] nums, int k){
        int n = nums.length;
        int[] res = new int[n+1-k];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) queue.removeLast();
            queue.addLast(i);
            if (i < k-1) continue;
            while (!queue.isEmpty() && i-k >= queue.getFirst()) queue.removeFirst();
            res[i-k+1] = nums[queue.getFirst()];
        }
        return res;
    }
}
